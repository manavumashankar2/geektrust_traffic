package geektrust.geektrust.pojo;

import java.io.Serializable;

public class Vehicle  {

	
	private String name ; 
	private Speed speed ; 
	private int timeToCrossACrater ;
	
	public Vehicle(String name , Speed speed , int timeToCrossACrater ) {
		this.name = name ;
		this.speed = speed ; 
		this.timeToCrossACrater = timeToCrossACrater ;
		}
	
	public String getName() {
		return name;
	}
	
	public Speed getSpeed() {
		return speed;
	}
	
	public int getMinsToCrossACrater() {
		return timeToCrossACrater;
	}
	
	
	
	
	
}
