package cs455.hadoop;

public enum FieldIndexes {
	
	StateCode(1),
	CountyCode(2),
	SiteNum(3),
	ParameterCode(4),
	POC(5),
	Latitude(6),
	Longitude(7),
	Datum(8),
	ParameterName(9),
	DateLocal(10),
	TimeLocal(11)
	;
	
	
	
	public int index;
	
	FieldIndexes(int index){
		this.index = index;
	}

}
