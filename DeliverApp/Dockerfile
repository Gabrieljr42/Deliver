FROM openjdk:20-jdk-slim
WORKDIR /app
COPY . /app
EXPOSE 8081
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.jvmArguments='-Dserver.port=8081'"]
