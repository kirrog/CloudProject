# syntax=docker/dockerfile:1

FROM maven:3.8.1-jdk-11-slim AS build
WORKDIR ./
COPY pom.xml pom.xml
COPY src src/
RUN --mount=type=cache,target=/root/.m2 mvn package -DskipTests -DoutputDirectory=/

FROM --platform=${BUILDPLATFORM} eclipse-temurin:11-alpine
COPY --from=build target ./
ENTRYPOINT ["java", "-jar", "CloudProject-0.0.1-SNAPSHOT.jar"]
