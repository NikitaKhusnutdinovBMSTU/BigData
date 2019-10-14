package khusnutdinov.bmstu.lab2;

import org.apache.curator.shaded.com.google.common.primitives.Doubles;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FlightArrivalPartitioner extends Partitioner<SharedKey, Text> {
    public FlightArrivalPartitioner(){
        //pass
    }

    public int getPartition(SharedKey key, Text value, int numReduceTasks){
        Double airportID = Doubles.tryParse(key.getAirportID());
        return airportID.intValue() % numReduceTasks;
    }
}
