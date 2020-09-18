package lt.ibm.internship.currencyconverter.controllers;


import lt.ibm.internship.currencyconverter.entities.Currency;
import lt.ibm.internship.currencyconverter.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public List<Currency> getAllCurrencies() throws ParserConfigurationException, SAXException, IOException {
        currencyService.updateCurrencies();
        return currencyService.getCurrencies();
    }

    @PostMapping("/getconvertedcurrency")
    public Currency getConvertedCurrency(@RequestParam(name = "CurrencyFrom") String currencyFrom,
                                         @RequestParam(name = "CurrencyTo") String currencyTo,
                                         @RequestParam(name = "CurrencyToAmount") Double currencyToAmount) {
        Currency fromCurrency = currencyService.getCurrencyById(currencyFrom).get();
        Currency toCurrency = currencyService.getCurrencyById(currencyTo).get();
        return currencyService.getCalculatedCurrency(fromCurrency,toCurrency,currencyToAmount);
    }

}
