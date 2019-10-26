package com.schwarz.georg.swaggeruimultisource;

public class SwaggerResourceDefinition {
    private String name;
    private String swaggerVersion;
    private String location;

    public SwaggerResourceDefinition(String name, String swaggerVersion, String location) {
        this.name = name;
        this.swaggerVersion = swaggerVersion;
        this.location = location;
    }

    public SwaggerResourceDefinition() {   }

    public String getName() {
        return name;
    }

    public String getSwaggerVersion() {
        return swaggerVersion;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "SwaggerResourceDefinition{" +
                "name='" + name + '\'' +
                ", swaggerVersion='" + swaggerVersion + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
