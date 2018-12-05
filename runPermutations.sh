mvn clean install
start_time=$(date +%s)
actual_date=`date`
echo "Running with arguments $* at $actual_date"
# $1 em,primitiva,all,all-experimental
# $2 numIterations
clear && java -cp target/MyStreamjava8-1.0.jar com.aironman.PrintEveryCombinations "$1" >> output_permutations_$actual_date.txt

# Me quedo con los ganadores y las guardo en un fichero
while read linea;
do 
	grep "$linea" src/main/resources/Euromillones2004_2018.csv	
done < output_permutations_$actual_date.txt > final_permutations_$actual_date.txt

finish_time=$(date +%s)
echo "Done. Time duration: $((finish_time - start_time)) secs."
