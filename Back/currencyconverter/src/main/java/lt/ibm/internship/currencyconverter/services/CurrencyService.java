package lt.ibm.internship.currencyconverter.services;

import lt.ibm.internship.currencyconverter.entities.Currency;
import lt.ibm.internship.currencyconverter.fetchers.CurrencyFetcher;
import lt.ibm.internship.currencyconverter.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyFetcher currencyFetcher;

    @Autowired
    private CalculationService calculationService;

    public void updateCurrencies() throws IOException, ParserConfigurationException, SAXException {
        List<Currency> currencies = currencyFetcher.fetchCurrencies();
        for(Currency currency : currencies) {
            currencyRepository.save(currency);
        }
    }

    public List<Currency> getCurrencies() {
        List<Currency> currencies = currencyRepository.findAll();
        System.out.println(currencies.get(0).getCurrency());
        return currencies;
    }

    public Optional<Currency> getCurrencyById(String currencyTitle) {
        return currencyRepository.findById(currencyTitle);
    }

    public Currency getCalculatedCurrency(Currency currencyFrom, Currency currencyTo, double amountTo) {
        return calculationService.getExchangedCurrency(currencyFrom,currencyTo,amountTo);
    }



}
