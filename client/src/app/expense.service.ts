import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions} from "@angular/http";
import {Expense} from "./expense";
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'

@Injectable()
export class ExpenseService {

  private baseUrl: string = 'http://localhost:8080';

  constructor(private http: Http) {
  }

  public addExpense(expense: Expense): Observable<any> {
    console.log('Sending expense to server:', expense);
    let body = JSON.stringify(expense);
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.post(`${this.baseUrl}/expense`, body, options);
  }
}
