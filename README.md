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
numIterations 10 <br />
A general file named output.txt has been generated. <br /> 
Showing winners. <br />
winner 10 appeared 2 times of 10. Frequency is 20% <br />
winner 11 appeared 1 times of 10. Frequency is 10% <br />
winner 12 appeared 1 times of 10. Frequency is 10% <br />
winner 14 appeared 1 times of 10. Frequency is 10% <br />
winner 16 appeared 3 times of 10. Frequency is 30% <br />
winner 17 appeared 2 times of 10. Frequency is 20% <br />
winner 18 appeared 1 times of 10. Frequency is 10% <br />
winner 19 appeared 1 times of 10. Frequency is 10% <br />
winner 21 appeared 2 times of 10. Frequency is 20% <br />
winner 22 appeared 2 times of 10. Frequency is 20% <br />
winner 23 appeared 2 times of 10. Frequency is 20% <br />
winner 24 appeared 2 times of 10. Frequency is 20% <br />
winner 25 appeared 1 times of 10. Frequency is 10% <br />
winner 26 appeared 1 times of 10. Frequency is 10% <br />
winner 27 appeared 1 times of 10. Frequency is 10% <br />
winner 29 appeared 2 times of 10. Frequency is 20% <br />
winner 30 appeared 1 times of 10. Frequency is 10% <br />
winner 31 appeared 1 times of 10. Frequency is 10% <br />
winner 32 appeared 1 times of 10. Frequency is 10% <br />
winner 33 appeared 2 times of 10. Frequency is 20% <br />
winner 34 appeared 2 times of 10. Frequency is 20% <br />
winner 37 appeared 1 times of 10. Frequency is 10% <br />
winner 38 appeared 1 times of 10. Frequency is 10% <br />
winner 39 appeared 3 times of 10. Frequency is 30% <br />
winner 4 appeared 1 times of 10. Frequency is 10% <br />
winner 40 appeared 3 times of 10. Frequency is 30% <br />
winner 41 appeared 1 times of 10. Frequency is 10% <br />
winner 42 appeared 1 times of 10. Frequency is 10% <br />
winner 44 appeared 1 times of 10. Frequency is 10% <br />
winner 45 appeared 1 times of 10. Frequency is 10% <br />
winner 46 appeared 1 times of 10. Frequency is 10% <br />
winner 47 appeared 1 times of 10. Frequency is 10% <br />
winner 6 appeared 1 times of 10. Frequency is 10% <br />
winner 8 appeared 1 times of 10. Frequency is 10% <br />
winner 9 appeared 1 times of 10. Frequency is 10% <br />
winner Winner1 appeared 10 times of 10. Frequency is 100% <br />
winner Winner2 appeared 10 times of 10. Frequency is 100% <br />
winner Winner3 appeared 10 times of 10. Frequency is 100% <br />
winner Winner4 appeared 10 times of 10. Frequency is 100% <br />
winner Winner5 appeared 10 times of 10. Frequency is 100% <br />
Showing stars. <br />
star 10 appeared 2 times of 10. Frequency is 20% <br />
star 2 appeared 3 times of 10. Frequency is 30% <br />
star 3 appeared 2 times of 10. Frequency is 20% <br />
star 4 appeared 3 times of 10. Frequency is 30% <br />
star 5 appeared 2 times of 10. Frequency is 20% <br />
star 7 appeared 3 times of 10. Frequency is 30% <br />
star 8 appeared 5 times of 10. Frequency is 50% <br />
star Star1 appeared 10 times of 10. Frequency is 100% <br />
star Star2 appeared 10 times of 10. Frequency is 100% <br />
Done. Time duration: 0 secs. <br />
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
