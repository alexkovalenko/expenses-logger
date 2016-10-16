package org.alexkovalenko.service;

import org.alexkovalenko.data.generated.tables.daos.ExpenseDao;
import org.alexkovalenko.data.generated.tables.pojos.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseDao dao;

    @Autowired
    public ExpenseService(ExpenseDao dao) {
        this.dao = dao;
    }

    public void addExpense(Expense expense) {
        dao.insert(expense);
    }
}
