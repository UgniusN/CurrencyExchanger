package lt.ibm.internship.currencyconverter.entities;

import lt.ibm.internship.currencyconverter.models.Calculator;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyCalculator implements Calculator {

    @Override
    public double getOneCurrencyExchange(double currencyFrom, double currencyTo) {
        return currencyTo/currencyFrom;
    }

    public Currency getExchangedCurrency(Currency startCurrency, Currency endCurrency , double amountTo) {
        double course = getOneCurrencyExchange(startCurrency.getRate(),endCurrency.getRate());
        double amount = course * amountTo;
        BigDecimal amountRounded = BigDecimal.valueOf(amount).setScale(5, RoundingMode.HALF_UP);
        return new Currency(endCurrency.getCurrency(),amountRounded.doubleValue());
    }
}