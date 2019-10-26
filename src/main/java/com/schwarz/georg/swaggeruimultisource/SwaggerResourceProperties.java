package com.schwarz.georg.swaggeruimultisource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties("app.swagger")
public class SwaggerResourceProperties {

    List<SwaggerResourceDefinition> resources = new ArrayList<>();

    public List<SwaggerResourceDefinition> getResources() {
        return resources;
    }
}