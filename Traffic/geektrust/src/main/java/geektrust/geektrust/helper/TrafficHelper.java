package geektrust.geektrust.helper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import geektrust.geektrust.initializer.Initializer;
import geektrust.geektrust.pojo.Orbit;
import geektrust.geektrust.pojo.Vehicle;
import geektrust.geektrust.pojo.Weather;

public class TrafficHelper {

	
	private static TrafficHelper helperInstance = new TrafficHelper();
	 
	private TrafficHelper() {
 	}

	static Initializer initializerInstance = Initializer.getInitializerInstance() ; 

 	public static TrafficHelper getInstance(){
		return helperInstance;
	}

	public static Map<LinkedHashMap<String, String>, Integer> findFastestVehicleAndOrbit(Weather weather, List<Orbit> orbits, 
			Map<LinkedHashMap<String, String>, Integer> timeTakenForVehiclesInOrbits) {

		
		for( Orbit orbit : orbits) {
			for ( String vehicle : weather.getVehiclesUsed() ) {
				
				Vehicle vehicle1 = initializerInstance.getVehicleByName(vehicle) ; 
	
				int vehicleSpeed = vehicle1.getSpeed().getValue() ; 
				
				int orbitMaxSpeed = orbit.getSpeed().getValue() ;
							
				int updatedOrbitCratersCount = (int) Math.round(orbit.getCratersCount() * (100 + weather.getCatersChangeRate()) / 100);
				
				int totalMinsToCrossCraters = updatedOrbitCratersCount * vehicle1.getMinsToCrossACrater() ; 
					
				int updatedVehicleSpeed = vehicleSpeed > orbitMaxSpeed ? orbitMaxSpeed : vehicleSpeed ;  
				
				int timeTakenByVehicle = ((  orbit.getRange() *60 )/ updatedVehicleSpeed ) ; 
				
				int totalTimeTaken = totalMinsToCrossCraters + timeTakenByVehicle ; 
		
				LinkedHashMap<String, String> vehiclesInOrbit = new LinkedHashMap<>() ;
				vehiclesInOrbit.put(vehicle,orbit.getName()) ; 
				timeTakenForVehiclesInOrbits.put(vehiclesInOrbit,totalTimeTaken) ; 
	
			}
		}
		return timeTakenForVehiclesInOrbits;
	}
}
