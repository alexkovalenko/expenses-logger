import {Component, Input} from '@angular/core';
import {Expense} from "../Expense";
import {ExpenseService} from "../expense.service";

@Component({
  selector: 'expense-form',
  templateUrl: './expense-form.component.html',
  styleUrls: ['./expense-form.component.css'],
  providers: [ExpenseService]
})
export class ExpenseFormComponent {
  @Input()
  public alert: Alert;
  expense: Expense;

  constructor(private expenseService: ExpenseService) {
    this.expense = new Expense();
  }

  public addExpence() {
    this.expenseService.addExpense(this.expense).subscribe(
      response => {
        this.showSuccessMessage('success', 'Successfully saved expense')
      },
      err => {
        this.showSuccessMessage('danger', 'Failed to save expense');
        console.log(err);
      }
    );
    this.expense = new Expense();
  }

  public showSuccessMessage(type: string, message: string) {
    this.alert = new Alert(type, message, true);
    setTimeout(()=> this.alert.visible = false, 5000);
  }
}

export class Alert {
  constructor(public type: string, public message: string, public visible: boolean) {
  }
}
