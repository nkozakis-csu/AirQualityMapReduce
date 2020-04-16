package cs455.hadoop.MeanHottestSO2;

import cs455.hadoop.FieldIndexes;
import cs455.hadoop.StateRegions;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MeanHottestSO2Mapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
	
	private String[] hottestStates = {"Arizona", "Texas", "New Mexico", "Mississippi", "Louisiana", "Arkansas", "Florida", "Oklahoma", "South Carolina", "Kansas"};
	
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] items = value.toString().split(",");
		if (items.length >= 21) {
			try {
				String state = items[FieldIndexes.StateName.index].replaceAll("\"", "");
				double measurement = Double.parseDouble(items[FieldIndexes.SampleMeasurement.index].replaceAll("\"", ""));
				for (String s : hottestStates) {
					if (state.equals(s)){
						context.write(new Text(s), new DoubleWritable(measurement));
						break;
					}
				}
			}catch(Exception ignored){
			
			}
		}
	}
}
