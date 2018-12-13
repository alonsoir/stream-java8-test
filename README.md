# stream-java8-test
Playing with functional java8 style streaming api. <br />

# How to use <br />

You can import to eclipse the maven project and run the tests or you can compile the project and run it within your local shell, or creating your local docker container or pulling one created and pushed by me: <br />

# To pull my docker container <br />

docker pull aironman:mystreamjava8:latest <br />

# To run my docker container <br />
$ docker images
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

java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests em 80. 80 means the number of iterations, 80 predictions.<br />

# To show only primitiva <br />

java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests primitiva 80. 80 means the number of iterations, 80 predictions.<br />

# To run the project with the shell script <br />

bash runMe.sh em 100 /PATH/TO/Euromillones2004_2018.csv /PATH/TO/primitiva.csv<br /> 

# OUTPUT

<br />
Running with arguments em 100 /Users/aironman/Desktop/Euromillones2004_2018.csv /Users/aironman/Desktop/primitiva.csv at miércoles, 12 de diciembre de 2018, 18:35:43 CET<br />
<br />
A general file named output.txt has been generated. <br />
Showing winners.<br />
winner 10 appeared 8 times.<br />
winner 11 appeared 16 times.<br />
winner 12 appeared 15 times.<br />
winner 13 appeared 8 times.<br />
winner 14 appeared 14 times.<br />
winner 15 appeared 6 times.<br />
winner 16 appeared 6 times.<br />
winner 17 appeared 14 times.<br />
winner 18 appeared 11 times.<br />
winner 19 appeared 13 times.<br />
winner 2 appeared 10 times.<br />
winner 20 appeared 15 times.<br />
winner 21 appeared 14 times.<br />
winner 22 appeared 23 times.<br />
winner 23 appeared 12 times.<br />
winner 24 appeared 16 times.<br />
winner 25 appeared 14 times.<br />
winner 26 appeared 11 times.<br />
winner 27 appeared 14 times.<br />
winner 28 appeared 14 times.<br />
winner 29 appeared 13 times.<br />
winner 3 appeared 3 times.<br />
winner 30 appeared 7 times.<br />
winner 31 appeared 17 times.<br />
winner 32 appeared 9 times.<br />
winner 33 appeared 12 times.<br />
winner 34 appeared 15 times.<br />
winner 35 appeared 17 times.<br />
winner 36 appeared 14 times.<br />
winner 37 appeared 14 times.<br />
winner 38 appeared 12 times.<br />
winner 39 appeared 11 times.<br />
winner 4 appeared 7 times.<br />
winner 40 appeared 9 times.<br />
winner 41 appeared 5 times.<br />
winner 42 appeared 10 times.<br />
winner 43 appeared 7 times.<br />
winner 44 appeared 10 times.<br />
winner 45 appeared 7 times.<br />
winner 46 appeared 7 times.<br />
winner 47 appeared 4 times.<br />
winner 48 appeared 3 times.<br />
winner 49 appeared 6 times.<br />
winner 5 appeared 4 times.<br />
winner 6 appeared 5 times.<br />
winner 7 appeared 8 times.<br />
winner 8 appeared 5 times.<br />
winner 9 appeared 5 times.<br />
winner Winner1 appeared 100 times.<br />
winner Winner2 appeared 100 times.<br />
winner Winner3 appeared 100 times.<br />
winner Winner4 appeared 100 times.<br />
winner Winner5 appeared 100 times.<br />
Showing stars.<br />
star 1 appeared 13 times.<br />
star 10 appeared 18 times.<br />
star 11 appeared 28 times.<br />
star 12 appeared 12 times.<br />
star 2 appeared 17 times.<br />
star 3 appeared 19 times.<br />
star 4 appeared 14 times.<br />
star 5 appeared 16 times.<br />
star 6 appeared 14 times.<br />
star 7 appeared 19 times.<br />
star 8 appeared 18 times.<br />
star 9 appeared 12 times.<br />
star Star1 appeared 100 times.<br />
star Star2 appeared 100 times.<br />
Done. Time duration: 1 secs.<br />
<br />
It will generate two files, final_output_star_martes\,\ \ 4\ de\ diciembre\ de\ 2018\,\ 13\:18\:13\ CET.txt<br /> 
and final_output_winners_martes\,\ \ 4\ de\ diciembre\ de\ 2018\,\ 13\:18\:13\ CET.txt.<br />
The name of the files is created using the pattern final_output_winners_$actual_date.txt and final_output_star_$actual_date.txt<br />
$actual_date is the actual date using unix format.<br />
<br />
100 means the number of iterations, 100 predictions. <br />
<br />

# Dependencies <br />

The Project needs maven, java8 to compile and run the jar, some unix commands to run the script and docker if you want to run a container: <br />
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
