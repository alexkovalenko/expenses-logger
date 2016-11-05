import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AppComponent} from './app.component';
import {ExpenseFormComponent} from "./expense-form/expense-form.component";
import {ExpensesGridComponent} from './expenses-grid/expenses-grid.component';
import {FileUploadModule} from "ng2-file-upload";

@NgModule({
  declarations: [
    AppComponent,
    ExpenseFormComponent,
    ExpensesGridComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NgbModule.forRoot(),
    FileUploadModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
