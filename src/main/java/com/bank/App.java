package com.bank;

import java.io.FileInputStream;
import java.io.IOException;

public class App {
    private static final String FILE_NAME = "data.txt";

    public static void main(String[] args) throws IOException {
        try (FileInputStream dataFile = new FileInputStream(FILE_NAME)) {
            Accounts
                    .from(dataFile)
                    .forEach(System.out::println);
        }
    }
}
