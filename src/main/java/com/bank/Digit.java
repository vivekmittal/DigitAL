package com.bank;

import com.google.common.collect.Lists;

import java.util.List;


public enum Digit {
    ZERO(" _ " +
            "| |" +
            "|_|", 0),
    ONE("   " +
            "  |" +
            "  |", 1),

    TWO(" _ " +
            " _|" +
            "|_ ", 2),

    THREE(" _ " +
            " _|" +
            " _|", 3),

    FOUR("   " +
            "|_|" +
            "  |", 4),

    FIVE(" _ " +
            "|_ " +
            " _|", 5),

    SIX(" _ " +
            "|_ " +
            "|_|", 6),

    SEVEN(" _ " +
            "  |" +
            "  |", 7),

    EIGHT(" _ " +
            "|_|" +
            "|_|", 8),

    NINE(" _ " +
            "|_|" +
            " _|", 9),

    INVALID("?", -1);

    public static final int WIDTH = 3;
    public static final int HEIGHT = 4;

    private final String digit;
    private final int value;

    private Digit(String value, int aByte) {
        this.digit = value;
        this.value = aByte;
    }

    public int value() {
        return this.value;
    }

    public boolean isValid() {
        return this != INVALID;
    }

    private boolean has(String rawString) {
        return this.digit.equals(rawString);
    }

    public String getDigit() {
        return isValid()
                ? String.valueOf(this.value)
                : this.digit;
    }

    public static Digit digitFor(final String rawString) {
        List<Digit> allDigits = Lists.newArrayList(values());

        return allDigits
                .stream()
                .filter(digit -> digit.has(rawString))
                .findAny()
                .orElse(INVALID);
    }
}
