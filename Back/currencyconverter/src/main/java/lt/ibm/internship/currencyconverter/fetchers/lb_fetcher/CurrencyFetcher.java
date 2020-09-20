package lt.ibm.internship.currencyconverter.fetchers.lb_fetcher;

import lt.ibm.internship.currencyconverter.entities.Currency;
import java.util.List;

public interface CurrencyFetcher {

    public List<Currency> fetchCurrencies();

}
