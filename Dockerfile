FROM openjdk
VOLUME /tmp
EXPOSE 9878
ADD target/springboot-backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
