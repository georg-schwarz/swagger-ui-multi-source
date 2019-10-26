package com.schwarz.georg.swaggeruimultisource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerUiConfig {

    private final Logger logger = LoggerFactory.getLogger(SwaggerUiConfig.class);

    private final SwaggerResourceProperties resourcesConfig;

    @Autowired
    public SwaggerUiConfig(SwaggerResourceProperties resourcesConfig) {
        this.resourcesConfig = resourcesConfig;
    }

    @Bean
    @Primary
    @DependsOn()
    public SwaggerResourcesProvider swaggerResourcesProvider() {
        this.logResources(resourcesConfig.getResources());
        return () -> {
            List<SwaggerResource> resources = new ArrayList<>();

            this.resourcesConfig.getResources().forEach((resource) -> {
                SwaggerResource wsResource = new SwaggerResource();
                wsResource.setName(resource.getName());
                wsResource.setSwaggerVersion(resource.getSwaggerVersion());
                wsResource.setLocation(resource.getLocation());

                resources.add(wsResource);
            });



            return resources;
        };
    }

    private void logResources(List<SwaggerResourceDefinition> resources) {
         this.logger.info("Found the following Swagger Resources in the Application Properties:");
         this.logger.info(resources.toString());
    }
}
