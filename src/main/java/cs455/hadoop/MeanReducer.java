package cs455.hadoop;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MeanReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
	@Override
	protected void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
		int count = 0;
		double mean = 0;
		// calculate the total count
		for (DoubleWritable val : values) {
			count += 1;
			mean += val.get();
		}
		mean = mean/count;
		context.write(key, new DoubleWritable(mean));
	}
}