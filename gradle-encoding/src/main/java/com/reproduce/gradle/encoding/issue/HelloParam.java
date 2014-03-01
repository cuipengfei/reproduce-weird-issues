package com.reproduce.gradle.encoding.issue;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HelloParam {
    @XmlElement(name = "content")
    private static String content;

    public static String getContent() {
        return content;
    }

    public static void setContent(String content) {
        HelloParam.content = content;
    }
}
