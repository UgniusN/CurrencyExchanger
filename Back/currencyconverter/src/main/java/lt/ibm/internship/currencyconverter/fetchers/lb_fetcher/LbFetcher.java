package lt.ibm.internship.currencyconverter.fetchers.lb_fetcher;

import lt.ibm.internship.currencyconverter.entities.Currency;
import lt.ibm.internship.currencyconverter.models.Fetcher;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.util.List;

@Component
public final class LbFetcher extends Fetcher implements CurrencyFetcher {
    private final String URL = "https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=eu";

    @Override
    public Document getDocumentFromAPI(String url) {
        return super.getDocumentFromAPI(url);
    }

    public List<Currency> parseCurrenciesFromXML(NodeList nodeList) {
        return super.parseFromXML(nodeList);
    }

    @Override
    public List<Currency> fetchCurrencies() {
        NodeList nodeList = getDocumentFromAPI(URL).getElementsByTagName("FxRate");
        return parseCurrenciesFromXML(nodeList);
    }
}