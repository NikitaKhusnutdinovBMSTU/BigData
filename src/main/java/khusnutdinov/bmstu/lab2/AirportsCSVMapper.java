package khusnutdinov.bmstu.lab2;

import javafx.util.Pair;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context

import java.io.IOException;

public class AirportsCSVMapper extends Mapper<LongWritable, Text, SharedKey, Text>{

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        AirportsCSVWritable airportsCSVWritable = new AirportsCSVWritable(value.toString());
        Pair<String, String> airDatePair = airportsCSVWritable.getAirportsPair();
        context.write(new SharedKey(airDatePair.getKey(), 0), new Text(airDatePair.getValue()));
    }

}
