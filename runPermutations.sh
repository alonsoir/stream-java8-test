# The idea of this script is to check if any of the generated combinations of previous runMe.sh script happen before 
# in the past. For that, i will flatten the output.txt file, generate each permutation of every combination and 
# check each permutation with the file Euromillones2004_2018.csv
mvn clean install
start_time=$(date +%s)
actual_date=`date`
echo "Running with arguments $* at $actual_date"
# $1 should be an output.txt file 
clear && java -cp target/MyStreamjava8-1.0.jar com.aironman.Flattener "$1" >> flattened_output.txt

java -cp target/MyStreamjava8-1.0.jar com.aironman.PrintEveryCombinations flattened_output.txt >> output_permutations_$actual_date.txt

while read linea;
do 
	grep "$linea" src/main/resources/Euromillones2004_2018.csv	
done < output_permutations_$actual_date.txt > final_permutations_$actual_date.txt

finish_time=$(date +%s)
echo "Done. Time duration: $((finish_time - start_time)) secs."
