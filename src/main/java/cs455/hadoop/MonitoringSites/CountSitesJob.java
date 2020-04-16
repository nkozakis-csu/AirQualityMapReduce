package cs455.hadoop.MonitoringSites;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class CountSitesJob {
	
	public static void main(String[] args) {
		try {
			Configuration conf = new Configuration();
			Job job = Job.getInstance(conf, "Count Sites");
			job.setJarByClass(CountSitesJob.class);
			job.setMapperClass(CountSitesMapper.class);
			job.setCombinerClass(CountSitesReducer.class);
			job.setReducerClass(CountSitesReducer.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(IntWritable.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			MultipleInputs.addInputPath(job,new Path(args[0]), TextInputFormat.class,CountSitesMapper.class);
			MultipleInputs.addInputPath(job,new Path(args[1]), TextInputFormat.class,CountSitesMapper.class);
			FileOutputFormat.setOutputPath(job, new Path(args[2]));
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
