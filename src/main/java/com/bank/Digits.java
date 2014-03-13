package com.bank;

import com.bank.Digit;
import com.google.common.base.Splitter;

import java.util.List;

import static com.bank.Account.NUMBER_OF_DIGITS_IN_ACCOUNT_NUMBER;
import static com.google.common.collect.Lists.newArrayList;

public class Digits {
    private String rawDigits;

    public Digits(String rawDigits) {
        this.rawDigits = rawDigits;
    }

    public List<Digit> parse() {
        List<Digit> digits = newArrayList();

        for (int i = 0; i < NUMBER_OF_DIGITS_IN_ACCOUNT_NUMBER; i++) {
            digits.add(
                digitAt(i)
            );
        }

        return digits;
    }

    private Digit digitAt(int position) {
        List<String> strings = Splitter.fixedLength(Digit.WIDTH).splitToList(rawDigits);

        return Digit.digitFor(
                strings.get(position) +
                        strings.get(position + NUMBER_OF_DIGITS_IN_ACCOUNT_NUMBER) +
                        strings.get(position + NUMBER_OF_DIGITS_IN_ACCOUNT_NUMBER * 2));
    }
}