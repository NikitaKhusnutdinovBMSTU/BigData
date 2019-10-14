package khusnutdinov.bmstu.lab2;

import javafx.util.Pair;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;


public class FlightsCSVMapper extends Mapper<LongWritable, Text, SharedKey, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        FlightsCSVWritable flightsCSVWritable = new FlightsCSVWritable(value.toString());
        Pair<String, String> flightsPair = flightsCSVWritable.getFlightsCSVPair();
        context.write(new SharedKey(flightsPair.getKey().toString(), 1), new Text(flightsPair.getValue().toString()));
    }
}
