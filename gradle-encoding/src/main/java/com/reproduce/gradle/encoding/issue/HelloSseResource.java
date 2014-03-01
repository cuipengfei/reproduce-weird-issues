package com.reproduce.gradle.encoding.issue;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;

import static org.glassfish.jersey.media.sse.SseFeature.SERVER_SENT_EVENTS;

@Path("/hellosse")
public class HelloSseResource {
    @GET
    @Produces(SERVER_SENT_EVENTS)
    public EventOutput hello() throws IOException {
        EventOutput eventOutput = new EventOutput();
        eventOutput.write(new OutboundEvent.Builder()
                .name("hi").data(String.class, "hello")
                .build());
        return eventOutput;
    }
}
