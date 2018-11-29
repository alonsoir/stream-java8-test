start_time=$(date +%s)
mvn clean install 
rm output.txt
rm final_output.txt
# em,primitiva,all,all-experimental
mode="em"
echo "Running $mode mode..."
clear && for i in {1..15000000}; do java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests $mode;done >> output.txt
echo "pruning data..."
echo "tr, sort, uniq, awk, print..."
(tr ' ' '\n' | sort | uniq -c | awk '{print $2"@"$1}') < output.txt > final_output.txt
finish_time=$(date +%s)
echo "Done!"
echo "Time duration: $((finish_time - start_time)) secs."
