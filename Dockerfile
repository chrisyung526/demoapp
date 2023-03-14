FROM openjdk:17
EXPOSE 8080
ARG JAR_FILE=target/demoapp.jar
ADD ${JAR_FILE} demoapp.jar
ENTRYPOINT ["java","-jar","demoapp.jar"]