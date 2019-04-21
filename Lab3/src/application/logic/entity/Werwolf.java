package application.logic.entity;

import application.logic.QuestToKill;

public class Werwolf extends Monster{

	public Werwolf(QuestToKill quest){
		
		super.setHealth(30);
		super.setLevel(10);
		super.setMonsterType("Werwolf");
		super.setQuest(quest);
	}
	
}
