package lt.ibm.internship.currencyconverter.controllers;

import lt.ibm.internship.currencyconverter.dto.CurrencyDTO;
import lt.ibm.internship.currencyconverter.entities.Currency;
import lt.ibm.internship.currencyconverter.services.CurrencyService;
import lt.ibm.internship.currencyconverter.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<CurrencyDTO> getAllCurrencies() {
        currencyService.updateCurrencies();
        List<CurrencyDTO> currencyDTOList = new ArrayList<>();
        currencyService.getCurrencies()
                        .stream()
                        .forEach(currency -> currencyDTOList.add(new CurrencyDTO.Builder().rate(currency.getRate())
                                                                                      .currency(currency.getCurrency())
                                                                                      .build()));
        return currencyDTOList;
    }

    @PostMapping("/getconvertedcurrency")
    public CurrencyDTO getConvertedCurrency(@RequestParam(name = "CurrencyFrom") String currencyFrom,
                                            @RequestParam(name = "CurrencyTo") String currencyTo,
                                            @RequestParam(name = "CurrencyToAmount") Double currencyToAmount)
    {
        Currency fromCurrency = currencyService.getCurrencyById(currencyFrom).get();
        Currency toCurrency = currencyService.getCurrencyById(currencyTo).get();
        Currency convertedCurrency = currencyService.getCalculatedCurrency(fromCurrency,toCurrency,currencyToAmount);
        messageService.saveUserExchangeAction(fromCurrency,toCurrency,currencyToAmount,convertedCurrency);
        return new CurrencyDTO.Builder().currency(convertedCurrency.getCurrency())
                                        .rate(convertedCurrency.getRate())
                                        .build();
    }

}
