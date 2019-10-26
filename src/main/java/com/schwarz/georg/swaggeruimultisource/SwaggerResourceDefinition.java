package com.schwarz.georg.swaggeruimultisource;

import java.util.Objects;

public class SwaggerResourceDefinition {
    private String name;
    private String swaggerVersion;
    private String location;

    public SwaggerResourceDefinition(String name, String location, String swaggerVersion) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSwaggerVersion(String swaggerVersion) {
        this.swaggerVersion = swaggerVersion;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "SwaggerResourceDefinition{" +
                "name='" + name + '\'' +
                ", swaggerVersion='" + swaggerVersion + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SwaggerResourceDefinition that = (SwaggerResourceDefinition) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(swaggerVersion, that.swaggerVersion) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, swaggerVersion, location);
    }
}
