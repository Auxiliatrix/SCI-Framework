package scilib.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import sci.SCI;
import scilib.objects.TeamData;

public class DataParser {
	
	private static FileConverter fc;
	
	public DataParser() {
		fc = new FileConverter();
	}
	
	public ArrayList<TeamData> process(String fileName) {
		ArrayList<TeamData> teams = new ArrayList<TeamData>();
		HashMap<String, ArrayList<Double>> data = new HashMap<String, ArrayList<Double>>();
		ArrayList<String> lines = fc.convert(fileName);
		
		for( String line : lines ) {
			if( fc.compress(line).startsWith("teamnumber") ) {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(line);
				sc.useDelimiter(",");
				while( sc.hasNext() ) {
					String next = sc.next();
					next = fc.compress(next);
					if( !(next.equals("") || next.equals("teamnumber")) ) {
						teams.add(new TeamData(next));
					}
				}
				break;
			}
		}
		
		for( String dataType : SCI.configuration.dataTypes ) {
			for( String line : lines ) {
				if( fc.compress(line).startsWith(dataType) ) {
					data.put(dataType, parse(dataType, line));
					break;
				}
			}
		}
		
		for( String key : data.keySet() ) {
			ArrayList<Double> variableData = data.get(key);
			for( int f=0; f<variableData.size(); f++ ) {
				TeamData team = teams.get(f);
				team.data.put(key, variableData.get(f));
			}
		}
		
		return teams;
	}
	
	public ArrayList<Double> parse(String dataType, String line) {
		ArrayList<Double> parseData = new ArrayList<Double>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(line);
		sc.useDelimiter(",");
		while( sc.hasNext() ) {
			String next = sc.next();
			next = fc.compress(next);
			if( !(next.equals("") || next.equals(dataType)) ) {
				parseData.add(Double.parseDouble(next));
			}
		}
		return parseData;
	}
	
}
