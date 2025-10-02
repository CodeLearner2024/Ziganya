# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-17 AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml to the container
COPY pom.xml .
RUN mvn dependency:go-offline -B || true
# Copy the project files to the container
COPY src ./src
# Build the application using Maven
RUN mvn clean package -Dmaven.test.skip=true
# Use an official OpenJDK image as the base
FROM openjdk:17
# Set the working directory in the container
WORKDIR /app
# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8001


# Set the command to run the application
CMD ["java", "-jar", "app.jar"]
