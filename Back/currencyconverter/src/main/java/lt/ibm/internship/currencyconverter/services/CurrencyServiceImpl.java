package lt.ibm.internship.currencyconverter.services;

import lombok.AllArgsConstructor;
import lt.ibm.internship.currencyconverter.entities.Currency;
import lt.ibm.internship.currencyconverter.fetchers.lb_fetcher.LbFetcher;
import lt.ibm.internship.currencyconverter.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService{

    private CurrencyRepository currencyRepository;

    private LbFetcher lbFetcher;

    private CalculationServiceImpl calculationService;

    private MessageServiceImpl messageService;

    public void updateCurrencies() {
        List<Currency> currencies = lbFetcher.fetchCurrencies();
        currencies.stream().forEach(currency -> currencyRepository.save(currency));
    }

    public List<Currency> getCurrencies() {
        List<Currency> currencies = currencyRepository.findAll();
        return currencies;
    }

    public Optional<Currency> getCurrencyById(String currencyTitle) {
        return currencyRepository.findById(currencyTitle);
    }


    public Currency getCalculatedCurrency(String currencyFrom, String currencyTo, double amountTo) {
        Currency fromCurrency = currencyRepository.findById(currencyFrom).orElseThrow();
        Currency toCurrency = currencyRepository.findById(currencyTo).orElseThrow();
        Currency convertedCurrency = calculationService.getExchangedCurrency(fromCurrency,toCurrency,amountTo);
        messageService.saveUserExchangeAction(fromCurrency,toCurrency,amountTo,convertedCurrency);
        return convertedCurrency;
    }
}