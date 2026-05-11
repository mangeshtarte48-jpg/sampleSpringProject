# Use official OpenJDK image
FROM FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy jar file (after Maven build)
COPY target/sampleSpringProject.jar app.jar

# Expose Spring Boot port
EXPOSE 8085

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]