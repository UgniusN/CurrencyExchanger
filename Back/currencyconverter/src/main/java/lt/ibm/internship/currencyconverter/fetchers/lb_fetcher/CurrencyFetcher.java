package lt.ibm.internship.currencyconverter.fetchers.lb_fetcher;

import lt.ibm.internship.currencyconverter.entities.Currency;
import java.util.List;

/*
* Use the interface with a new fetcher.
* The interface is also used with the Parser
* In order to retrieve the currencies, parse the fetched data.
*
* */
public interface CurrencyFetcher {

    List<Currency> fetchCurrencies();
}