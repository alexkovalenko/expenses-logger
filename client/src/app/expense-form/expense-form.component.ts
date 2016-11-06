import {Component} from '@angular/core';
import {Expense} from "../Expense";
import {ExpenseService, baseUrl} from "../expense.service";
import {FileUploader} from "ng2-file-upload";

@Component({
  selector: 'expense-form',
  templateUrl: './expense-form.component.html',
  styleUrls: ['./expense-form.component.css'],
  providers: [ExpenseService]
})
export class ExpenseFormComponent {
  alert: Alert;
  expense: Expense;
  uploader: FileUploader = new FileUploader({url: `${baseUrl}/expense/import`});

  constructor(private expenseService: ExpenseService) {
    this.alert = new Alert('none', false);
    this.expense = new Expense();
  }

  addExpence() {
    this.expenseService.addExpense(this.expense).subscribe(
      response => {
        this.showSuccessMessage('check')
      },
      err => {
        this.showSuccessMessage('close');
        console.log(err);
      }
    );
    this.expense = new Expense();
  }

  showSuccessMessage(type: string) {
    this.alert = new Alert(type, true);
    setTimeout(()=> this.alert.visible = false, 5000);
  }
}

export class Alert {
  constructor(public type: string, public visible: boolean) {
  }
}
