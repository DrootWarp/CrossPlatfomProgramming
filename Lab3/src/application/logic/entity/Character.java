package application.logic.entity;

import application.logic.QuestToKill;
import application.logic.QuestToMove;
import application.logic.arithmetic.Coordinates;

public class Character {
	
	private String Race;
	private String Specialization;
	private int Level;
	private Coordinates coordinates;
	private QuestToKill questToKill;
	private QuestToMove questToMove;
	private Boar boar;
	private Werwolf werwolf;
	
	public Character() {
		
		this.Race = "Race";
		this.Specialization = "Class";
		this.Level = 1;
		coordinates = new Coordinates();
				
	}
	
	public void beatMonster(boolean flag) {
		
		if(!flag) {
				boar.TakeDamage(Level);
			return;
		}
			werwolf.TakeDamage(Level);
		
	}
	public void spawnBoar() {
		
		boar = new Boar(questToKill);
		
	}
	public void spawnWerwolf() {
		
		werwolf = new Werwolf(questToKill);
		
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

	public Boar getBoar() {
	
		return boar;
	}

	public Werwolf getWerwolf() {
		return werwolf;
		
	}

}
