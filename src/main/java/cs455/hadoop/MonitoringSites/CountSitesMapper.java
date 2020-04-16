package cs455.hadoop.MonitoringSites;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.File;
import java.io.IOException;
import cs455.hadoop.FieldIndexes;

public class CountSitesMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
	
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] items = value.toString().split(",");
		if (items.length > 3) {
			int state = Integer.parseInt(items[FieldIndexes.StateCode.index]);
			int siteNum = Integer.parseInt(items[FieldIndexes.SiteNum.index]);
			context.write(new IntWritable(state), new IntWritable(siteNum));
		}
		// over 20 and has state code
	}
}
