package com.reproduce.gradle.encoding.issue;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloTest {
    @Test
    public void testHello() throws Exception {
        assertThat("hello", is("hello"));
    }
}
