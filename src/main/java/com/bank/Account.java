package com.bank;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;

import java.util.Collection;

public class Account {
    public static int NUMBER_OF_DIGITS_IN_ACCOUNT_NUMBER = 9;
    private static String INVALID_DIGIT_CHARACTER = "?";

    private String number = "";
    private final Digits digits;

    public Account(String rawAccountNumber) {
        digits = new Digits(rawAccountNumber);
    }

    public String getAccountNumber() {
        if (number.isEmpty()) {
            number = generateAccountNumber();
        }

        return number;
    }

    private String generateAccountNumber() {
        Collection<String> stringDigits = Collections2.transform(digits.parse(), new Function<Digit, String>() {
            @Override
            public String apply(Digit digit) {
                return
                        digit.isValid()
                                ? String.valueOf(digit.value())
                                : INVALID_DIGIT_CHARACTER;
            }
        });

        return Joiner.on("").join(stringDigits);
    }
}
