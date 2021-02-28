package geektrust.geektrust.pojo;

public class Orbit {
	
	private String name  ; 
	private int range  ; 
	private int cratersCount ;
	private Speed speed ; 
	
	
	public Orbit(String name , int range, int cratersCount , Speed speed) {
		this.name = name ; 
		this.range = range ; 
		this.cratersCount = cratersCount ;
		this.speed = speed ;
		
	}
		
	public String getName() {
		return name;
	}
	public int getRange() {
		return range;
	}
	public int getCratersCount() {
		return cratersCount;
	}
	public Speed getSpeed() {
		return speed;
	}

	@Override
	public String toString() {
		return "Orbit [name=" + name + ", range=" + range + ", cratersCount=" + cratersCount + ", speed=" + speed + "]";
	}


}
