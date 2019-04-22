package application.GUI;

import application.logic.entity.Character;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class QuestGUI {
	
	private Scene mainScene;
	private GridPane gridPane;
	private Button questToMoveButton;
	private Button questToKillButton;
	private Button createCharacterButton;
	private Button killBoarButton;
	private Button killWerwolfButton;
	private Label raceLabel;
	private Label specializationLabel;
	private Label levelLabel;
	private Label coordinatesLabel;
	private Character character;
	private Alert alert;
	
	public QuestGUI() {
		
		BorderPane mainPane = new BorderPane();
		alert = new Alert(Alert.AlertType.INFORMATION);
		mainScene = new Scene(mainPane, 440, 130);
		setUpGridPane();
		buildCharacterLabels();
		buildCreateCharacterButton();
		buildKillMonstersButtons();
		buildQuestsButtons();
		mainPane.setCenter(gridPane);
			
	}
	
	private void setUpGridPane() {
	
		gridPane = new GridPane();
		gridPane.setPadding(new Insets(5));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		
	}

	private void buildCreateCharacterButton() {
		
		createCharacterButton = new Button("����������������");
		gridPane.add(createCharacterButton, 0, 4);
		addActionForCreateCharacterButton();
		
		}	
	private void buildKillMonstersButtons() {
		
		killBoarButton = new Button("����������");
		gridPane.add(killBoarButton, 2, 2);
		killBoarButton.setDisable(true);
		addActionForKillBoarButton();
		
		killWerwolfButton = new Button("������������");
		gridPane.add(killWerwolfButton, 2, 3);
		killWerwolfButton.setDisable(true);
		addActionForKillWerwolfButton();
		
	}
	private void buildQuestsButtons() {
		
		questToMoveButton = new Button("�����������������������");
		gridPane.add(questToMoveButton, 1, 4);
		questToMoveButton.setDisable(true);
		addActionForQuestToMoveButton();
		
		questToKillButton = new Button("��������������������");
		gridPane.add(questToKillButton, 2, 4);
		questToKillButton.setDisable(true);
		addActionForQuestToKillButton();
		
	}
	private void buildCharacterLabels() {
		
		raceLabel = new Label("����: ");
		gridPane.add(raceLabel, 0, 0);
		specializationLabel = new Label("�����: ");
		gridPane.add(specializationLabel, 0, 1);
		levelLabel = new Label("�������: ");
		gridPane.add(levelLabel, 0, 2);
		coordinatesLabel = new Label("����������: ");
		gridPane.add(coordinatesLabel, 0, 3);
		
		
	}
	
	private void addActionForKillBoarButton() {
		
		killBoarButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				
				try {
	
	    		for(int i = 0, size = character.getQuestToKill().getQuantity(); i < size; i++){
	    			
	    			character.spawnBoar();
					while(character.getBoar().getHealth() > 0 ) {
						
						character.beatMonster(false);	
	    				alert.setHeaderText("���������� ����");
	    			    alert.setContentText(character.getBoar().getQuest().getFinalText());
	    			    alert.showAndWait();
	    			    
					}
					character.beatMonster(false);
	    			
	        		alert.setHeaderText("����������� �����");
	        		alert.setContentText(character.getBoar().getQuest().endQuest());
	        		alert.showAndWait();
	        		
	        		if(character.getLevel() >= 10 && character.getLevel() <= 100) throw new Exception();
	        		
	        		character.setLevel(character.getLevel() + character.getBoar().getLevel());
	        		levelLabel.setText("�������: "  + character.getLevel());

	    			
	    		}
				killBoarButton.setDisable(true);
				questToKillButton.setDisable(false);
				
				}
				catch(Exception ex) {
						
						character.setLevel(10);
						levelLabel.setText("�������: "  + character.getLevel());
	            		alert.setHeaderText("�� �������� 10 ������");
	            		alert.setContentText("�������� Boar ������ �� �������� �������");
	            		alert.showAndWait();
	            		questToKillButton.setDisable(false);
	            		questToMoveButton.setDisable(false);
	            		killBoarButton.setDisable(true);
	            		killWerwolfButton.setDisable(true);
	            		return;
				
			}
			}
		
		});
	}
	private void addActionForKillWerwolfButton() {
		
		killWerwolfButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				
				try {
	
				for(int i = 0, size = character.getQuestToKill().getQuantity(); i < size; i++){
    			
    			character.spawnWerwolf();
				while(character.getWerwolf().getHealth() > 0) {
					
					character.beatMonster(true);	
    				alert.setHeaderText("���������� ����");
    			    alert.setContentText(character.getWerwolf().getQuest().getFinalText());
    			    alert.showAndWait();
    			    
				}
				character.beatMonster(true); 
					
        		alert.setHeaderText("����������� �����");
        		alert.setContentText(character.getWerwolf().getQuest().endQuest());
        		alert.showAndWait();
        		if(character.getLevel() >= 100) throw new Exception();
        		character.setLevel(character.getLevel() + character.getWerwolf().getLevel());
        		levelLabel.setText("�������: "  + character.getLevel());
    			
    		}
			killWerwolfButton.setDisable(true);
			questToKillButton.setDisable(false);
			questToMoveButton.setDisable(false);
				}
        	catch(Exception ex) {
        		
        		character.setLevel(100);
        		levelLabel.setText("�������: "  + character.getLevel());
        		alert.setHeaderText("�� �������� ������������� ������");
        		alert.setContentText("���������, �� ������ ������� ������ ���������");
        		alert.showAndWait();
        		questToKillButton.setDisable(true);
        		questToMoveButton.setDisable(true);
        		killBoarButton.setDisable(true);
        		killWerwolfButton.setDisable(true);
        		createCharacterButton.setDisable(false);
        		return;
        	}
    		
        }
			
		});
	}
    private void addActionForQuestToMoveButton(){
    	
    	questToMoveButton.setOnAction(new EventHandler<ActionEvent>() {
    		
            public void handle(ActionEvent event) {	
				
            	try {
    	   		alert.setTitle(null);
        		alert.setHeaderText("������������� �����");
        		alert.setContentText(character.TakeTheQuest(true));
        		alert.showAndWait();
        		
        		character.getQuestToMove().checkCoordinates(character.getCoordinates().getDistance());
        		alert.setHeaderText("����������� �����");
        		alert.setContentText(character.getQuestToMove().endQuest());
        		alert.showAndWait();
        		
        		character.Move();
        		
        		coordinatesLabel.setText("����������: " + '(' + String.valueOf(character.getCoordinates().getxCoordinate()) + ';' 
        				+ String.valueOf(character.getCoordinates().getyCoordinate()) + ')');
        		if(character.getLevel() >= 100) throw new Exception();
        		levelLabel.setText("�������: " + String.valueOf(character.getLevel()));
        		
            	}
            	catch(Exception ex) {
            		
					character.setLevel(100);
	        		levelLabel.setText("�������: "  + character.getLevel());
            		alert.setHeaderText("�� �������� ������������� ������");
            		alert.setContentText("���������, �� ������ ������� ������ ���������");
            		alert.showAndWait();
            		questToKillButton.setDisable(true);
            		questToMoveButton.setDisable(true);
            		killBoarButton.setDisable(true);
            		killWerwolfButton.setDisable(true);
            		createCharacterButton.setDisable(false);
            		return;
   
            	}
        		
            }
    	});
    }
    private void addActionForQuestToKillButton() {
    	
		questToKillButton.setOnAction(event ->{
			
			questToMoveButton.setDisable(true);
			questToKillButton.setDisable(true);
			
			character.TakeTheQuest(false);
			
			if(character.getLevel() < 10) {
			
				killBoarButton.setDisable(false);
		
				alert.setTitle(null);
				alert.setHeaderText("������������� �����");
				alert.setContentText(character.getQuestToKill().getIntroductoryText());
				alert.showAndWait();
			}
			
			if(character.getLevel() >= 10) {
			
				killBoarButton.setDisable(true);
				killWerwolfButton.setDisable(false);
		
				alert.setTitle(null);
				alert.setHeaderText("������������� �����");
				alert.setContentText(character.getQuestToKill().getIntroductoryText());
				alert.showAndWait();
				
			}
			
			
			
			
		});
    	
    }	
    private void addActionForCreateCharacterButton() {
		
		createCharacterButton.setOnAction( event ->{
			
			character = new Character();
			questToMoveButton.setDisable(false);
			questToKillButton.setDisable(false);
			
			raceLabel.setText("����: "+ character.getRace());
			specializationLabel.setText("�����: "+ character.getSpecialization());
			levelLabel.setText("�������: " + character.getLevel());
			coordinatesLabel.setText("����������: " + '(' + character.getCoordinates().getxCoordinate()
					+ ';' + character.getCoordinates().getyCoordinate() + ')');
			
			
			createCharacterButton.setDisable(true);
			
		});
		
	}
      
    public Scene getMainScene() {
		return mainScene;
	}
}