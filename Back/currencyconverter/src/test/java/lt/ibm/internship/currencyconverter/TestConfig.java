package lt.ibm.internship.currencyconverter;

import lt.ibm.internship.currencyconverter.entities.CurrencyCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc

public class TestConfig {

    @Bean
    public CurrencyCalculator currencyCalculator() {
        return new CurrencyCalculator();
    }
}