FROM amazoncorretto:23-alpine-jdk

RUN mkdir /app

COPY . /app

WORKDIR /app

RUN chmod +x mvnw

RUN ./mvnw -DskipTests clean package

RUN cp target/q1-spring-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=classpath:/application.properties"]