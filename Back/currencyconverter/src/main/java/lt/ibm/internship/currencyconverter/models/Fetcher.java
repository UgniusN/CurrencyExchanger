package lt.ibm.internship.currencyconverter.models;

import lt.ibm.internship.currencyconverter.entities.Currency;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Fetcher implements FetcherInterface, Parser<Currency>{

    public Document getDocumentFromAPI(String url) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = db.parse(new URL(url).openStream());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        return doc;
    }

    public List<Currency> parseFromXML(NodeList nodeList) {
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