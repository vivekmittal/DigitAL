package com.bank;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final String FILE_NAME = "data.txt";
    private static final Logger LOGGER = Logger.getLogger("Bank");

    public static void main(String[] args) {
        FileInputStream dataFile = null;

        try {
            dataFile = new FileInputStream(FILE_NAME);

            for (Account account : Accounts.from(dataFile)) {
                System.out.printf(
                        "Account Number: %s, %s \n", account.getAccountNumber(), account.isValid() ? "VALID" : "INVALID"
                );
            }

        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error Opening/Reading File - " + ex.getMessage());
        } finally {
            try {
                if(dataFile != null) {
                    dataFile.close();
                }
            } catch (IOException ex) {
                LOGGER.log(Level.WARNING, "Error Closing File - " + ex.getMessage());
            }
        }
    }
}
