#!/bin/bash
echo
while [ -n "$1" ]
do
case "$1" in
-s) echo "******START_ALL_HADOOP_BY_KHUSNUTDINOV******" &&
stop-all.sh && start-all.sh && rm -R ./output && hadoop fs -rm -R output && echo "******STARTING_INITIALISE******" && mvn package && hadoop jar target/Khusnutdinov.BMSTU-1.0-SNAPSHOT.jar khusnutdinov.bmstu.lab2.FlightTimeArrival output && hadoop fs -copyToLocal output && cd output && echo "******HERE_IS_THE_OUTPUT******" && cat * && cd .. ;;
-d) echo "******START_HADOOP_BY_KHUSNUTDINOV******" && rm -R ./output && hadoop fs -rm -R output && echo "******STARTING_INITIALISE******" && mvn package && hadoop jar target/Khusnutdinov.BMSTU-1.0-SNAPSHOT.jar khusnutdinov.bmstu.lab2.FlightTimeArrival output && hadoop fs -copyToLocal output && cd output && echo "******HERE_IS_THE_OUTPUT******" && cat * && cd .. ;;
*) echo "******NO_SUCH_PARAMETER******"
esac
shift
done