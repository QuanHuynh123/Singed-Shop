FROM tomcat:8.5.34-alpine
FROM openjdk:18-jdk
COPY target/spring-mvc-1.0.war spring-mvc-1.0.war
CMD ["java","-war","spring-mvc-1.0.war"]