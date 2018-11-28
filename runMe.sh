mvn clean install 
rm output.txt
rm final_output.txt
echo "Running em-experimental"
clear && for i in {1..100}; do java -cp target/MyStreamjava8-1.0.jar com.aironman.ApiStreamTests em-experimental;done >> output.txt
echo "pruning data..."
echo "tr, sort, uniq, awk, print..."
(tr ' ' '\n' | sort | uniq -c | awk '{print $2"@"$1}') < output.txt > final_output.txt
