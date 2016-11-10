import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions} from "@angular/http";
import {Expense} from "./expense";
import {Observable} from 'rxjs/Rx';

export const baseUrl: string = window.location.origin;

@Injectable()
export class ExpenseService {

  constructor(private http: Http) {
  }

  public addExpense(expense: Expense): Observable<any> {
    let body = JSON.stringify(expense);
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.post(`${baseUrl}/expense`, body, options);
  }

  public fetchExpenses(aggregationLevel: string): Observable<any> {
    return this.http.get(`${baseUrl}/expense/${aggregationLevel}`);
  }

  public fetchNames(): Observable<any> {
    return this.http.get(`${baseUrl}/expense/name`);
  }
}
