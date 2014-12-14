package com.epam.parser;

import com.epam.entity.Tour;
import com.epam.entity.Treatment;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomXmlEntityParser implements XmlEntityParser {
    private static Logger logger = Logger.getLogger(XmlEntityParser.class);

    @Override
    public Tour parseTour(File stream) {
        Treatment treatment = new Treatment();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(stream);
            logger.info("Root element " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName("treatment");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                treatment.setId(new Long(element.getAttribute("id")));
                treatment.setPrice(Integer.parseInt(element.getElementsByTagName("price").item(0).getChildNodes().item(0).getNodeValue()));
                treatment.setNumberOfDays(Integer.parseInt(element.getElementsByTagName("numberOfDays").item(0).getChildNodes().item(0).getNodeValue()));
                treatment.setCountry(element.getElementsByTagName("country").item(0).getChildNodes().item(0).getNodeValue());
                treatment.setClinicName(element.getElementsByTagName("clinicName").item(0).getChildNodes().item(0).getNodeValue());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return treatment;
    }
}
