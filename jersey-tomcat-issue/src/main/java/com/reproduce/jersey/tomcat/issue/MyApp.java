package com.reproduce.jersey.tomcat.issue;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/*")
public class MyApp extends ResourceConfig {
    public MyApp() {
        register(HelloWorldResource.class);
    }
}
