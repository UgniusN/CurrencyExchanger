package lt.ibm.internship.currencyconverter.models;

import lt.ibm.internship.currencyconverter.entities.Currency;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Currency> parseCurrenciesFromXML(NodeList nodeList) {
        List<Currency> currencyList = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                currencyList.add(new Currency(
                        element.getElementsByTagName("Ccy").item(1).getTextContent(),
                        Double.parseDouble(element.getElementsByTagName("Amt").item(1).getTextContent())
                ));
            }
        }
        return currencyList;
    }
}