package khusnutdinov.bmstu.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

public class AirportsCSVMapper extends Mapper<LongWritable, Text, SharedKey, Text>{


    public AirportsCSVMapper() {

    }

    @Override
    public void map(LongWritable longWritable, Text text, OutputCollector<SharedKey, Text> outputCollector, Reporter reporter) throws IOException {
        
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public void configure(JobConf jobConf) {

    }
}
