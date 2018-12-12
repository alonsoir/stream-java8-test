# mvn clean install
start_time=$(date +%s)
actual_date=`date`
clear
rm *txt
echo "Running with arguments $* at $actual_date"
# $1 em,primitiva,all,all-experimental
# $2 numIterations
# $3 PATH_TO_Euromillones2004_2018.csv
# $4 PATH_TO_Primitiva.csv
clear && java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests "$1" "$2" "$3" "$4" >> "output_$actual_date.txt"

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
done < "output_$actual_date.txt" > "final_winners_$actual_date.txt"

# echo "pruning winners data "
# echo "tr, sort, uniq, awk, print..."
(tr ' ' '\n' | sort | uniq -c | awk '{print "winner " $2 " appeared "$1 " times."}') < "final_winners_$actual_date.txt" > "final_output_winners_$actual_date.txt"

# Me quedo con las estrellas y las guardo en un fichero
while read linea;
do 
	if [[ "${linea}" =~ "Star1" ]] 
	then echo $linea;
	fi;
	if [[ "${linea}" =~ "Star2" ]] 
	then echo $linea;
	fi;
done < "output_$actual_date.txt" > "final_star_$actual_date.txt"

# echo "pruning stars data "
# echo "tr, sort, uniq, awk, print..."
(tr ' ' '\n' | sort | uniq -c | awk '{print "star " $2 " appeared "$1 " times."}') < "final_star_$actual_date.txt" > "final_output_star_$actual_date.txt"

# borrando temporales
# echo "Deleting temporal files."
rm "final_star_$actual_date.txt"
rm "final_winners_$actual_date.txt"
mv "output_$actual_date.txt" output.txt
finish_time=$(date +%s)
# echo "Showing general results."
# cat output.txt
echo "A general file named output.txt has been generated. "
echo "Showing winners."
cat "final_output_winners_$actual_date.txt"
echo "Showing stars."
cat "final_output_star_$actual_date.txt"
echo "Done. Time duration: $((finish_time - start_time)) secs."
