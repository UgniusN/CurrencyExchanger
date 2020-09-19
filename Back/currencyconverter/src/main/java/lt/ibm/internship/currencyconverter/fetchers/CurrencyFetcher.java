package lt.ibm.internship.currencyconverter.fetchers;

import lt.ibm.internship.currencyconverter.entities.Currency;
import lt.ibm.internship.currencyconverter.models.Fetcher;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;
import java.util.List;

@Service
public class CurrencyFetcher extends Fetcher {

    public List<Currency> fetchCurrencies() {
        NodeList nodeList = getDocumentFromAPI("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=eu").getElementsByTagName("FxRate");
        return parseCurrenciesFromXML(nodeList);
    }
}