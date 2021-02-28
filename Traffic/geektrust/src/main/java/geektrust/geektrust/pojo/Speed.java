package geektrust.geektrust.pojo;

public class Speed  {
	
	private int value ; 
	private String  unit;// megamiles/hour.

	public Speed() {
	}
	
	public Speed(int speed, String unit) {
		this.value = speed;
		this.unit = unit;
	}
	
	public int getValue() {
		return this.value;
	}

	public void setValue(int speed) {
		this.value = speed;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Speed [speed=" + value + ", unit=" + unit + "]";
	}
	
	
}