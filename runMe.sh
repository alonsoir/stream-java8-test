# mvn clean install
start_time=$(date +%s)
actual_date=`date`
echo "Running with arguments $* at $actual_date"
# $1 em,primitiva,all,all-experimental
# $2 numIterations
clear && java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests "$1" "$2" >> output_$actual_date.txt

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
done < output_$actual_date.txt > final_winners_$actual_date.txt

echo "pruning winners data "
echo "tr, sort, uniq, awk, print..."
(tr ' ' '\n' | sort | uniq -c | awk '{print $2"@"$1}') < final_winners_$actual_date.txt > final_output_winners_$actual_date.txt

# Me quedo con las estrellas y las guardo en un fichero
while read linea;
do 
	if [[ "${linea}" =~ "Star1" ]] 
	then echo $linea;
	fi;
	if [[ "${linea}" =~ "Star2" ]] 
	then echo $linea;
	fi;
done < output_$actual_date.txt > final_star_$actual_date.txt

echo "pruning stars data "
echo "tr, sort, uniq, awk, print..."
(tr ' ' '\n' | sort | uniq -c | awk '{print $2"@"$1}') < final_star_$actual_date.txt > final_output_star_$actual_date.txt

# borrando temporales
echo "Deleting temporal files."
rm "final_star_$actual_date.txt"
rm "final_winners_$actual_date.txt"
mv "output_$actual_date.txt" output.txt
finish_time=$(date +%s)
echo "Done. Time duration: $((finish_time - start_time)) secs."
cat output.txt
