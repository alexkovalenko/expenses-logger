package org.alexkovalenko.controller;

import org.alexkovalenko.data.generated.tables.pojos.Expense;
import org.alexkovalenko.service.AggregationLevel;
import org.alexkovalenko.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public void save(@RequestBody Expense expense) {
        expenseService.save(expense);
    }

    @GetMapping("/{aggregationLevel}")
    @ResponseBody
    public List<Expense> find(@PathVariable("aggregationLevel") AggregationLevel aggregationLevel) {
        return expenseService.find(aggregationLevel);
    }
}
