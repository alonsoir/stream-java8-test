mvn clean install
start_time=$(date +%s)
rm output.txt
rm final_output.txt
# em,primitiva,all,all-experimental
echo "Running with arguments $*"
clear && java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests "$1" "$2" >> output.txt
echo "pruning data..."
echo "tr, sort, uniq, awk, print..."
(tr ' ' '\n' | sort | uniq -c | awk '{print $2"@"$1}') < output.txt > final_output.txt
finish_time=$(date +%s)
echo "Done. Time duration: $((finish_time - start_time)) secs."
