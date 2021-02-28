package geektrust.geektrust.initializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import geektrust.geektrust.pojo.Orbit;
import geektrust.geektrust.pojo.Speed;
import geektrust.geektrust.pojo.Vehicle;
import geektrust.geektrust.pojo.Weather;
import geektrust.geektrust.pojo.WeatherType;

public class Initializer {
	
	private static Initializer initializer = new Initializer() ; 
	
	public static Initializer getInitializerInstance() {
		return initializer ; 
	}
	
	
	public List<Orbit> getAllOrbits(){
		List<Orbit> orbits = new ArrayList<>();

		orbits.add(new Orbit("ORBIT1", 18, 20, new Speed(-1, "megamiles/hour")));
		orbits.add(new Orbit("ORBIT2", 20, 10, new Speed(-1, "megamiles/hour")));
		
		return orbits ; 
	}
	
	public List<Vehicle> getAllVehicles(){
		List<Vehicle> vehicles = new ArrayList<>();

		vehicles.add(new Vehicle("BIKE",new Speed(10, "megamiles/hour"),  2 ));
		vehicles.add(new Vehicle("TUKTUK", new Speed(12, "megamiles/hour"), 1 ));
		vehicles.add(new Vehicle("CAR",new Speed(20, "megamiles/hour") ,  3));

		return vehicles ; 
	}
	
	public List<Weather> getAllWeathers() {
		List<Weather> weathers = new ArrayList<>();
		weathers.add(new Weather(WeatherType.SUNNY, -10, Arrays.asList( "BIKE", "TUKTUK" ,"CAR")));
		weathers.add(new Weather(WeatherType.RAINY, +20, Arrays.asList("TUKTUK","CAR")));
		weathers.add(new Weather(WeatherType.WINDY, +0,  Arrays.asList("BIKE" , "CAR")));
		return weathers;
	}
	
	public Weather getWeatherByType(String weatherType) {
		return initializer.getAllWeathers().parallelStream()
				.filter(weather -> weatherType.equalsIgnoreCase(weather.getWeatherType().toString()))
				.findAny().orElse(null);
	}

	public Vehicle getVehicleByName(String name) {
		return initializer.getAllVehicles().parallelStream()
				.filter(vehicle -> name.equalsIgnoreCase(vehicle.getName()))
				.findAny().orElse(null);
	}
	
	public List<String> getAllVehiclesName() {
		return getAllVehicles().stream().map(Vehicle::getName).collect(Collectors.toList());
	}
}
