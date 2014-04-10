package com.bank;

import org.testng.annotations.Test;

import static com.utils.CustomMatchers.illegal;
import static com.utils.CustomMatchers.valid;
import static com.utils.CustomMatchers.number;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

@Test
public class AccountTest {
    public void newAccount() {
        String rawDigits = " _  _     _  _  _  _  _  _ "
                         + " _| _||_||_ |_   ||_||_|| |"
                         + "|_  _|  | _||_|  ||_| _||_|";

        Account account = new Account(rawDigits);

        assertThat(account, number(is("234567890")));
    }

    public void illegalAccount() {
        String rawDigits = " _  _     _  _  _  _  _  _ "
                         + " _| _|| ||_ |_   ||_||_|  |"
                         + "|_  _|  | _||_|  ||_| _||_|";

        Account account = new Account(rawDigits);

        assertThat(account, number(is("23?56789?")));
        assertThat(account, is(illegal()));
    }

    public void validAccountNumber() {
        String rawDigits = " _     _  _  _  _  _  _  _ "
                         + " _||_||_ |_||_| _||_||_ |_ "
                         + " _|  | _||_||_||_ |_||_| _|";

        Account account = new Account(rawDigits);

        assertThat(account, is(valid()));
    }

    public void invalidAccountNumber() {
        String rawDigits = " _  _     _  _  _  _  _  _ "
                         + " _| _||_||_ |_   ||_||_|| |"
                         + "|_  _|  | _||_|  ||_| _||_|";

        Account account = new Account(rawDigits);

        assertThat(account, is(not(valid())));
    }
}
