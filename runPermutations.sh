# The idea of this script is to check if any of the generated combinations of previous runMe.sh script happen before 
# in the past. For that, i will flatten the output.txt file, generate each permutation of every combination and 
# check each permutation with the file Euromillones2004_2018.csv
# mvn clean install
start_time=$(date +%s)
actual_date=`date`
echo "Running with arguments $* at $actual_date"
# $1 should be an output.txt file 
# $2 PATH TO Euromillions2004_2018.csv file
echo "Running flatten process using $1 and $2"
clear && java -cp target/MyStreamjava8-1.0.jar com.aironman.Flattener "$1" >> flattened_output.txt

echo "Running print permutations"
while read linea;
do
	java -cp target/MyStreamjava8-1.0.jar com.aironman.PrintEveryPermutation $linea
done < flattened_output.txt >> output_permutations_$actual_date.txt

echo "Searching for coincidences in Euromillones2004_2018.csv"
while read linea;
do 
	grep "$linea" $2	
done < output_permutations_$actual_date.txt > final_permutations_$actual_date.txt

finish_time=$(date +%s)
cat "final_permutations_$actual_date.txt"
echo "Done. Time duration: $((finish_time - start_time)) secs."
