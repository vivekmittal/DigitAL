package com.utils;

import com.bank.Account;
import com.google.common.base.Joiner;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.Collection;

public class CustomMatchers {
    public static Matcher<? super Account> number(final Matcher stringMatcher) {
        return new TypeSafeMatcher<Account>() {
            @Override
            protected boolean matchesSafely(Account account) {
                return stringMatcher.matches(account.getAccountNumber());
            }

            @Override
            public void describeTo(Description description) {
                stringMatcher.describeTo(description);
            }
        };
    }

    public static Matcher<? super Account> valid() {
        return new TypeSafeMatcher<Account>() {
            @Override
            protected boolean matchesSafely(Account account) {
                return account.isValid();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("The account number to be valid");
            }
        };
    }

    public static Matcher<? super Collection<Account>> hasAccountsInOrder(final String... accountNumbers) {
        return new TypeSafeMatcher<Collection<Account>>() {
            @Override
            protected boolean matchesSafely(Collection<Account> accounts) {
                if (accountNumbers.length != accounts.size()) {
                    return false;
                }

                int i = 0;
                for (Account account : accounts) {
                    if (!account.getAccountNumber().equals(accountNumbers[i++])) {
                        return false;
                    }
                }

                return true;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Accounts to contain account with numbers " + Joiner.on(",").join(accountNumbers));
            }
        };
    }
}
