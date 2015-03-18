package com.bank;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.stream.IntStream;

import static com.bank.Account.NUMBER_OF_DIGITS_IN_ACCOUNT_NUMBER;
import static java.util.stream.Collectors.toList;

public class Digits {
    private final String rawDigits;

    public Digits(String rawDigits) {
        this.rawDigits = rawDigits;
    }

    public List<Digit> parse() {
        return IntStream
                .range(0, NUMBER_OF_DIGITS_IN_ACCOUNT_NUMBER)
                .mapToObj(this::digitAt)
                .collect(toList());
    }

    private Digit digitAt(int position) {
        List<String> strings = Splitter.fixedLength(Digit.WIDTH).splitToList(rawDigits);

        return Digit.digitFor(
                strings.get(position) +
                        strings.get(position + NUMBER_OF_DIGITS_IN_ACCOUNT_NUMBER) +
                        strings.get(position + NUMBER_OF_DIGITS_IN_ACCOUNT_NUMBER * 2));
    }
}
