# stream-java8-test
This project started as a test exercise to know the api stream of java8, then try to practice with parallelism, Docker, bash scripting, in short to practice and have fun. 

# disclaimer
It can't be taken as an example of anything because there was no intention to do it right from the beginning, so you won't find a good use of design patterns or a correct use of solid principles. Just practice with java8 api stream onwards, as well as apply parallelism to get better performance, play with Docker, bash scripting. The project is basically crap, one of those you dont like at all. It started out as one of those practice ones, doing functional-style stuff from some tests, but then you start playing around, you put something here, there, and you end up with a jumble of stuff you don't like. In short, do not take it as an example of anything.
There are better projects in my repository on how to have a better design following solid principles and good practices.<br />

# How to use <br />

You can import to eclipse the maven project and run the tests or you can compile the project and run it within your local shell, or creating your local docker container or pulling one created and pushed by me, but latest version is not uploaded to dockerhub, so i recommend to use the shell script downloading first the source code. <br />

# To pull my docker container <br />

docker pull aironman:mystreamjava8:latest <br />

# To run my docker container <br />
$ docker images <br />
<br />
aironman/mystreamjava8   latest              71d2c3357c55        12 minutes ago      643MB <br />

docker run -it 71d2c3357c55 /bin/bash <br />

root@7afd5ea86e03:/# bash /scripts/runMe.sh em 1 files/Euromillones2004_2018.csv files/primitiva.csv <br /> 

# To compile the project

git clone https://github.com/alonsoir/stream-java8-test.git <br />
mvn clean package <br />

# To show Euromillions and primitiva in local mode<br />

java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests all 80 PATH_TO/Euromillones2004_2018.csv PATH_TO/primitiva.csv. <br /> 

80 means the number of iterations, 80 predictions.<br />

# To show only Euromillions <br />

java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests em 80 PATH_TO/Euromillones2004_2018.csv PATH_TO/primitiva.csv. 80 means the number of iterations, 80 predictions.<br />

# To show only primitiva <br />

java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests primitiva 80 PATH_TO/Euromillones2004_2018.csv PATH_TO/primitiva.csv. 80 means the number of iterations, 80 predictions.<br />

# To run the project using the shell script <br />

bash runMe.sh em 100 <br />

The script does not need actually any euromillions or primitiva file. Now it tries to download latest results using wget command.
<br />

## Euromillones_2004_2018.csv Format <br />
FECHA,COMB. GANADORA,,,,,,ESTRELLAS,<br />
30/04/2019,05,12,20,26,48,,02,11<br />
26/04/2019,14,33,35,47,50,,09,11<br />
23/04/2019,18,23,27,42,44,,02,07 <br />
...<br />
<br />
bash runMe.sh em 100 /PATH/TO/Euromillones2004_2018.csv /PATH/TO/primitiva.csv<br /> 

100 means the number of simulated moves or predictions. <br />
After a few seconds or minutes, depending on how many predictions you want to calculate, a web server will rise at localhost:8080/frequencies and you will be able to see the results sorted by frequency.
You can use localhost:8080/predictions to see one prediction.
<br />
# OUTPUT

02/05/2019

Now the project automatically updates the previous results of the Euromillions draw and raises a small web jetty server with two endpoints: <br />

http://localhost:8080/prediction <br />

and <br />

http://localhost:8080/frequencies<br />

The first one gives you a prediction, you can update the webpage in order to get a new prediction, the second one draws the frequencies for the appearance of the figures.

<br />


# Dependencies <br />

The Project needs maven, java8 onwards to compile and run the jar, some unix commands to run the script and docker if you want to run a container: <br />
tr <br />
sort <br />
uniq <br />
awk  <br />
 <br />

I think these unix commands come by default in osx and I think they also come by default in linux, not sure in windows.  <br />
 <br />

# To install Docker, follow this link: <br />

https://docs.docker.com/install/<br />
<br />
