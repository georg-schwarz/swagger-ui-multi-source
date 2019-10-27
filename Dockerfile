#########################################################
# First stage: image to build the application           #
#########################################################
FROM adoptopenjdk/openjdk12-openj9:alpine-slim as builder

WORKDIR /builder

# Copy Gradle file
COPY *.gradle /builder/

# Copy sources
COPY src /builder/src

# Copy Gradle resources
COPY gradle /builder/gradle
COPY gradlew /builder/gradlew

# Test project
RUN ./gradlew test

# Build project
RUN ./gradlew build

#########################################################
# Second stage: image to run the application            #
#########################################################
FROM adoptopenjdk/openjdk12-openj9:alpine-slim

# Pull the built files from the builder container
COPY --from=builder /builder/build/libs/*.jar /app.jar

# Pull the configuration script
COPY entrypoint.sh ./entrypoint.sh
RUN chmod +x entrypoint.sh

# Expose port
EXPOSE 8080

# Generate config and run application
ENTRYPOINT ["/bin/sh", "/entrypoint.sh"]