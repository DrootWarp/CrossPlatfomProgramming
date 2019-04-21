package application.logic.adventureGame;

public class Quest {
	
	private String introductoryText;
	private String finalText;
	
	public Quest(){
		
		introductoryText = new String();
		finalText = new String();
	}
	
	public String activateQuest() {
		return introductoryText;
	}
	public String endQuest() {
		return finalText;
	}
	public String getIntroductoryText() {
		return introductoryText;
	}
	public void setIntroductoryText(String introductoryText) {
		this.introductoryText = introductoryText;
	}
	public String getFinalText() {
		return finalText;
	}
	public void setFinalText(String finalText) {
		this.finalText = finalText;
	}

	
}
