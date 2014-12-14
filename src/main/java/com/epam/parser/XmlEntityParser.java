package com.epam.parser;

import com.epam.entity.Tour;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

public interface XmlEntityParser {
    public Tour parseTour(File file) throws XMLStreamException, FileNotFoundException;
}
