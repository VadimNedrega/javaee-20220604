FROM openjdk:17-alpine

ENV JAR_FILE=Lesson-06-1.0-SNAPSHOT.jar
WORKDIR /root
COPY ./Lesson-06/target/$JAR_FILE .

EXPOSE 18888

ENTRYPOINT ["java", "-jar", "Lesson-06-1.0-SNAPSHOT.jar"]
