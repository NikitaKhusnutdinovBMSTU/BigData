package khusnutdinov.bmstu.lab2;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FlightTimeArrival {
    private final static String PLANES_CSV_PATH = "~/Desktop/hadoop/labs/2/664600583_T_ONTIME_sample.csv";
    private final static String AIRPORT_CSV_PATH = "~/Desktop/hadoop/labs/2/L_AIRPORT_ID.csv";

    public static void main(String[] args) throws Exception {
        if (args.length != 1){
            System.err.println("Analysing time arrival of planes\nUsage: <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(FlightTimeArrival.class);
        job.setJobName("Reduce side join");
        MultipleInputs.addInputPath(job, new Path(PLANES_CSV_PATH), TextInputFormat.class, null);
        MultipleInputs.addInputPath(job, new Path(AIRPORT_CSV_PATH), TextInputFormat.class, null);
        FileOutputFormat.setOutputPath(job, new Path(args[0]));
    }
}