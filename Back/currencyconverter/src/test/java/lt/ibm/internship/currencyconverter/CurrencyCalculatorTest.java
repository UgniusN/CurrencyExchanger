package lt.ibm.internship.currencyconverter;

import lt.ibm.internship.currencyconverter.entities.CurrencyCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CurrencyCalculatorTest {

    @Autowired
    private CurrencyCalculator currencyCalculator;

    @Test
    public void numberIsDividedCorrectlyAssertionPass() {
        double currency1 = 3.06;
        double currency2 = 1.02;
        double actualNumber = currency2/currency1;

        double expectedNumber = currencyCalculator.getOneCurrencyExchange(currency1,currency2);

        Assertions.assertEquals(actualNumber,expectedNumber);
    }
}