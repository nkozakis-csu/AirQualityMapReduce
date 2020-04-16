package cs455.hadoop;

public class StateRegions {
	
	String[] westcoast = {"California", "Oregon", "Washington", "Alaska"};
	
	public String[] eastcoast = {"Maine", "New Hampshire", "Massachusetts", "Rhode Island",
	"Connecticut", "New York", "New Jersey", "Delaware", "Maryland", "Virginia", "North Carolina", "South Carolina",
	"Georgia", "Florida", "Pennsylvania", "District Of Columbia"};
	
	public boolean inWestCoast(String state){
		for (String s : westcoast) {
			if (state.equals(s)){
				return true;
			}
		}
		return false;
	}
	
	public boolean inEastCoast(String state){
		for (String s : eastcoast) {
			if (state.equals(s)){
				return true;
			}
		}
		return false;
	}
}
