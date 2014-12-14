package com.epam.parser;

import com.epam.entity.Tour;
import com.epam.entity.Treatment;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxXmlEntityParser implements XmlEntityParser {

    private Treatment treatment = new Treatment();
    private static Logger logger = Logger.getLogger(XmlEntityParser.class);

    public Tour parseTour(File stream) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            factory.setValidating(true);
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(stream, new TourDefaultHandler());
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return treatment;
    }

    public class TourDefaultHandler extends DefaultHandler {


        private String currElement;
        private StringBuilder builder = new StringBuilder();


        @Override
        public void startDocument() throws SAXException {
            logger.info("parsing has started");
        }

        @Override
        public void endDocument() throws SAXException {
            logger.info("parsing has ended");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currElement = qName;
            builder.setLength(0);
            if (currElement.equals("treatment")) {
                treatment.setId(new Long(String.valueOf(attributes.getValue(0))));
            }
            builder.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currElement == null) return;
            String s = builder.toString().trim();
            switch (currElement) {
                case "price":
                    treatment.setPrice(Integer.parseInt(s));
                    break;
                case "numberOfDays":
                    treatment.setNumberOfDays(Integer.parseInt(s));
                    break;
                case "country":
                    treatment.setCountry(s);
                    break;
                case "clinicName":
                    treatment.setClinicName(s);
                    break;
            }
            currElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            builder.append(ch, start, length);


        }

        public Tour getTour() {
            return treatment;
        }

    }


}
