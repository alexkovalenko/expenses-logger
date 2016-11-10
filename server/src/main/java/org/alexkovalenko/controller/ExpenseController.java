package org.alexkovalenko.controller;

import org.alexkovalenko.data.generated.tables.pojos.Expense;
import org.alexkovalenko.service.AggregationLevel;
import org.alexkovalenko.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/name")
    @ResponseBody
    public List<String> getNames() {
        return expenseService.getNames();
    }

    @GetMapping("/{aggregationLevel}")
    @ResponseBody
    public List<Expense> find(@PathVariable("aggregationLevel") AggregationLevel aggregationLevel) {
        return expenseService.find(aggregationLevel);
    }

    @PostMapping("/import")
    @ResponseBody
    public ResponseEntity<?> importFromFile(@RequestParam("file") MultipartFile file) {
        expenseService.importFromFile(file);
        return ResponseEntity.ok().build();
    }
}
