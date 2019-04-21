package application.logic.entity;

import application.logic.adventureGames.QuestToKill;

public class Werwolf extends Monster{

	public Werwolf(QuestToKill quest){
		
		super.setHealth(30);
		super.setLevel(5);
		super.setMonsterType("Werwolf");
		super.setQuest(quest);
	}
	
}
