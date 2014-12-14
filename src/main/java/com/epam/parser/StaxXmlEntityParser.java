package com.epam.parser;

import com.epam.entity.Tour;
import com.epam.entity.Treatment;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class StaxXmlEntityParser implements XmlEntityParser {

    private static Logger logger = Logger.getLogger(XmlEntityParser.class);

    @Override
    public Tour parseTour(File stream) throws XMLStreamException, FileNotFoundException {
        Treatment treatment = null;
        String tagContent = null;
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream input = new FileInputStream(String.valueOf(stream));
        XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if ("treatment".equals(reader.getLocalName())) {
                        treatment = new Treatment();
                        treatment.setId(new Long(reader.getAttributeValue(0)));
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "price":
                            treatment.setPrice(Integer.parseInt(tagContent));
                            break;
                        case "numberOfDays":
                            treatment.setNumberOfDays(Integer.parseInt(tagContent));
                            break;
                        case "country":
                            treatment.setCountry(tagContent);
                            break;
                        case "clinicName":
                            treatment.setClinicName(tagContent);
                            break;
                    }
                    break;
                case XMLStreamConstants.START_DOCUMENT:
                    break;
            }
        }
        return treatment;
    }
}
