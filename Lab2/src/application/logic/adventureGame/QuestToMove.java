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
		
		super.setFinalText("The " + String.valueOf(Place.getDistance() - currentDistance) + " distance was traveled for"
		+ String.valueOf(Time));
		
		return endQuest();
		
	}
	
	public void generateInformationForQuestToMove()
	{
		
		Place.setxCoordinate((int)((Math.random()*10)+1));
		Place.setyCoordinate((int)((Math.random()*10)+1));
		Time = (Math.random()*10)+1;
		super.setIntroductoryText("Travel to " + '(' + String.valueOf(Place.getxCoordinate())
		+ ';' + String.valueOf(Place.getyCoordinate()) + ')' + "for " + String.valueOf(Time));
		
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
