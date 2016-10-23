package org.alexkovalenko.service;

import org.alexkovalenko.data.generated.tables.pojos.Expense;
import org.alexkovalenko.data.generated.tables.records.ExpenseRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DatePart;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.alexkovalenko.data.generated.Tables.EXPENSE;
import static org.jooq.DatePart.DAY;
import static org.jooq.DatePart.MONTH;
import static org.jooq.impl.DSL.currentDate;
import static org.jooq.impl.DSL.dateSub;

@Service
public class ExpenseService {

    private final DSLContext dslContext;
    private final ModelMapper mapper;

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
