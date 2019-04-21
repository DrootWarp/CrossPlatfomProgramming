package application.logic.entity;

import application.logic.QuestToKill;

public class Boar extends Monster{

	public Boar(QuestToKill quest){
		
		super.setHealth(10);
		super.setLevel(2);
		super.setMonsterType("Boar");
		super.setQuest(quest);
		
	}
	
}
