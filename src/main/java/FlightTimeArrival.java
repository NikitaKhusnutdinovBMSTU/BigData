import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FlightTimeArrival {
    private String 
    public static void main(String[] args) throws Exception {
        if (args.length != 1){
            System.err.println("Analysing time arrival of planes\nUsage: <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(FlightTimeArrival.class);
        job.setJobName("FlightTimeArrival");
        MultipleInputs.addInputPath(job, new Path("~/Desktop/hadoop/labs/2/664600583_T_ONTIME_sample.csv"), TextInputFormat.class, null);

    }
}