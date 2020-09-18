package lt.ibm.internship.currencyconverter.fetchers;


import lt.ibm.internship.currencyconverter.entities.Currency;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyFetcher {

    public List<Currency> fetchCurrencies() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL("https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=eu").openStream());
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("FxRate");
        List<Currency> currencyList = new ArrayList<>();
        List<String> priceList = new ArrayList<>();
        for(int i=0; i<nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE) {
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
