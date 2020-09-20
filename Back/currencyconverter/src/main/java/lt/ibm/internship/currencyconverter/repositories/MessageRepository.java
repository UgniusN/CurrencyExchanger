package lt.ibm.internship.currencyconverter.repositories;

import lt.ibm.internship.currencyconverter.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}