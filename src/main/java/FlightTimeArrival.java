import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FlightTimeArrival {
    public static void main(String[] args) throws Exception {
        if (args.length != 1){
            System.err.println("Analysing time arrival of planes\nUsage: <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();

    }
}
ÍÍÍÍЫЫ