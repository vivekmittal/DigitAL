package com.bank;

import org.testng.annotations.Test;

import java.util.List;

import static com.bank.Digit.EIGHT;
import static com.bank.Digit.FIVE;
import static com.bank.Digit.FOUR;
import static com.bank.Digit.NINE;
import static com.bank.Digit.SEVEN;
import static com.bank.Digit.SIX;
import static com.bank.Digit.THREE;
import static com.bank.Digit.TWO;
import static com.bank.Digit.ZERO;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

@Test
public class DigitsTest {
    public void parseDigits() {
        String rawDigits = " _  _     _  _  _  _  _  _ "
                + " _| _||_||_ |_   ||_||_|| |"
                + "|_  _|  | _||_|  ||_| _||_|";

        List<Digit> digits = new Digits(rawDigits).parse();

        assertThat(digits, contains(TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, ZERO));
    }
}
