# Stage 1: Maven Build
FROM maven:3.6.3-openjdk-11 as build

WORKDIR /app

# Copy the pom.xml file
COPY ./pom.xml ./pom.xml

# Download all required dependencies into one layer
RUN mvn dependency:go-offline -B

# Copy your other files
COPY ./src ./src

# Build application with Maven
RUN mvn clean install

# Stage 2: Java Runtime
FROM openjdk:11-jdk-slim

WORKDIR /app

# Copy the built application from the build stage
COPY --from=build /app/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]