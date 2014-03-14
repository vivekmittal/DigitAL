package com.utils;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class CheckSumTest {

    private static final int ACCOUNT_NUMBER_1 = 123456789;
    private static final int ACCOUNT_NUMBER_2 = 345882865;

    private static final int ACCOUNT_NUMBER_3 = 125872819;
    private static final int ACCOUNT_NUMBER_4 = 807670941;

    public void validNumber() {
        assertTrue(CheckSum.of(ACCOUNT_NUMBER_1).isValid());
        assertTrue(CheckSum.of(ACCOUNT_NUMBER_2).isValid());
    }

    public void invalidNumber() {
        assertFalse(CheckSum.of(ACCOUNT_NUMBER_3).isValid());
        assertFalse(CheckSum.of(ACCOUNT_NUMBER_4).isValid());
    }
}
