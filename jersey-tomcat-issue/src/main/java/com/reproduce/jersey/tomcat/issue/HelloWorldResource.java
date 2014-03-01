package com.reproduce.jersey.tomcat.issue;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloWorldResource {
    @GET
    public String hello(@QueryParam("name") String name) {
        return "hello " + name;
    }
}
