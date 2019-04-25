package programmaColloquio.model;

public class Temperatura {

	int day;
	float tmax;
	float tmin;
	public Temperatura(int day, float tmax, float tmin) {
		super();
		this.day = day;
		this.tmax = tmax;
		this.tmin = tmin;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public float getTmax() {
		return tmax;
	}
	public void setTmax(int tmax) {
		this.tmax = tmax;
	}
	public float getTmin() {
		return tmin;
	}
	public void setTmin(int tmin) {
		this.tmin = tmin;
	}
	@Override
	public String toString() {
		return "Temperatura [day=" + day + ", tmax=" + tmax + ", tmin=" + tmin + "]";
	}
	

	
	
}
