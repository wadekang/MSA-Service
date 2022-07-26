FROM adoptopenjdk/openjdk11
ARG JAR_FILE=EurekaClient1-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} myboot.jar
ENTRYPOINT ["java", "-jar", "/myboot.jar"]