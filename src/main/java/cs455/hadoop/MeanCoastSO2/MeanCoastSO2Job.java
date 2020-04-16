package cs455.hadoop.MeanCoastSO2;
import cs455.hadoop.MeanReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MeanCoastSO2Job {
	
	public static void main(String[] args) {
		try {
			Configuration conf = new Configuration();
			Job job = Job.getInstance(conf, "Mean Coast SO2");
			job.setJarByClass(MeanCoastSO2Job.class);
			job.setMapperClass(MeanCoastSO2Mapper.class);
			job.setCombinerClass(MeanReducer.class);
			job.setReducerClass(MeanReducer.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(DoubleWritable.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			System.exit(job.waitForCompletion(true) ? 0 : 1);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
}
