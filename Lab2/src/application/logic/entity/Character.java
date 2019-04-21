package application.logic.entity;

import application.logic.adventureGame.QuestToKill;
import application.logic.adventureGame.QuestToMove;
import application.logic.arithmetic.Coordinates;

public class Character {
	
	private String Race;
	private String Specialization;
	private int Level;
	private Coordinates coordinates;
	private QuestToKill questToKill;
	private QuestToMove questToMove;
	
	public Character() {
		
		this.Race = "Race";
		this.Specialization = "Class";
		this.Level = 1;
		coordinates = new Coordinates();
				
	}
	
	public String TakeTheQuest(boolean flag) {
		
		if(!flag) {
			
			questToKill = new QuestToKill();
			questToKill.generateInformationForQuestToKill();
			return questToKill.activateQuest();
			
		}
		
		questToMove = new QuestToMove();
		questToMove.generateInformationForQuestToMove();
		return questToMove.activateQuest();
		
		
	}
	
    public void Move() {
    	
    	coordinates = questToMove.getPlace();
    	Level += (int)questToMove.getTime();
    	
    }	
    
	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		Level = level;
	}
	public String getRace() {
		return Race;
	}
	public void setRace(String race) {
		Race = race;
	}
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	public QuestToKill getQuestToKill() {
		return questToKill;
	}

	public void setQuestToKill(QuestToKill questToKill) {
		this.questToKill = questToKill;
	}

	public QuestToMove getQuestToMove() {
		return questToMove;
	}

	public void setQuestToMove(QuestToMove questToMove) {
		this.questToMove = questToMove;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

}
