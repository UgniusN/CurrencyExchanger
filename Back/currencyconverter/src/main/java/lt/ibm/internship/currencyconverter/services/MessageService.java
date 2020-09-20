package lt.ibm.internship.currencyconverter.services;

import lt.ibm.internship.currencyconverter.entities.Currency;
import org.springframework.stereotype.Service;

public interface MessageService {

    void saveUserExchangeAction(Currency startCurrency, Currency endCurrency, double amount, Currency exchangedCurrency);
}
