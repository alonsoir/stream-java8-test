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
sh runMe.sh em 800<br />
It will generate two files, final_output_star_martes\,\ \ 4\ de\ diciembre\ de\ 2018\,\ 13\:18\:13\ CET.txt 
and final_output_winners_martes\,\ \ 4\ de\ diciembre\ de\ 2018\,\ 13\:18\:13\ CET.txt.
The name of the files is created using the pattern final_output_winners_$actual_date.txt and final_output_star_$actual_date.txt
$actual_date is the actual date using unix format.

800 means the number of iterations, 800 predictions. <br />
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