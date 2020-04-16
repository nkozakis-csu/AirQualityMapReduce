package cs455.hadoop;

public enum FieldIndexes {
	
	CountyCode(1),
	SiteNum(2),
	DateGMT(11),
	TimeGMT(12),
	SampleMeasurement(13),
	StateName(21)
	;
	
	
	
	public int index;
	
	FieldIndexes(int index){
		this.index = index;
	}

}
