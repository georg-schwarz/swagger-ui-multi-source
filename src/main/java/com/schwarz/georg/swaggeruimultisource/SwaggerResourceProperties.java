package com.schwarz.georg.swaggeruimultisource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerResourceProperties {

    List<SwaggerResourceDefinition> resources = new ArrayList<>();

    @Value("abc")
    private String name;
    @Value("${swagger.resource.swaggerVersion}")
    private String swaggerVersion;
    @Value("${swagger.resource.location}")
    private String location;

    public List<SwaggerResourceDefinition> getResources() {
        return resources;
    }

    @PostConstruct
    public void printTest() {
        this.resources.add(new SwaggerResourceDefinition(name, swaggerVersion, location));
    }
}