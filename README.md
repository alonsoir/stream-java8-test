# java8-streaming
Playing with functional java8 style streaming api. <br />

# How to use <br />
You can import to eclipse the maven project and run the tests or you can compile the project and run it with next command: <br />

# To show Euromillions and primitiva <br />
java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests all  <br />

# To show only Euromillions <br />
java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests em  <br />

# To show only primitiva <br />
java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests primitiva  <br />

Actual output of main class. <br />
<br />
[INFO] Finished at: 2018-11-23T16:50:32+01:00 <br />
[INFO] ------------------------------------------------------------------------
$ java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests all <br />
Star1  1 frequency is 204 <br />
Star2  10 frequency is 136 <br />
Winner1  24 frequency is 6 <br />
Winner2  25 frequency is 32 <br />
Winner3  22 frequency is 43 <br />
Winner4  29 frequency is 38 <br />
Winner5  8 frequency is null <br />
Primitiva 2017.  <br />
EMPojo [number=3, total_2017=21, total_2018=6]  <br />
EMPojo [number=35, total_2017=20, total_2018=14] <br />
EMPojo [number=26, total_2017=18, total_2018=15] <br />
EMPojo [number=20, total_2017=17, total_2018=8] <br />
EMPojo [number=22, total_2017=16, total_2018=14] <br />
EMPojo [number=28, total_2017=16, total_2018=14] <br />
EMPojo [number=29, total_2017=16, total_2018=6] <br />
Primitiva 2018.  <br />
EMPojo [number=24, total_2017=10, total_2018=18] <br />
EMPojo [number=40, total_2017=12, total_2018=18] <br />
EMPojo [number=9, total_2017=15, total_2018=17] <br />
EMPojo [number=11, total_2017=15, total_2018=16] <br />
EMPojo [number=34, total_2017=9, total_2018=16] <br />
EMPojo [number=26, total_2017=18, total_2018=15] <br />
EMPojo [number=36, total_2017=11, total_2018=15] <br />
Done! <br />
 <br />
 <br />

Actual Output of tests. <br />
<br />
Most of logger info is set up in debug mode.
 <br />
 [main] INFO com.aironman.StreamTests - Reading Euromillones2004_2018.csv <br />
[main] INFO com.aironman.Utils - type: Star1  number is 7 frequency is 72 <br />
[main] INFO com.aironman.Utils - type: Star2  number is 12 frequency is 32 <br />
[main] INFO com.aironman.Utils - type: Winner1  number is 18 frequency is 15 <br />
[main] INFO com.aironman.Utils - type: Winner2  number is 14 frequency is 43 <br />
[main] INFO com.aironman.Utils - type: Winner3  number is 36 frequency is 30 <br />
[main] INFO com.aironman.Utils - type: Winner4  number is 15 frequency is 5 <br />
[main] INFO com.aironman.Utils - type: Winner5  number is 24 frequency is 6 <br />
 <br />
  <br />
[main] INFO com.aironman.StreamTests - reading primitiva.csv sorted from max to min by total_2017, 7 values...  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=3, total=413, total_2017=21, total_2018=6]  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=35, total=397, total_2017=20, total_2018=14]  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=26, total=387, total_2017=18, total_2018=15]  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=20, total=361, total_2017=17, total_2018=8]  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=22, total=405, total_2017=16, total_2018=14]  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=28, total=383, total_2017=16, total_2018=14]  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=29, total=391, total_2017=16, total_2018=6]  <br />
[main] INFO com.aironman.StreamTests - reading primitiva.csv sorted from max to min by total_2018, 7 values...  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=24, total=368, total_2017=10, total_2018=18]  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=40, total=397, total_2017=12, total_2018=18]  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=9, total=391, total_2017=15, total_2018=17]  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=11, total=403, total_2017=15, total_2018=16]  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=34, total=394, total_2017=9, total_2018=16]  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=26, total=387, total_2017=18, total_2018=15]  <br />
[main] INFO com.aironman.StreamTests - EMPojo [number=36, total=396, total_2017=11, total_2018=15]  <br />
  <br />  
  <br />
