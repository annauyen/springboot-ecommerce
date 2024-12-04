# Use an official OpenJDK image with Java 22
FROM openjdk:22-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Spring Boot application jar

COPY target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]

