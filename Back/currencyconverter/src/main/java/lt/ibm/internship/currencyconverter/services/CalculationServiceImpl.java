package lt.ibm.internship.currencyconverter.services;

import lombok.AllArgsConstructor;
import lt.ibm.internship.currencyconverter.entities.Currency;
import lt.ibm.internship.currencyconverter.entities.CurrencyCalculator;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalculationServiceImpl implements CalculationService{

    private CurrencyCalculator currencyCalculator;

    public Currency getExchangedCurrency(Currency currencyFrom, Currency currencyTo, double amountFrom) {
        return currencyCalculator.getExchangedCurrency(currencyFrom,currencyTo,amountFrom);
    }
}