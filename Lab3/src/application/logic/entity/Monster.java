package application.logic.entity;

import application.logic.QuestToKill;

public abstract class Monster {
	
	private String monsterType;
	private int level;
	private int health;
	private QuestToKill quest;
	
	public void TakeDamage(int damageTaken) {
		
		health -= damageTaken; 
		quest.setFinalText("Dealt " + String.valueOf(damageTaken) + ", left " + String.valueOf(health) + " health");
		if(health <= 0 ) Die();
		
	}
	private void Die() {
		
		quest.setMonsterType(monsterType);
		quest.killTheMonster();
		
	}
	public String getMonsterType() {
		return monsterType;
	}
	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public QuestToKill getQuest() {
		return quest;
	}
	public void setQuest(QuestToKill quest) {
		this.quest = quest;
	}

}
