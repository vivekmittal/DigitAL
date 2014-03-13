package com.utils;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class UtilsTest {
    public void stringifyStream() throws IOException {
        String anyString = "Any String";

        String stringifiedStream = Utils.stringify(new ByteArrayInputStream(anyString.getBytes()));

        assertThat(stringifiedStream, is(anyString));
    }

    public void removeCRLF() throws IOException {
        String anyString = "Any \rStr\ning\r\n";

        String stringifiedStream = Utils.stringify(new ByteArrayInputStream(anyString.getBytes()));

        assertThat(stringifiedStream, is("Any String"));
    }
}
