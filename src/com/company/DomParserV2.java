package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class DomParserV2 {

    private static final String fileName = "C:\\Users\\razm1\\IdeaProjects\\CardGame\\src\\com\\company\\cardgame.xml";

    public ArrayList<Card> parse() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fileName));
            ArrayList<Card> cards = new ArrayList<>();

            NodeList nodeList = doc.getElementsByTagName("Card");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {

                Node node = nodeList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get text
                    String cardValue = element.getElementsByTagName("CardValue").item(0).getTextContent();
                    String suit = element.getElementsByTagName("Suit").item(0).getTextContent();

                    Suit suitConverted = Suit.valueOf(suit.toUpperCase(Locale.ROOT));
                    int cardValueConverted = Integer.parseInt(cardValue);

                    cards.add(new Card(suitConverted, cardValueConverted));
                }
            }
            return cards;
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}