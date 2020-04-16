package cs455.hadoop.MonitoringSites;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.yarn.webapp.hamlet2.Hamlet;

import java.io.IOException;
import java.util.*;

public class CountSitesReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	protected void reduce(Text state, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		TreeSet<Integer> sites = new TreeSet<>(); // list of unique sites
		int count = 0;
		for (IntWritable val : values) {
			 if(sites.add(val.get())){ // check if site has been counted before
			 	count+=1; // increment for unique site code
			 }
		}
		context.write(state, new IntWritable(count)); // could've done tree.size() but oh well.
	}
}