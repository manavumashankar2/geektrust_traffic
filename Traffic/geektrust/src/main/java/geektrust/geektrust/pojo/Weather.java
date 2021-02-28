package geektrust.geektrust.pojo;

import java.util.ArrayList;
import java.util.List;

public class Weather {
	
	private WeatherType weatherType ; 
	private int cratersChangeRate ; 
	private List<String> suitableVehicleNames = new ArrayList<String>();
	  
	public Weather(WeatherType weatherType, int cratersChangeRate, List<String> suitableVehicleNames) {
		this.weatherType = weatherType;
		this.cratersChangeRate = cratersChangeRate;
		this.suitableVehicleNames = suitableVehicleNames;
	}
	
	public Weather() {
	}
 
	public WeatherType getWeatherType() {
		return weatherType;
	}
	public void setWeatherType(WeatherType season) {
		this.weatherType = season;
	}
	public int getCatersChangeRate() {
		return cratersChangeRate;
	}
	public void setCatersChangeRate(int cratersChangeRate) {
		this.cratersChangeRate = cratersChangeRate;
	}
	public List<String> getVehiclesUsed() {
		return suitableVehicleNames;
	}
	public void setVehiclesUsed(List<String> suitableVehicleNames) {
		this.suitableVehicleNames = suitableVehicleNames;
	} 
	
	

}
