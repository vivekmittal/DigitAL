package com.bank;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;

@Test
public class AccountsTest {
    public void readAccounts() throws IOException {

        String rawAccountNumbers =
                "    _  _     _  _  _  _  _ \n" +
                "  | _| _||_||_ |_   ||_||_|\n\r" +
                "  ||_  _|  | _||_|  ||_| _|\n\r" +
                "                           \n" +
                "    _  _  _  _  _  _  _  _ \n" +
                "  | _| _||_ |_ |_   ||_|| |\n\r" +
                "  | _| _| _||_||_|  ||_||_|\n\r" +
                "                           ";

        Collection<Account> accounts = Accounts.from(new ByteArrayInputStream(rawAccountNumbers.getBytes()));
        //assertThat(accounts, hasItemsInOrder("123456789", "133566780"));
    }
}
