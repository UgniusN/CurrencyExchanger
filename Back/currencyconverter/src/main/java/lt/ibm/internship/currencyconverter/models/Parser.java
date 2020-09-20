package lt.ibm.internship.currencyconverter.models;

import lt.ibm.internship.currencyconverter.entities.Currency;
import org.w3c.dom.NodeList;

import java.util.List;

public interface Parser {

    List<Currency> parseCurrenciesFromXML(NodeList nodeList);
}
