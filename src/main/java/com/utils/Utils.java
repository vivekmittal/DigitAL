package com.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
    public static String stringify(InputStream input) throws IOException {
        String rawDigits = IOUtils.toString(input);

        return removeCRLF(rawDigits);
    }

    private static String removeCRLF(String rawDigits) {
        return rawDigits.replaceAll("(\\r|\\n)", "");
    }
}