FROM java:8
VOLUME /tmp
ADD target/MyStreamjava8-1.0.jar target/MyStreamjava8-1.0.jar
COPY runMe.sh runMe.sh
COPY runPermutations.sh runPermutations.sh
COPY src/main/resources/Euromillones2004_2018.csv Euromillones2004_2018.csv
COPY src/main/resources/primitiva.csv primitiva.csv
RUN bash -c 'touch target/MyStreamTests.jar'
RUN bash -c 'sh runMe.sh em 1 Euromillones2004_2018.csv primitiva.csv'