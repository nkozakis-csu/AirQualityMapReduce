package cs455.hadoop.MonitoringSites;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.File;
import java.io.IOException;
import cs455.hadoop.FieldIndexes;

public class CountSitesMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] items = value.toString().split(",");
		if (items.length >= 21) {
			try {
				String state = items[FieldIndexes.StateName.index];
				String county = items[FieldIndexes.CountyCode.index];
				String num = items[FieldIndexes.SiteNum.index];
				int siteCode = Integer.parseInt(county.replaceAll("\"", "") + num.replaceAll("\"", ""));
				context.write(new Text(state), new IntWritable(siteCode));
			}catch(Exception ignored){
			
			}
		}
		// over 20 and has state code
	}
}
