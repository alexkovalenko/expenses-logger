import {Component, OnInit} from '@angular/core';
import {ExpenseService} from "../expense.service";
import {Observable} from "rxjs";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';

@Component({
  selector: 'name-autocomplete',
  templateUrl: './name-autocomplete.component.html',
  styleUrls: ['./name-autocomplete.component.css']
})
export class NameAutocompleteComponent implements OnInit {

  name: string;
  names: string[];
  filteredNames = (text$: Observable<string>) =>
    text$.debounceTime(200)
      .distinctUntilChanged()
      .map(term => term.length < 2 ? []
        : this.names.filter(v => new RegExp(term, 'gi').test(v)).splice(0, 10));

  constructor(private expenseService: ExpenseService) {
  }

  ngOnInit(): void {
    this.expenseService.fetchNames().map(response => response.json()).subscribe(
      names => this.names = names,
      err => console.log(`Got error during expenses name fetching`, err));
  }
}
