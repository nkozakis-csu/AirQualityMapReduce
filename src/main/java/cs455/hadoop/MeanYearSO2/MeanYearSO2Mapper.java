package cs455.hadoop.MeanYearSO2;

import cs455.hadoop.FieldIndexes;
import cs455.hadoop.StateRegions;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MeanYearSO2Mapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
	
	private StateRegions regions = new StateRegions();
	
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] items = value.toString().split(",");
		if (items.length >= FieldIndexes.SampleMeasurement.index+1) {
			try {
				double measurement = Double.parseDouble(items[FieldIndexes.SampleMeasurement.index]);
				String[] date = items[FieldIndexes.DateGMT.index].replaceAll("\"", "").split("-"); //remove quotes and split by -
				String year = date[0]; // first position is year
				context.write(new Text(year), new DoubleWritable(measurement));
			}catch(Exception ignored){
			
			}
		}
	}
}
