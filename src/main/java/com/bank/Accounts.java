package com.bank;

import com.utils.Utils;
import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Collections2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

public class Accounts {
    private static final int ACCOUNT_NUMBER_RAW_LENGTH = Account.NUMBER_OF_DIGITS_IN_ACCOUNT_NUMBER * Digit.WIDTH * Digit.HEIGHT;

    private static final Function<String, Account> TO_ACCOUNTS = new Function<String, Account>() {
        @Override
        public Account apply(String rawAccountNumber) {
            return new Account(rawAccountNumber);
        }
    };

    public static Collection<Account> from(InputStream is) throws IOException {
        String stringifiedStream = Utils.stringify(is);

        List<String> rawAccountNumbers = Splitter.fixedLength(ACCOUNT_NUMBER_RAW_LENGTH).splitToList(stringifiedStream);

        return Collections2.transform(rawAccountNumbers, TO_ACCOUNTS);
    }
}
