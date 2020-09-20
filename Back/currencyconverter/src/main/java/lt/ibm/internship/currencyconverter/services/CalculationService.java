package lt.ibm.internship.currencyconverter.services;

import lt.ibm.internship.currencyconverter.entities.Currency;

/*
* Use with the currencies
* Fields:
*   currencyFrom - Currency to exchange from,
*   currencyTo - Currency to exchange to,
*   amountFrom - Amount to exchange to.
*   returns
*
* */
public interface CalculationService {

    Currency getExchangedCurrency(Currency currencyFrom, Currency currencyTo, double amountFrom);
}
