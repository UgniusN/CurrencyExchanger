package lt.ibm.internship.currencyconverter.models;

import org.w3c.dom.Document;

/*
 * The FetcherInterface allows to receive the Document from the wanted URL.
 * The URL is mandatory in order to retrieve the Document.
 * */
public interface FetcherInterface {

    Document getDocumentFromAPI(String url);
}