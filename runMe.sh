#!/bin/bash
start_time=$(date +%s)
actual_date=`date`
clear
rm *txt
echo "Running with $# arguments. $* at $actual_date" >> "output.txt"
if [ "$#" != 2 ]
then
	echo "Insuficients arguments."
	echo "bash runMe.sh em 10 /PATH_TO_Primitiva.csv"
	exit;
fi;
# downloading previous results of euromillones to updatedEuromillions.csv. This file must exist in order to work this script!
bash downloadPreviousResults.sh
# $1 em,primitiva,all,all-experimental
# $2 numIterations
# $3 PATH_TO_Euromillones2004_2018.csv
# $4 PATH_TO_Primitiva.csv
type=$1
numIterations=$2
PATH_TO_Euromillones2004_2018=updatedEuromillions.csv
PATH_TO_Primitiva=$4
clear && java -cp target/MyStreamjava8-1.0.1-RELEASE.jar com.aironman.ApiStreamTests "$type" "$numIterations" "$PATH_TO_Euromillones2004_2018" "$PATH_TO_Primitiva" >> "output.txt"

# Me quedo con los ganadores y las guardo en un fichero
while read linea;
do 
	if [[ "${linea}" =~ "Winner1" ]] 
	then echo $linea;
	fi;
	if [[ "${linea}" =~ "Winner2" ]] 
	then echo $linea;
	fi;
	if [[ "${linea}" =~ "Winner3" ]] 
	then echo $linea;
	fi;
	if [[ "${linea}" =~ "Winner4" ]] 
	then echo $linea;
	fi;
	if [[ "${linea}" =~ "Winner5" ]] 
	then echo $linea;
	fi;
done < "output.txt" > "final_winners.txt"

# echo "pruning winners data "
# echo "tr, sort, uniq, awk, print..."
echo "numIterations $numIterations"
(tr ' ' '\n' | sort | uniq -c | awk '{print "winner " $2 " appeared "$1 " times of '"$numIterations"'. Frequency is "$1*100 / '"$numIterations"'" %"}') < "final_winners.txt" > "final_output_winners.txt"

# Me quedo con las estrellas y las guardo en un fichero
while read linea;
do 
	if [[ "${linea}" =~ "Star1" ]] 
	then echo $linea;
	fi;
	if [[ "${linea}" =~ "Star2" ]] 
	then echo $linea;
	fi;
done < "output.txt" > "final_star.txt"

# echo "pruning stars data "
# echo "tr, sort, uniq, awk, print..."
(tr ' ' '\n' | sort | uniq -c | awk '{print "star " $2 " appeared "$1 " times of '"$numIterations"'. Frequency is "$1*100 / '"$numIterations"'" %"}') < "final_star.txt" > "final_output_star.txt"

# borrando temporales
echo "Deleting temporal files."
rm "final_star.txt"
rm "final_winners.txt"
mv "output_$actual_date.txt" output.txt
finish_time=$(date +%s)
# echo "Showing general results."
# cat output.txt
# echo "A general file named output.txt has been generated. "
# cat final_output_winners.txt | tail -r | tail -n +6 | tail -r > clean_final_output_winners.txt
# echo "Showing winners."
# cat "final_output_winners.txt"
# echo "Showing stars."
# cat final_output_star.txt | tail -r | tail -n +2 | tail -r > clean_final_output_star.txt
# cat "final_output_star.txt"
echo "Done. Time duration: $((finish_time - start_time)) secs."
echo "Using data..."
head -n 2 updatedEuromillions.csv
echo "opening browser."
open -a Safari http://localhost:8080/prediction
open -a Safari http://localhost:8080/frequencies
java -jar target/demo-jdbc-0.0.1-SNAPSHOT.jar final_output_winners.txt final_output_star.txt
rm "final_output_star.txt"
rm "final_output_winners.txt"
rm "output.txt"

