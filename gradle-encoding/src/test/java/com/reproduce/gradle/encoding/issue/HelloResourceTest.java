package com.reproduce.gradle.encoding.issue;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig().register(HelloResource.class);
    }

    @Test
    public void testHelloResource() throws Exception {
        String hello = target("hello").request().get(String.class);
        assertThat(hello, is("hello"));
    }
}
