package com.epam.parser;

import com.epam.entity.Tour;

import java.io.File;

public interface XMLParserFactory {
    public Tour parserTours(File file);
}
