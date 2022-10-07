FROM java:8
VOLUME /tmp
ADD target/MyStreamjava8-1.0.1-RELEASE.jar target/MyStreamjava8-1.0.1-RELEASE.jar
ADD target/demo-jdbc-0.0.1-SNAPSHOT.jar target/demo-jdbc-0.0.1-SNAPSHOT.jar
COPY runMe.sh /scripts/runMe.sh
COPY runPermutations.sh /scripts/runPermutations.sh
COPY src/main/resources/Euromillones2004_2018.csv /files/Euromillones2004_2018.csv
COPY src/main/resources/primitiva.csv /files/primitiva.csv
EXPOSE 8080

RUN bash -c 'touch target/MyStreamTests.jar'
RUN chmod +x '/scripts/runMe.sh'
RUN chmod +x '/scripts/runPermutations.sh'
RUN bash -c 'bash /scripts/runMe.sh em 1 /files/Euromillones2004_2018.csv /files/primitiva.csv'
