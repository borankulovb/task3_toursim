package com.epam;

import com.epam.entity.Tour;
import com.epam.parser.DomParser;
import com.epam.parser.XMLParserFactory;

import java.io.File;

public class Runner {
    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/tourism.xml");

        XMLParserFactory domParser = new DomParser();
        Tour tour1 =domParser.parserTours(xmlFile);

    }


}
