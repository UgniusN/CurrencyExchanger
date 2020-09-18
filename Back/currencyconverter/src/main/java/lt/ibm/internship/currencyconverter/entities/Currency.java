package lt.ibm.internship.currencyconverter.entities;


import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currencies")
public class Currency {
    public Currency(){

    }

    public Long getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getRate() {
        return rate;
    }

    public Currency(String currency, Double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    @Column(name = "id")
    private Long id;
    @Id
    @Column(name = "currency")
    private String currency;

    @NotNull
    @Column(name = "rate")
    private Double rate;
}
