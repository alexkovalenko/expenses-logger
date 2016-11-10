package org.alexkovalenko.service;

import com.opencsv.CSVParser;
import org.alexkovalenko.data.generated.tables.pojos.Expense;
import org.alexkovalenko.data.generated.tables.records.ExpenseRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DatePart;
import org.jooq.tools.csv.CSVReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.alexkovalenko.data.generated.Tables.EXPENSE;
import static org.jooq.DatePart.DAY;
import static org.jooq.DatePart.MONTH;
import static org.jooq.impl.DSL.currentDate;
import static org.jooq.impl.DSL.dateSub;

@Service
public class ExpenseService {

    private final DSLContext dslContext;
    private final ModelMapper mapper;
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Autowired
    public ExpenseService(DSLContext dslContext, ModelMapper mapper) {
        this.dslContext = dslContext;
        this.mapper = mapper;
    }

    public void save(Expense expense) {
        ExpenseRecord record = mapper.map(expense, ExpenseRecord.class);
        dslContext.batchStore(record).execute();
    }

    public List<Expense> find(AggregationLevel aggregationLevel) {
        return dslContext.
                selectFrom(EXPENSE).
                where(getAggregationCondition(aggregationLevel)).
                orderBy(EXPENSE.DATE, EXPENSE.NAME).
                fetch().
                map(record -> mapper.map(record, Expense.class));
    }

    public void importFromFile(MultipartFile file) {
        try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream(),
                StandardCharsets.UTF_8), CSVParser.DEFAULT_SEPARATOR, CSVParser.DEFAULT_QUOTE_CHARACTER, 1)) {
            while (reader.hasNext()) {
                String[] line = reader.next();
                String dateString = line[0];
                String name = line[1];
                String value = line[2];
                String description = line[3];
                save(new Expense(null, name, description, new BigDecimal(value), parseDate(dateString)));
            }
        } catch (Exception ignore) {
        }
    }

    public List<String> getNames() {
        return dslContext.selectDistinct(EXPENSE.NAME)
                .from(EXPENSE)
                .fetch(EXPENSE.NAME)
                .stream()
                .map(String::toLowerCase)
                .collect(toList());
    }

    private Date parseDate(String dateString) throws ParseException {
        return new Date(dateFormat.parse(dateString).getTime());
    }

    private Condition getAggregationCondition(AggregationLevel aggregationLevel) {
        Condition condition = EXPENSE.DATE.isNotNull();
        switch (aggregationLevel) {
            case DAY:
                condition = getDateIntervalCondition(DAY);
                break;
            case MONTH:
                condition = getDateIntervalCondition(MONTH);
                break;
        }
        return condition;
    }

    private Condition getDateIntervalCondition(DatePart datePart) {
        return EXPENSE.DATE.greaterOrEqual(dateSub(currentDate(), 1, datePart));
    }
}
