# ---------- Build Stage ----------
FROM gradle:8.5-jdk17 AS build
WORKDIR /app

# Copy Gradle files and source code
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
COPY src ./src

# Build the Spring Boot fat JAR
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar --no-daemon

# ---------- Runtime Stage ----------
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose port (optional, helpful for local testing)
EXPOSE 8080

# Run the Spring Boot app
CMD ["sh", "-c", "java -Dserver.port=$PORT -jar app.jar"]
