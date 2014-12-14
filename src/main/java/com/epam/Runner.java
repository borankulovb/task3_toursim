package com.epam;

import com.epam.entity.Tour;
import com.epam.parser.DomXmlEntityParser;
import com.epam.parser.SaxXmlEntityParser;
import com.epam.parser.StaxXmlEntityParser;
import com.epam.parser.XmlEntityParser;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

public class Runner {
    private static Logger logger = Logger.getLogger(XmlEntityParser.class);

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XMLStreamException {

        File xmlFile = new File("src/main/resources/tourism.xml");
        logger.info("========Dom Parser========");
        XmlEntityParser domParser = new DomXmlEntityParser();
        Tour tour1 = domParser.parseTour(xmlFile);
        logger.info(String.valueOf(tour1));


        logger.info("========StAX Parser========");
        XmlEntityParser staxParser = new StaxXmlEntityParser();
        Tour tour2 = staxParser.parseTour(xmlFile);
        logger.info(String.valueOf(tour2));

        logger.info("========SAX Parser========");

        XmlEntityParser saxParser = new SaxXmlEntityParser();
        Tour tour3 = saxParser.parseTour(xmlFile);
        logger.info(String.valueOf(tour3));
    }


}
