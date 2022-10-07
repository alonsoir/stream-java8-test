#!/bin/sh -l

touch stream-app.jar
touch jdbc-app.jar
chmod +x /scripts/runMe.sh
chmod +x /scripts/downloadPreviousResults.sh
chmod +x /scripts/runPermutations.sh
sh /scripts/runMe.sh em 1 
