# Use an ARM64 base image for OpenJDK 11
FROM arm64v8/openjdk:17-jre-slim

# Set the working directory
WORKDIR /opt/app

# Copy the Spring Boot application jar to the container
COPY target/0.0.1-SNAPSHOT app.jar

# Set the entrypoint to run the Spring Boot application
ENTRYPOINT ["java","-jar","app.jar"]
