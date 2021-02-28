package geektrust.geektrust.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import geektrust.geektrust.helper.TrafficHelper;
import geektrust.geektrust.initializer.Initializer;
import geektrust.geektrust.input.ReadInputFile;
import geektrust.geektrust.pojo.Orbit;
import geektrust.geektrust.pojo.Weather;
import geektrust.geektrust.pojo.WeatherType;;

public class Geektrust {

		
	final static String INPUT_DELIMITER = " " ; 
	
	public static void main(String [] args) {
		
		String filePath = args[0];

		String inputData = ReadInputFile.getData(filePath);
		
		String data[] = inputData.split(INPUT_DELIMITER) ; 
		String weatherType = data[0] ; 
		
		int orbitInputCount = data.length -1 ; 
		
		if(!WeatherType.contains(weatherType)) {
			System.out.println("Invalid weather type!");
			return;
		}	
		
		Initializer instance = Initializer.getInitializerInstance() ; 
				
		Weather weather = instance.getWeatherByType(weatherType) ; 
		
		List<Orbit> orbits = instance.getAllOrbits() ; 
		
		Map<String, Integer> orbitMaxSpeedMap = new LinkedHashMap<>();

		int i = 1 ; 
		
		for( Orbit orbit : orbits) {
			orbitMaxSpeedMap.put(orbit.getName() , Integer.parseInt(data[i++])) ; 
			if(i>orbitInputCount) {
				//System.out.println("Invalid input for orbit speed!");				
				break ; 
			}
		}
		
		orbits.stream()
			.forEach(orbit -> orbit.getSpeed().setValue(
					orbitMaxSpeedMap.get(orbit.getName())!=null ?orbitMaxSpeedMap.get(orbit.getName()) : 0)) ;
				
		Map<LinkedHashMap<String, String>, Integer> timeTakenForVehiclesInOrbits= new LinkedHashMap<LinkedHashMap<String, String>, Integer>() ; 

		timeTakenForVehiclesInOrbits = TrafficHelper.findFastestVehicleAndOrbit( weather , orbits , timeTakenForVehiclesInOrbits  ) ;
				
		printFastestVehicleAndOrbit(timeTakenForVehiclesInOrbits);
	
	}

	private static void printFastestVehicleAndOrbit(
			Map<LinkedHashMap<String, String>, Integer> timeTakenForVehiclesInOrbits) {
				//get the fastest car and the orbit
				for (Entry<LinkedHashMap<String, String>, Integer> entry : timeTakenForVehiclesInOrbits.entrySet()) {
		            if (entry.getValue().equals(Collections.min(timeTakenForVehiclesInOrbits.values()))) {
		            	for(Entry<String , String> entry1 : entry.getKey().entrySet()) {
		        			System.out.println(entry1.getKey() + " " + entry1.getValue()) ; 
		        			//returning first 'vehicle-orbit' pair in the order ( BIKE -> TUKTUK -> CAR) when there is a tie 
		        			return;
		        		}
		            }
		        }
	}

	
	
}
