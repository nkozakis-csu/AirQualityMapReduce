package cs455.hadoop.MeanCoastSO2;

import cs455.hadoop.FieldIndexes;
import cs455.hadoop.StateRegions;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MeanCoastSO2Mapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
	
	private StateRegions regions = new StateRegions();
	
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] items = value.toString().split(",");
		if (items.length >= 21) {
			try {
				String state = items[FieldIndexes.StateName.index].replaceAll("\"", "");
				double measurement = Double.parseDouble(items[FieldIndexes.SampleMeasurement.index].replaceAll("\"", "")); //remove quotes and parse double from measurement field
				if (regions.inWestCoast(state))
					context.write(new Text("Westcoast"), new DoubleWritable(measurement));
				else if (regions.inEastCoast(state))
					context.write(new Text("Eastcoast"), new DoubleWritable(measurement));
			}catch(Exception ignored){
			
			}
		}
	}
}
