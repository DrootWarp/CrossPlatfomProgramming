package application.GUI;

import application.logic.entity.Character;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class QuestGUI {
	
	private Scene mainScene;
	private GridPane gridPane;
	private Button questToMoveButton;
	private Button questToKillButton;
	private Button createCharacterButton;
	private Label raceLabel;
	private Label specializationLabel;
	private Label levelLabel;
	private Label coordinatesLabel;
	private Character character;
	private Alert alert;
	
	public QuestGUI() {
		
		BorderPane mainPane = new BorderPane();
		character = new Character();
		alert = new Alert(Alert.AlertType.INFORMATION);
		mainScene = new Scene(mainPane, 440, 110);
		setUpGridPane();
		buildCharacterLabels();
		buildCreateCharacterButton();
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
	
    private void addActionForQuestToMoveButton()
    {
    	questToMoveButton.setOnAction(new EventHandler<ActionEvent>() {
    		
            public void handle(ActionEvent event) {	
				
            	
    	   		alert.setTitle(null);
        		alert.setHeaderText("������������� �����");
        		alert.setContentText(character.TakeTheQuest(true));
        		alert.showAndWait();
        		
        		alert.setHeaderText("����������� �����");
        		alert.setContentText(character.getQuestToMove().checkCoordinates(character.getCoordinates().getDistance()));
        		alert.showAndWait();
        		
        		character.Move();
        		
        		coordinatesLabel.setText("����������: " + '(' + String.valueOf(character.getCoordinates().getxCoordinate()) + ';' 
        				+ String.valueOf(character.getCoordinates().getyCoordinate()) + ')');
        		levelLabel.setText("������� " + String.valueOf(character.getLevel()));
        		
            }
    	});
    }
    private void addActionForQuestToKillButton() {
    	
		questToKillButton.setOnAction(event ->{
			
			
	   		alert.setTitle(null);
    		alert.setHeaderText("������������� �����");
    		alert.setContentText(character.TakeTheQuest(false));
    		alert.showAndWait();
    		
    		for(int i = 0, size = character.getQuestToKill().getQuantity(); i < size; i++)
    		{
    			
        		alert.setHeaderText("����������� �����");
        		alert.setContentText(character.getQuestToKill().killTheMonster());
        		alert.showAndWait();
        		character.setLevel(character.getLevel() + 1);
        		levelLabel.setText("�������: "  + character.getLevel());
    			
    		}
			
		});
    	
    }	
    private void addActionForCreateCharacterButton() {
		
		createCharacterButton.setOnAction( event ->{
			
			questToMoveButton.setDisable(false);
			questToKillButton.setDisable(false);
			
			raceLabel.setText(raceLabel.getText() + character.getRace());
			specializationLabel.setText(specializationLabel.getText() + character.getSpecialization());
			levelLabel.setText(levelLabel.getText() + character.getLevel());
			coordinatesLabel.setText(coordinatesLabel.getText() + '(' + character.getCoordinates().getxCoordinate()
					+ ';' + character.getCoordinates().getyCoordinate() + ')');
			
			
			createCharacterButton.setDisable(true);
			
		});
		
	}
    
    
    
    
    public Scene getMainScene() {
		return mainScene;
	}
}
