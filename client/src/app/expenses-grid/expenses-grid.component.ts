import {Component, OnInit} from '@angular/core';
import {ExpenseService} from "../expense.service";
import {Expense} from "../expense";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'

@Component({
  selector: 'app-expenses-grid',
  templateUrl: './expenses-grid.component.html',
  styleUrls: ['./expenses-grid.component.css'],
  providers: [ExpenseService]
})
export class ExpensesGridComponent implements OnInit {

  expenses: Expense[];
  aggregationSum: number;

  constructor(private expenseService: ExpenseService) {
  }

  onAggregationButtonClick(aggregationLevel: string) {
    this.expenseService.fetchExpenses(aggregationLevel).map(response => response.json()).subscribe(
      expenses => this.setExpenses(expenses),
      err => console.log(`Got error during expenses fetching for aggregation level ${aggregationLevel}`, err));
  }

  setExpenses(expenses: Expense[]) {
    this.expenses = expenses;
    let sum = 0;
    this.expenses.forEach((expense: Expense) => sum += expense.value);
    this.aggregationSum = sum;
  }

  ngOnInit() {
  }

}
