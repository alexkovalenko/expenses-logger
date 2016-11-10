import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule, JsonpModule} from '@angular/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AppComponent} from './app.component';
import {ExpenseFormComponent} from "./expense-form/expense-form.component";
import {ExpensesGridComponent} from './expenses-grid/expenses-grid.component';
import {FileUploadModule} from "ng2-file-upload";
import {CommonModule} from "@angular/common";
import { NameAutocompleteComponent } from './name-autocomplete/name-autocomplete.component';

@NgModule({
  declarations: [
    AppComponent,
    ExpenseFormComponent,
    ExpensesGridComponent,
    NameAutocompleteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NgbModule.forRoot(),
    FileUploadModule,
    ReactiveFormsModule,
    CommonModule,
    JsonpModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
