package com.bank;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final String FILE_NAME = "data.txt";
    private static final Logger LOGGER = Logger.getLogger("Bank");

    public static void main(String[] args) {
        try (FileInputStream dataFile = new FileInputStream(FILE_NAME)) {

            Accounts
                    .from(dataFile)
                    .forEach(account -> System.out.printf(
                            "Account Number: %s, %s \n", account.getAccountNumber(), account.status()
                    ));

        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error Opening/Reading File - " + ex.getMessage());
        }
    }
}
