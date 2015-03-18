package com.bank;

import com.google.common.base.Splitter;
import com.utils.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Accounts {
    private static final int ACCOUNT_NUMBER_RAW_LENGTH = Account.NUMBER_OF_DIGITS_IN_ACCOUNT_NUMBER * Digit.WIDTH * Digit.HEIGHT;

    public static Collection<Account> from(InputStream is) throws IOException {
        String stringifiedStream = IOUtils.stringify(is);

        List<String> rawAccountNumbers = Splitter.fixedLength(ACCOUNT_NUMBER_RAW_LENGTH).splitToList(stringifiedStream);

        return rawAccountNumbers
                .stream()
                .map(Account::new)
                .collect(toList());
    }
}
