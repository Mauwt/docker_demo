FROM amazoncorretto:17-alpine3.18
WORKDIR /app
COPY . /app
RUN rm -rf target
RUN ./mvnw clean package -DskipTests
CMD ["java", "-jar", "target/demo_api-0.0.1-SNAPSHOT.jar"]
