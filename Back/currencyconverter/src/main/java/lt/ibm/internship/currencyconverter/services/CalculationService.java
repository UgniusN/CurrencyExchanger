package lt.ibm.internship.currencyconverter.services;

import lt.ibm.internship.currencyconverter.entities.Currency;
import org.springframework.stereotype.Service;


public interface CalculationService {

    Currency getExchangedCurrency(Currency currencyFrom, Currency currencyTo, double amountFrom);
}
