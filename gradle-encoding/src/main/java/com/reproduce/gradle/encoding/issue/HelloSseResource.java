package com.reproduce.gradle.encoding.issue;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;

import static org.glassfish.jersey.media.sse.SseFeature.SERVER_SENT_EVENTS;

@Path("/hellosse")
public class HelloSseResource {

    private static final EventOutput EVENT_OUTPUT = new EventOutput();

    @GET
    @Produces(SERVER_SENT_EVENTS)
    public EventOutput hello() throws IOException {
        return EVENT_OUTPUT;
    }

    @POST
    @Consumes("application/json")
    public Response postHello(HelloParam p) throws IOException {

        EVENT_OUTPUT.write(new OutboundEvent.Builder()
                .name("hi").data(String.class, p.getContent())
                .build());

        return Response.ok().build();
    }
}
