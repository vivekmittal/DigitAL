package com;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.List;

public class DigitsReader {
    public List<Digit> read(InputStream input) throws Exception {
        String rawDigits = IOUtils.toString(input);

        return new DigitParser(
                removeCRLF(rawDigits)
        ).parse();
    }

    private String removeCRLF(String rawDigits) {
        return rawDigits.replaceAll("(\\r|\\n)", "");
    }
}