package com;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static com.Digit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

@Test
public class DigitReaderTest {
    public void shouldReadDigitFromStream() throws Exception {
        String line1 = " _  _     _  _  _  _  _  _ \r\n"
                     + " _| _||_||_ |_   ||_||_|| |\r\n"
                     + "|_  _|  | _||_|  ||_| _||_|\r\n";

        List<Digit> digits = new DigitsReader().read(new ByteArrayInputStream(line1.getBytes()));

        assertThat(digits, contains(TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, ZERO));
    }
}
