package com.bank;

import org.testng.annotations.Test;

import static com.bank.Digit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class DigitTest {
    public void zero(){
        String zero = " _ " +
                      "| |" +
                      "|_|";

        Digit digit = Digit.digitFor(zero);

        assertThat(digit, is(ZERO));
        assertThat(digit.value(), is(0));
    }

    public void one(){
        String one = "   " +
                     "  |" +
                     "  |";

        Digit digit = Digit.digitFor(one);

        assertThat(digit, is(ONE));
        assertThat(digit.value(), is(1));
    }

    public void two(){
        String one = " _ " +
                     " _|" +
                     "|_ ";

        Digit digit = Digit.digitFor(one);

        assertThat(digit, is(TWO));
        assertThat(digit.value(), is(2));
    }

    public void three(){
        String three =  " _ " +
                        " _|" +
                        " _|";

        Digit digit = Digit.digitFor(three);

        assertThat(digit, is(THREE));
        assertThat(digit.value(), is(3));
    }

    public void four(){
        String four =  "   " +
                       "|_|" +
                       "  |";

        Digit digit = Digit.digitFor(four);

        assertThat(digit, is(FOUR));
        assertThat(digit.value(), is(4));
    }

    public void five(){
        String five =  " _ " +
                       "|_ " +
                       " _|";

        Digit digit = Digit.digitFor(five);

        assertThat(digit, is(FIVE));
        assertThat(digit.value(), is(5));
    }

    public void six(){
        String six =  " _ " +
                      "|_ " +
                      "|_|";

        Digit digit = Digit.digitFor(six);

        assertThat(digit, is(SIX));
        assertThat(digit.value(), is(6));
    }

    public void seven(){
        String seven =  " _ " +
                        "  |" +
                        "  |";

        Digit digit = Digit.digitFor(seven);

        assertThat(digit, is(SEVEN));
        assertThat(digit.value(), is(7));
    }

    public void eight(){
        String eight =  " _ " +
                        "|_|" +
                        "|_|";

        Digit digit = Digit.digitFor(eight);

        assertThat(digit, is(EIGHT));
        assertThat(digit.value(), is(8));
    }

    public void nine(){
        String nine =  " _ " +
                       "|_|" +
                       " _|";

        Digit digit = Digit.digitFor(nine);

        assertThat(digit, is(NINE));
        assertThat(digit.value(), is(9));
    }

    public void invalidDigit() {
        String crapData =  "   " +
                           "|_|" +
                           " _ ";

        Digit digit = Digit.digitFor(crapData);

        assertThat(digit, is(INVALID));
        assertThat(digit.value(), is(-1));
        assertThat(digit.isValid(), is(false));
    }
}
