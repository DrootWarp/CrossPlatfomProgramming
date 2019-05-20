package application.logic;

import application.logic.space.Planet;

public class mainThread implements Runnable{

	private Planet planet;
	
	public void reportCalendarEvent(String message) {
		
		System.out.println(planet.getPlanetName() +": "+message);
		
	}
	
	public void createPlanet(int day,int year,String planetName) {
		
		planet = new Planet(day,year,planetName);
		
	}

	@Override
	public void run() {
		
		int countDays = 0;
		while(true) {
			
			if(countDays > planet.getYear()) { 
				countDays = 0;
				reportCalendarEvent("С новым годом");
				}
			planet.around();
			reportCalendarEvent("Доброе утро."+" Текущий день:" + String.valueOf(countDays));
			countDays++;

		}
		
		
	}
	
}
