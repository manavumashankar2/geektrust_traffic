package geektrust.geektrust.pojo;

import java.util.Arrays;
import java.util.EnumSet;

public enum WeatherType {

	
	SUNNY("Sunny"),
	
	
	RAINY("Rainy"),
	
    
	WINDY("Windy");

	private static final WeatherType[] ENUMS = WeatherType.values();

	private WeatherType() {
	}

	 
	public static WeatherType[] getWeatherSeasons()  {
		return ENUMS ; 
	}	
	
	
	public static boolean contains(String weatherType) {
		return Arrays.stream(ENUMS	)
				.anyMatch(weatherSeason -> weatherSeason.toString().equalsIgnoreCase(weatherType));
	}
	
	private String season;

    private WeatherType(String season) {
        this.season = season;
    }

   
}