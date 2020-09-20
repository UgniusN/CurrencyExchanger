package lt.ibm.internship.currencyconverter.repositories;

import lt.ibm.internship.currencyconverter.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,String> {
}