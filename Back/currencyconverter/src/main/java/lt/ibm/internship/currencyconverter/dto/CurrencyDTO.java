package lt.ibm.internship.currencyconverter.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;

@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CurrencyDTO {

    private final String currency;
    private final double rate;
}