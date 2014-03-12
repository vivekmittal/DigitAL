package com;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.List;

public class DigitsReader {

    public List<Digit> read(InputStream input) throws Exception {
        String rawDigits = IOUtils.toString(input).replaceAll("\n", "").replaceAll("\r", "");

        return new DigitParser(rawDigits).parse();
    }
}
