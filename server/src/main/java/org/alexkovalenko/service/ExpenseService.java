package org.alexkovalenko.service;

import org.alexkovalenko.data.generated.tables.pojos.Expense;
import org.alexkovalenko.data.generated.tables.records.ExpenseRecord;
import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final DSLContext context;
    private final ModelMapper mapper;

    @Autowired
    public ExpenseService(DSLContext context, ModelMapper mapper) {
        this.context = context;
        this.mapper = mapper;
    }

    public void addExpense(Expense expense) {
        ExpenseRecord record = mapper.map(expense, ExpenseRecord.class);
        context.batchStore(record).execute();
    }
}
