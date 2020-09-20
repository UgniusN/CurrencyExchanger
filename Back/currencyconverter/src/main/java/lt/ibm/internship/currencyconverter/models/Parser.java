package lt.ibm.internship.currencyconverter.models;

import org.w3c.dom.NodeList;
import java.util.List;

/*
* The parser interface parses the elements from the NodeList
* Parser is best used with the Fetcher class.
* */
public interface Parser<T> {

    List<T> parseFromXML(NodeList nodeList);
}