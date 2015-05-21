package com.choubida.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.StringReader;


public class XmlReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlReader.class);

    /**
     * Reads values from xml
     *
     * @throws XMLStreamException
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public static String readValue(String request, String tagName)
            throws XMLStreamException, SAXException, IOException, ParserConfigurationException {
        String torrentTarget = null;

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(request));
        Document doc = builder.parse(is);


        NodeList items = doc.getElementsByTagName(tagName);

        if (items.getLength() > 0) {
            if (items.getLength() == 1) {
                return items.item(0).getFirstChild().getNodeValue();
            }
        }

        return torrentTarget;
    }

    /**
     * Gets the value of an element
     *
     * @param parent   parent node
     * @param nodeName name of the node
     * @return value of the node
     */
    public static String getValue(Element parent, String nodeName) {
        return parent.getElementsByTagName(nodeName).item(0).getFirstChild().getNodeValue();
    }

    /**
     * Gets the value of an element
     *
     * @param parent        parent node
     * @param attributeName name of the node  @return value of the node
     */
    public static String getValueAttribute(Element parent, String attributeName) {
        return parent.getAttribute(attributeName);
    }
}
