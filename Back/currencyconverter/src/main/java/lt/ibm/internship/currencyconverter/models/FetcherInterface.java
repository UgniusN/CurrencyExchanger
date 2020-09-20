package lt.ibm.internship.currencyconverter.models;

import org.w3c.dom.Document;

public interface FetcherInterface {

    Document getDocumentFromAPI(String url);
}
