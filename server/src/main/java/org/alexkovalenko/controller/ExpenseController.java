package org.alexkovalenko.controller;

import org.alexkovalenko.data.generated.tables.pojos.Expense;
import org.alexkovalenko.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addExpense(Expense expense) {
        expenseService.addExpense(expense);
    }
}
