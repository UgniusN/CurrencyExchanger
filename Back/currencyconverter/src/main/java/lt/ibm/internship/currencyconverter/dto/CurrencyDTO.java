package lt.ibm.internship.currencyconverter.dto;

import lombok.Data;
import lt.ibm.internship.currencyconverter.entities.Currency;

@Data
public class CurrencyDTO {

    private String currency;

    private Double rate;

    public CurrencyDTO(Currency currency) {
        this.currency = currency.getCurrency();
        this.rate = currency.getRate();
    }
}
