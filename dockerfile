FROM java:8
VOLUME /tmp
ADD target/MyStreamjava8-1.0.jar target/MyStreamjava8-1.0.jar
RUN bash -c 'touch target/MyStreamTests.jar'
RUN bash -c 'sh runMe.sh em 10'