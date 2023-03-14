FROM openjdk:17
EXPOSE 8080
ARG JAR_FILE=target/ManagementAP.jar
ADD ${JAR_FILE} ManagementAP.jar
ENTRYPOINT ["java","-jar","ManagementAP.jar"]