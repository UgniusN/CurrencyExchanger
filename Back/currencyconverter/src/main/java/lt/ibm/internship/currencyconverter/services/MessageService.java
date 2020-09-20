package lt.ibm.internship.currencyconverter.services;

import lt.ibm.internship.currencyconverter.entities.Currency;

public interface MessageService {

    void saveUserExchangeAction(Currency startCurrency, Currency endCurrency, double amount, Currency exchangedCurrency);
}
