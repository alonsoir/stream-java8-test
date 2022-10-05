# build stage build the jar with all our resources
FROM openjdk:8-jdk as build
ARG PROFILE
RUN echo "Here is the build env: $PROFILE!"
VOLUME /tmp
WORKDIR /
ADD . .

RUN ./mvnw clean install
RUN mv /$JAR_PATH/target/demo-jdbc-0.0.1-SNAPSHOT.jar /app.jar

# package stage
FROM openjdk:8-jdk-alpine
WORKDIR /
# copy only the built jar and nothing else
COPY --from=build /app.jar /

COPY clean_final_output_winners.txt /
COPY clean_final_output_star.txt /
COPY entrypoint.sh /entrypoint.sh

EXPOSE 8080

ENTRYPOINT ["/entrypoint.sh"]
