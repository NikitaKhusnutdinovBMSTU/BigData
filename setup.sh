#!/bin/bash
echo 
do
case "$1" in
-s) echo "******START_HADOOP_BY_KHUSNUTDINOV******\n"
stop-all.sh && start-all.sh && rm -R output && hadoop fs -rm -R output && echo "\n******STARTING_INITIALISE******\n" && mvn package && hadoop jar target/Khusnutdinov.BMSTU-1.0-SNAPSHOT.jar khusnutdinov.bmstu.lab2.FlightTimeArrival output && hadoop fs -copyToLocal output && cd output && echo "******HERE_IS_THE_OUTPUT******\n" && cat * && cd ..;;
*)