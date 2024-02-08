FROM amazoncorretto:17-alpine3.18
COPY target/demo_api-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "demo_api-0.0.1-SNAPSHOT.jar"]
