package com.bank;

import com.utils.CheckSum;

import java.util.Optional;

import static java.util.stream.Collectors.joining;

public class Account {
    public static final int NUMBER_OF_DIGITS_IN_ACCOUNT_NUMBER = 9;
    private static final String INVALID_DIGIT_CHARACTER = "?";

    private String number;
    private final Digits digits;

    public Account(String rawAccountNumber) {
        digits = new Digits(rawAccountNumber);
    }

    public String getAccountNumber() {
        if (number == null || number.isEmpty()) {
            number = generateAccountNumber();
        }

        return number;
    }

    public Status status() {
        return Status.forThe(getAccountNumber());
    }

    public String toString() {
        return String.format("Account Number: %s, %s", getAccountNumber(), status());
    }

    private String generateAccountNumber() {
        return digits.parse()
                .stream()
                .map(Digit::getDigit)
                .collect(joining());
    }

    public enum Status {
        VALID,
        ERROR,
        ILLEGAL;

        public static Status forThe(String accountNumber) {
            return isIllegal(accountNumber)
                    ? ILLEGAL
                    : !isValid(accountNumber) ? ERROR : VALID;
        }

        private static boolean isIllegal(String accountNumber) {
            return accountNumber.contains(INVALID_DIGIT_CHARACTER);
        }

        private static boolean isValid(String accountNumber) {
            return CheckSum.of(Integer.valueOf(accountNumber)).isValid();
        }
    }
}
