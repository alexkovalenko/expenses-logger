import { ExpensesLoggerPage } from './app.po';

describe('expenses-logger App', function() {
  let page: ExpensesLoggerPage;

  beforeEach(() => {
    page = new ExpensesLoggerPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
