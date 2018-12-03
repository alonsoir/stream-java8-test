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
It will generate two files, output.txt and final_output.txt. 800 means the number of iterations, 800 predictions. <br />
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

# Actual Output with runMe.sh script set up to em-experimental 1<br />
<br />
star 1<br />
star 9<br />
winner 1<br />
winner 15<br />
winner 26<br />
winner 38<br />
winner 50<br />
<br />