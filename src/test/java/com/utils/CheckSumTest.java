package com.utils;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class CheckSumTest {
    public void validNumber() {
        assertTrue(CheckSum.of("345882865").isValid());
    }

    public void invalidNumber() {
        assertFalse(CheckSum.of("125872819").isValid());
    }
}
