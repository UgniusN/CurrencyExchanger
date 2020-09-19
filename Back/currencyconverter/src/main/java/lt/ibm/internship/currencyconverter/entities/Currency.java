package lt.ibm.internship.currencyconverter.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "currencies")
@NoArgsConstructor
public class Currency {

    public Currency(String currency, Double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    @Id
    @Column(name = "currency")
    private String currency;

    @NotNull
    @Column(name = "rate")
    private Double rate;
}