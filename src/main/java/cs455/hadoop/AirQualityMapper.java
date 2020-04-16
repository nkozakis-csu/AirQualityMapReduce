package cs455.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class AirQualityMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		// tokenize into words.
		StringTokenizer itr = new StringTokenizer(value.toString(), ",");
		// emit word, count pairs.
		while (itr.hasMoreTokens()) {
			context.write(new Text(itr.nextToken()), new IntWritable(1));
		}
		// over 20 and has state code
	}
}
