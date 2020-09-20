package lt.ibm.internship.currencyconverter.controllers;

import lombok.AllArgsConstructor;
import lt.ibm.internship.currencyconverter.dto.CurrencyDTO;
import lt.ibm.internship.currencyconverter.entities.Currency;
import lt.ibm.internship.currencyconverter.services.CurrencyService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class CurrencyController {

    private CurrencyService currencyService;

    @GetMapping
    public List<CurrencyDTO> getAllCurrencies() {
        currencyService.updateCurrencies();
        List<Currency> currencies = currencyService.getCurrencies();
        List<CurrencyDTO> currencyDTOList = currencies.stream()
                .map(currency -> {
                    return CurrencyDTO.builder().currency(currency.getCurrency()).rate(currency.getRate()).build();
                        }).collect(Collectors.toList());
        return currencyDTOList;
    }

    @PostMapping("/getconvertedcurrency")
    public CurrencyDTO getConvertedCurrency(@RequestParam(name = "CurrencyFrom") String currencyFrom,
                                            @RequestParam(name = "CurrencyTo") String currencyTo,
                                            @RequestParam(name = "CurrencyToAmount") Double currencyToAmount)
    {
        Currency convertedCurrency = currencyService.getCalculatedCurrency(currencyFrom,currencyTo,currencyToAmount);
        return CurrencyDTO.builder().currency(convertedCurrency.getCurrency())
                                        .rate(convertedCurrency.getRate())
                                        .build();
    }

}