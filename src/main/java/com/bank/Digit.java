package com.bank;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import java.util.List;

public enum Digit {
    ZERO(   " _ " +
            "| |" +
            "|_|", 0),

    ONE(    "   " +
            "  |" +
            "  |", 1),

    TWO(    " _ " +
            " _|" +
            "|_ ", 2),

    THREE(  " _ " +
            " _|" +
            " _|", 3),

    FOUR(   "   " +
            "|_|" +
            "  |", 4),

    FIVE(   " _ " +
            "|_ " +
            " _|", 5),

    SIX(    " _ " +
            "|_ " +
            "|_|", 6),

    SEVEN(  " _ " +
            "  |" +
            "  |", 7),

    EIGHT(  " _ " +
            "|_|" +
            "|_|", 8),

    NINE(   " _ " +
            "|_|" +
            " _|", 9),

    INVALID("?", -1);

    private String digit;
    private int value;

    private Digit(String value, int aByte) {
        this.digit = value;
        this.value = aByte;
    }

    public int value() {
        return this.value;
    }

    private boolean has(String rawString) {
        return this.digit.equals(rawString);
    }

    public boolean isValid() {
        return this != INVALID;
    }

    public static Digit digitFor(final String rawString) {
        List<Digit> allDigits = Lists.newArrayList(values());

        Optional<Digit> aDigit = Iterators.tryFind(allDigits.iterator(), new Predicate<Digit>() {
            @Override
            public boolean apply(Digit digit) {
                return digit.has(rawString);
            }
        });

        return aDigit.or(INVALID);
    }

    public static int WIDTH = 3;
    public static int HEIGHT = 4;
}