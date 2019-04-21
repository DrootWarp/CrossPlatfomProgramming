package application.logic;

public class Quest {
	

	protected String introductoryText;
	protected String finalText;
	
	protected String reportAboutEndQuest() {
		
		return finalText;
		
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
