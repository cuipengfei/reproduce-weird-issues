package com.reproduce.jersey.tomcat.issue;

import org.glassfish.jersey.server.ResourceConfig;

public class MyApp extends ResourceConfig {
    public MyApp() {
        register(HelloWorldResource.class);
    }
}
