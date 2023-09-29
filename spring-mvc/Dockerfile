FROM maven:3.8-openjdk-8 AS build
COPY . . 
RUN mvn clean package -DskipTests

FROM openjdk:8
COPY --from=build /target/spring-mvc-1.0.war demo.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.war"]