package application.logic.space;

public class Planet {

	private int day;
	private int year;
	private String planetName;
	
	public Planet(int day, int year, String planetName) {
		
		this.setDay(day);
		this.setYear(year);
		this.setPlanetName(planetName);
		
	}
	
	public void around() {
		
		try {
			Thread.sleep(day*1000);
		} catch (InterruptedException e) {}
		
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
}
