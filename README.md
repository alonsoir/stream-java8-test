# java8-streaming
Playing with functional java8 style streaming api. <br />

# How to use <br />
You can import to eclipse the maven project and run the tests or you can compile the project and run it with next command: <br />

# To show Euromillions and primitiva <br />
java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests all 80. 80 means the number of iterations, 80 predictions.<br />

# To show only Euromillions <br />
java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests em 80. 80 means the number of iterations, 80 predictions.<br />

# To show only primitiva <br />
java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests primitiva 80. 80 means the number of iterations, 80 predictions.<br />

# To run the project with the shell script <br />
sh runMe.sh em 100 /PATH/TO/Euromillones2004_2018.csv /PATH/TO/primitiva.csv<br /> 
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
# To run the project with Docker <br />
mvn clean package docker:build<br />
INFO] --- docker-maven-plugin:1.2.0:build (default-cli) @ MyStreamjava8 ---<br />
[INFO] Using authentication suppliers: [ConfigFileRegistryAuthSupplier]<br />
[INFO] Copying /Users/aironman/MyStreamJava8Test/target/MyStreamjava8-1.0.jar -> /Users/aironman/MyStreamJava8Test/target/docker/MyStreamjava8-1.0.jar<br />
[INFO] No resources will be copied, no files match specified patterns<br />
[INFO] Copying ./.DS_Store -> /Users/aironman/MyStreamJava8Test/target/docker/.DS_Store<br />
[INFO] Copying ./Dockerfile -> /Users/aironman/MyStreamJava8Test/target/docker/Dockerfile<br />
[INFO] Copying ./target/test-classes/logback-test.xml -> /Users/aironman/MyStreamJava8Test/target/docker/target/test-classes/logback-test.xml<br />
[INFO] Copying ./target/test-classes/Euromillones2004_2018.csv -> /Users/aironman/MyStreamJava8Test/target/docker/target/test-classes/Euromillones2004_2018.csv<br />
[INFO] Copying ./target/test-classes/pmd-eclipse.log -> /Users/aironman/MyStreamJava8Test/target/docker/target/test-classes/pmd-eclipse.log<br />
[INFO] Copying ./target/test-classes/historico_euromillones.csv -> /Users/aironman/MyStreamJava8Test/target/docker/target/test-classes/historico_euromillones.csv<br />
[INFO] Copying ./target/test-classes/com/aironman/StreamTests.class -> /Users/aironman/MyStreamJava8Test/target/docker/target/test-classes/com/aironman/StreamTests.class<br />
[INFO] Copying ./target/test-classes/primitiva.csv -> /Users/aironman/MyStreamJava8Test/target/docker/target/test-classes/primitiva.csv<br />
[INFO] Copying ./target/MyStreamjava8-1.0.jar -> /Users/aironman/MyStreamJava8Test/target/docker/target/MyStreamjava8-1.0.jar<br />
[INFO] Copying ./target/docker/MyStreamjava8-1.0.jar -> /Users/aironman/MyStreamJava8Test/target/docker/target/docker/MyStreamjava8-1.0.jar<br />
...<br />
<br />
[INFO] Building image aironman/mystreamjava8<br />
Step 1/9 : FROM java:8<br />
<br />
 ---> d23bdf5b1b1b<br />
Step 2/9 : VOLUME /tmp<br />
<br />
 ---> Using cache<br />
 ---> 8ce19e6f0684<br />
Step 3/9 : ADD target/MyStreamjava8-1.0.jar target/MyStreamjava8-1.0.jar<br />
<br />
 ---> 53ee540b91e7<br />
Step 4/9 : COPY runMe.sh runMe.sh<br />
<br />
 ---> d65a8db26d3a<br />
Step 5/9 : COPY runPermutations.sh runPermutations.sh<br />
<br />
 ---> 95da7af28b73<br />
Step 6/9 : COPY src/main/resources/Euromillones2004_2018.csv Euromillones2004_2018.csv<br />
<br />
 ---> 89e7e6a318ca<br />
Step 7/9 : COPY src/main/resources/primitiva.csv primitiva.csv<br />
<br />
 ---> 8f5b917db814<br />
Step 8/9 : RUN bash -c 'touch target/MyStreamTests.jar'<br />
<br />
 ---> Running in 103ea3c0a3e0<br />
Removing intermediate container 103ea3c0a3e0<br />
 ---> d9def7538982<br />
Step 9/9 : RUN bash -c 'sh runMe.sh em 1 Euromillones2004_2018.csv primitiva.csv'<br />
<br />
 ---> Running in 3baa2c005a88<br />
Running with arguments em 1 Euromillones2004_2018.csv primitiva.csv at Wed Dec 12 12:59:38 UTC 2018<br />
pruning winners data <br />
tr, sort, uniq, awk, print...<br />
TERM environment variable not set.<br />
<br />
pruning stars data<br /> 
tr, sort, uniq, awk, print...<br />
Deleting temporal files.<br />
Showing results.<br />
...
<br />
Done. Time duration: 0 secs.<br />
Removing intermediate container 3baa2c005a88<br />
 ---> 73cb3614f30a<br />
 ...<br />
<br />
To run the container: <br />
<br />
docker run -it 73cb3614f30a /bin/bash<br />
<br />
Where 73cb3614f30a is the container Id. To know yours, run docker ps <br />
<br />
 <br />
# Dependencies
The Project needs maven, java8 to compile and run the jar, and some unix commands to run the script: <br />
tr <br />
sort <br />
uniq <br />
awk  <br />
 <br />

I think these unix commands come by default in osx and I think they also come by default in linux, not sure in windows.  <br />
 <br />

# Actual Output with runMe.sh script set up to em 10<br />
<br />
aironman$ sh runMe.sh em 10<br />
...<br />
Running with arguments em 10000 at martes,  4 de diciembre de 2018, 13:18:13 CET<br />
<br />
pruning winners data<br /> 
tr, sort, uniq, awk, print...<br />
pruning stars data <br />
tr, sort, uniq, awk, print...<br />
Deleting temporal files.<br />
Done. Time duration: 0 secs.<br />
<br />
aironman$ cat final_output_star_martes\,\ \ 4\ de\ diciembre\ de\ 2018\,\ 13\:18\:13\ CET.txt<br /> 
10@2<br />
11@2<br />
12@1<br />
2@1<br />
3@2<br />
6@2<br />
7@3<br />
8@7<br />
Star1@10<br />
Star2@10<br />
$ cat final_output_winners_martes\,\ \ 4\ de\ diciembre\ de\ 2018\,\ 13\:18\:13\ CET.txt<br /> 
11@3<br />
12@1<br />
13@1<br />
15@1<br />
16@2<br />
17@1<br />
18@2<br />
19@1<br />
20@2<br />
22@2<br />
23@1<br />
25@1<br />
26@2<br />
27@1<br />
28@3<br />
29@3<br />
3@2<br />
31@1<br />
32@2<br />
33@1<br />
34@2<br />
36@1<br />
39@1<br />
40@2<br />
41@2<br />
42@1<br />
43@2<br />
46@3<br />
49@1<br />
8@1<br />
9@1<br />
Winner1@10<br />
Winner2@10<br />
Winner3@10<br />
Winner4@10<br />
Winner5@10<br />
<br />