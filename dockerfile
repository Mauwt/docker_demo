FROM amazoncorretto:17-alpine3.18
COPY . .
RUN apk add --no-cache maven
RUN apk add --no-cache bash
RUN apk add --no-cache vim
RUN rm -rf target
RUN mvn clean package -DskipTests
CMD ["java", "-jar", "target/demo_api-0.0.1-SNAPSHOT.jar"]