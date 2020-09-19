package lt.ibm.internship.currencyconverter.services;

import lt.ibm.internship.currencyconverter.entities.Currency;
import lt.ibm.internship.currencyconverter.entities.CurrencyCalculator;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    private CurrencyCalculator currencyCalculator = new CurrencyCalculator();

    public Currency getExchangedCurrency(Currency currencyFrom, Currency currencyTo, double amountFrom) {
        return currencyCalculator.getExchangedCurrency(currencyFrom,currencyTo,amountFrom);
    }
}