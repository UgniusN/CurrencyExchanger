package lt.ibm.internship.currencyconverter.models;

import lt.ibm.internship.currencyconverter.entities.Currency;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageFormatter {

    public String formMessage(Currency startCurrency,double amount, Currency endCurrency, Currency exchangedCurrency) {
        return "User exchanged " + amount + " " + startCurrency.getCurrency() + " to " + endCurrency.getCurrency() + ". Exchanged result: " + exchangedCurrency.getRate() + " " + exchangedCurrency.getCurrency();
    }

    public String getFormedDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return format.format(date);
    }
}