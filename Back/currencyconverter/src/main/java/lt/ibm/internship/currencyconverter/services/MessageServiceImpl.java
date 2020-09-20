package lt.ibm.internship.currencyconverter.services;

import lt.ibm.internship.currencyconverter.entities.Currency;
import lt.ibm.internship.currencyconverter.entities.Message;
import lt.ibm.internship.currencyconverter.models.MessageFormatter;
import lt.ibm.internship.currencyconverter.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends MessageFormatter implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void saveUserExchangeAction(Currency startCurrency, Currency endCurrency,double amount, Currency exchangedCurrency) {
        Message message = new Message();
        message.setMessage(formMessage(startCurrency,amount,endCurrency,exchangedCurrency));
        message.setDate(getFormedDate());
        messageRepository.save(message);
    }
}