package com.utils;

import java.io.IOException;
import java.io.InputStream;

public class IOUtils {
    public static String stringify(InputStream input) throws IOException {
        String rawDigits = org.apache.commons.io.IOUtils.toString(input);

        return removeCRLF(rawDigits);
    }

    private static String removeCRLF(String rawDigits) {
        return rawDigits.replaceAll("(\\r|\\n)", "");
    }
}