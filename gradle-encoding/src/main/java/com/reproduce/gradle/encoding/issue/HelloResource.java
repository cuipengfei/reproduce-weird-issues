package com.reproduce.gradle.encoding.issue;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/hello")
public class HelloResource {
    @GET
    public String hello() {
        return "hello中文";
    }

    @POST
    @Consumes("application/json")
    public String postHello(HelloParam p) {
        return p.getContent();
    }

    @XmlRootElement
    public static class HelloParam {
        @XmlElement(name = "content")
        private static String content;

        public static String getContent() {
            return content;
        }

        public static void setContent(String content) {
            HelloParam.content = content;
        }
    }
}
