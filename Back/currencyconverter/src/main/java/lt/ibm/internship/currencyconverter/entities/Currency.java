package lt.ibm.internship.currencyconverter.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Currency {

    @Id
    @Column(name = "currency")
    private String currency;

    @NotNull
    @Column(name = "rate")
    private Double rate;
}