package com.reproduce.jersey.tomcat.issue;

import java.io.IOException;

import static javax.ws.rs.core.UriBuilder.fromUri;
import static org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory.createHttpServer;

public class Launcher {
    public static void main(String... args) throws IOException {
        createHttpServer(fromUri("http://localhost:12345").build(), new MyApp()).start();
        System.in.read();
    }
}
