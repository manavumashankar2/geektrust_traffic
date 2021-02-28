package geektrust.geektrust.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.mockito.*;
import org.powermock.api.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.mockito.Mock;
import static org.mockito.Matchers.*;


import geektrust.geektrust.helper.TrafficHelper;
import geektrust.geektrust.initializer.Initializer;
import geektrust.geektrust.input.ReadInputFile;
import geektrust.geektrust.pojo.Orbit;
import geektrust.geektrust.pojo.Speed;
import geektrust.geektrust.pojo.Weather;
import org.powermock.modules.junit4.PowerMockRunner;

//@PrepareForTest({ ReadInputFile.class  , Geektrust.class})
@RunWith(PowerMockRunner.class)
public class GeektrustTest {

	private Geektrust geektrust ; 
	final static String INPUT_DELIMITER = " " ; 
	
	@Before
    public void setupMock() {
        // Mock
		PowerMockito.spy(Geektrust.class);
    }
	
	@Mock
	TrafficHelper trafficHelper ;
	@Test
	public void mockMainMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
		
		String args []  = { "C:/Users/manav.k/eclipse-workspace/geektrust/target/input.txt" } ; 
		
		//Mockito.mock(Geektrust.class);
		Mockito.mock(Weather.class);
		Mockito.mock(Initializer.class);
		Mockito.mock(Orbit.class);
				
		Initializer instance = Initializer.getInitializerInstance() ;		
		
		Weather weather = instance.getWeatherByType("WINDY") ; 
		instance = Mockito.spy(instance) ; 		
		Mockito.when(instance.getWeatherByType(anyString())).thenReturn(weather) ; 
		
		List<Orbit> orbits = new ArrayList<>();

		orbits.add(new Orbit("ORBIT1", 18, 20, new Speed(-1, "megamiles/hour")));
		orbits.add(new Orbit("ORBIT2", 20, 10, new Speed(-1, "megamiles/hour")));
		
		Mockito.when(instance.getAllOrbits()).thenReturn(orbits) ; 
		
		Map<LinkedHashMap<String, String>, Integer> timeTakenForVehiclesInOrbits= new LinkedHashMap<LinkedHashMap<String, String>, Integer>() ; 

		LinkedHashMap<String, String> vehiclesInOrbit = new LinkedHashMap<>() ;
		vehiclesInOrbit.put("CAR","ORBIT1") ; 
		timeTakenForVehiclesInOrbits.put(vehiclesInOrbit,120) ; 
				
		mockStatic(TrafficHelper.class);
		
//		
//		Mockito.when(TrafficHelper.getInstance())
//		.thenReturn(th);
//	
		
	   // expect(TrafficHelper.findFastestVehicleAndOrbit(any(Weather.class) ,anyList(), anyMap())).andReturn(timeTakenForVehiclesInOrbits);

//		Mockito.when(TrafficHelper.findFastestVehicleAndOrbit(any(Weather.class) ,Mockito.<Orbit>anyList(), anyMap() ))
//			.thenReturn(timeTakenForVehiclesInOrbits);
//		
		Geektrust gt = new Geektrust() ; 
		
		Method method = Geektrust.class.getDeclaredMethod("printFastestVehicleAndOrbit", Map.class);
		method.setAccessible(true);
		
		method.invoke(gt , timeTakenForVehiclesInOrbits);
				
		Geektrust.main( args);
	
		System.out.println("Success");	
		
	
	}

	 

	
	
}
