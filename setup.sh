#!/bin/bash
echo
while [ -n "$1" ]
do
case "$1" in
-s)rm -R output; hadoop fs -rm -R output; echo "******START_ALL_HADOOP_BY_KHUSNUTDINOV******" &&
stop-yarn.sh && stop-dfs.sh && start-dfs.sh && 
start-yarn.sh && 
echo "******STARTING_INITIALISE******" && 
mvn package && hadoop jar target/*.jar khusnutdinov.bmstu.lab2.FlightTimeArrival output && 
hadoop fs -copyToLocal output && cd output && echo "******HERE_IS_THE_OUTPUT******" && cat * > solution.txt && 
mv solution.txt ../ && cd .. && rm -R ./output && hadoop fs -rm -R output;;
-d)rm -R output; hadoop fs -rm -R output; echo "******START_HADOOP_BY_KHUSNUTDINOV******" && echo "******STARTING_INITIALISE******" && mvn package && hadoop jar target/Khusnutdinov.BMSTU-1.0-SNAPSHOT.jar khusnutdinov.bmstu.lab2.FlightTimeArrival output && hadoop fs -copyToLocal output && cd output && echo "******HERE_IS_THE_OUTPUT******" && cat * > solution.txt && 
mv solution.txt ../ && cd .. && rm -R ./output && hadoop fs -rm -R output;;
*) echo "******USAGE: -d classic_start(without reboot), -s start_with_reboot OUTPUT_IN_SOLUTION.TXT******"
esac
shift
done