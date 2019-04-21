package application.logic.adventureGame;

import application.logic.arithmetic.Coordinates;

public class QuestToMove extends Quest{
	
	private Coordinates Place;
	private double Time;
	
	public QuestToMove() {
		
		Place = new Coordinates();
		Time = 0.0;
			
	}	
	
	public String checkCoordinates(double currentDistance) {
		
		super.setFinalText(String.valueOf(String.format("%.2f",Math.abs((Place.getDistance() - currentDistance)))) + " метров было пройдено за "
		+ String.valueOf(String.format("%.1f",Time)) + " минут");
		
		return endQuest();
		
	}
	
	public void generateInformationForQuestToMove()
	{
		
		Place.setxCoordinate((int)((Math.random()*100)+1));
		Place.setyCoordinate((int)((Math.random()*100)+1));
		Time = (Math.random()*10)+1;
		super.setIntroductoryText("Пройдите в точку " + '(' + String.valueOf(Place.getxCoordinate())
		+ ';' + String.valueOf(Place.getyCoordinate()) + ')' + " за " + String.valueOf(String.format("%.1f",Time))+ " минут");
		
	}
	
	public double getTime() {
		return Time;
	}
	public void setTime(double time) {
		Time = time;
	}

	public Coordinates getPlace() {
		return Place;
	}

	public void setPlace(Coordinates place) {
		Place = place;
	}

}
