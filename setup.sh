#!/bin/bash
echo
while [ -n "$1" ]
do
case "$1" in
-s) echo "******START_ALL_HADOOP_BY_KHUSNUTDINOV******" &&
stop-yarn.sh && stop-dfs.sh && start-dfs.sh && 
start-yarn.sh && echo "******OFF_SAFEMODE_HDFS******" && 
hdfs dfsadmin -safemode leave && echo "******STARTING_INITIALISE******" && 
mvn package && hadoop jar target/Khusnutdinov.BMSTU-1.0-SNAPSHOT.jar khusnutdinov.bmstu.lab2.FlightTimeArrival output && 
hadoop fs -copyToLocal output && cd output && echo "******HERE_IS_THE_OUTPUT******" && cat * > solution.txt && 
mv solution.txt ../ && cd .. && rm -R ./output && hadoop fs -rm -R output;;
-d) echo "******START_HADOOP_BY_KHUSNUTDINOV******" && hdfs dfsadmin -safemode leave && echo "******STARTING_INITIALISE******" && mvn package && hadoop jar target/Khusnutdinov.BMSTU-1.0-SNAPSHOT.jar khusnutdinov.bmstu.lab2.FlightTimeArrival output && hadoop fs -copyToLocal output && cd output && echo "******HERE_IS_THE_OUTPUT******" && cat * > solution.txt && 
mv solution.txt ../ && cd .. && rm -R ./output && hadoop fs -rm -R output;;
*) echo "******NO_SUCH_PARAMETER******"
esac
shift
done