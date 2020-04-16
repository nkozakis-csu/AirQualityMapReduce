package cs455.hadoop;

public enum FieldIndexes {
	
	StateCode(0),
	CountyCode(1),
	SiteNum(2),
	ParameterCode(3),
	POC(4),
	Latitude(5),
	Longitude(6),
	Datum(7),
	ParameterName(8),
	DateLocal(9),
	TimeLocal(10),
	DateGMT(11),
	TimeGMT(12),
	SampleMeasurement(13),
	StateName(21),
	CountyName(22)
	;
	
	
	
	public int index;
	
	FieldIndexes(int index){
		this.index = index;
	}

}
