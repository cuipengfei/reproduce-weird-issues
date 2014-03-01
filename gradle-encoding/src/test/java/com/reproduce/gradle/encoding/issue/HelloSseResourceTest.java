package com.reproduce.gradle.encoding.issue;

import com.google.common.base.Stopwatch;
import org.glassfish.jersey.media.sse.EventListener;
import org.glassfish.jersey.media.sse.EventSource;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloSseResourceTest extends JerseyTest {
    private String message;

    @Override
    protected Application configure() {
        return new ResourceConfig().register(HelloSseResource.class).register(SseFeature.class);
    }

    @Test
    public void testHello() throws Exception {
        EventSource eventSource = EventSource.target(target("hellosse").register(SseFeature.class)).build();

        eventSource.register(new EventListener() {
            @Override
            public void onEvent(InboundEvent inboundEvent) {
                message = inboundEvent.readData(String.class);
            }
        }, "hi");

        eventSource.open();

        Stopwatch stopwatch = new Stopwatch().start();
        while (stopwatch.elapsed(TimeUnit.SECONDS) < 5) {
        }

        assertThat(message, is("hello"));
    }
}
