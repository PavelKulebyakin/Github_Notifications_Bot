FROM eclipse-temurin:21-jdk as builder
WORKDIR /opt/app
RUN addgroup build; adduser --ingroup build --disabled-password user
RUN chown -R user:build /opt/app
USER user
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
RUN ./gradlew --no-daemon dependencies
COPY src src
RUN ./gradlew --no-daemon assemble

FROM eclipse-temurin:22-alpine
WORKDIR /opt/app
COPY --from=builder /opt/app/build/libs/*.jar my-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "my-app.jar"]
