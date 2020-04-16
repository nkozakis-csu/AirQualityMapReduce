package cs455.hadoop.MeanSummerTemp;

import cs455.hadoop.FieldIndexes;
import cs455.hadoop.StateRegions;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MeanSummerTempMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
	
	private StateRegions regions = new StateRegions();
	
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] items = value.toString().split(",");
		if (items.length >= FieldIndexes.StateName.index+1) {
			try {
				String[] date = items[FieldIndexes.DateGMT.index].replaceAll("\"", "").split("-");
				int month = Integer.parseInt(date[1]);
				if (month >=6 && month <= 8) { // summer months
					String state = items[FieldIndexes.StateName.index].replaceAll("\"", "");
					double measurement = Double.parseDouble(items[FieldIndexes.SampleMeasurement.index]);
					context.write(new Text(state), new DoubleWritable(measurement));
				}
			}catch(Exception ignored){
			
			}
		}
	}
}
