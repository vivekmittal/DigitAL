package com.utils;

import com.bank.Account;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CustomMatchers {
    public static  <T> Matcher<? super Account> number(final Matcher<T> stringMatcher) {
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
}
