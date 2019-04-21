package application.logic.adventureGames;

public class QuestToKill extends Quest {
	
	private String monsterType;
	private int Quantity;
	
	public QuestToKill() {
		
		monsterType = new String();
		Quantity = 0;
		
	}
	
 	public void killTheMonster() {
 		
 		Quantity-=1;
 		super.setFinalText(monsterType + " был убит, осталось: " + String.valueOf(Quantity));
 		
	}
 	
 	public void generateInformationForQuestToKill() {
 		
 		monsterType = "Monster";
		Quantity = (int)(Math.random()*10)+1;
		super.setIntroductoryText("Убейте " + String.valueOf(Quantity) + ' ' + monsterType);
 		
 	}
 	
	public String getMonsterType() {
		return monsterType;
	}
	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

}
