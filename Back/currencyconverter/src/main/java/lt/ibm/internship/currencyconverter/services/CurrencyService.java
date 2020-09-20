package lt.ibm.internship.currencyconverter.services;

import lt.ibm.internship.currencyconverter.entities.Currency;
import java.util.List;
import java.util.Optional;

public interface CurrencyService {

    void updateCurrencies();

    List<Currency> getCurrencies();

    Optional<Currency> getCurrencyById(String currencyTitle);

    Currency getCalculatedCurrency(String currencyFrom, String currencyTo, double amountTo);

}
