import {Component} from '@angular/core';
import {ExpenseFormComponent} from "./expense-form/expense-form.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ExpenseFormComponent]
})
export class AppComponent {
}
