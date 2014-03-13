package com.bank;

import com.bank.Digit;
import com.bank.Digits;
import org.testng.annotations.Test;

import java.util.List;

import static com.bank.Digit.*;
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
