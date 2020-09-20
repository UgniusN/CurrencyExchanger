package lt.ibm.internship.currencyconverter.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "messages")
@NoArgsConstructor
public class Message {

    public Message(long id, String message, String date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    private String date;
}