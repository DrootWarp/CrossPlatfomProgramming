package application.GUI;

import java.util.ArrayList;

import application.logic.mainThread;
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

public class mainThreadGUI {
	
	private Scene mainScene;
	private GridPane gridPane;
	private Button createPlanetButton;
	private Label planetNameLabel;
	private Label planetDayLabel;
	private Label planetYearLabel;
	private TextField planetNameTextField;
	private TextField planetDayTextField;
	private TextField planetYearTextField;
	private mainThread thread;
	private ArrayList<mainThread> threadsList;
	private Alert alert;
	
	public mainThreadGUI() {
		
		BorderPane mainPane = new BorderPane();
		alert = new Alert(Alert.AlertType.INFORMATION);
		mainScene = new Scene(mainPane, 440, 130);
		setUpGridPane();
		buildLabels();
		buildCreatePlanetButton();
		buildTextFields();
		mainPane.setCenter(gridPane);
		
	}
	
	private void setUpGridPane() {
		
		gridPane = new GridPane();
		gridPane.setPadding(new Insets(5));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		
	}
	
	private void buildLabels() {
		
		planetNameLabel = new Label("Название: ");
		gridPane.add(planetNameLabel, 0, 0);
		planetDayLabel = new Label("Сутки(часов): ");
		gridPane.add(planetDayLabel, 0, 1);
		planetYearLabel = new Label("Год(суток): ");
		gridPane.add(planetYearLabel, 0, 2);
		
	}
	private void buildCreatePlanetButton() {
		
		createPlanetButton = new Button("Создать Планету");
		gridPane.add(createPlanetButton, 0, 4);
		addActionForCreatePlanetButton();
		
		
	}
	private void buildTextFields() {
		
		planetNameTextField = new TextField();
		gridPane.add(planetNameTextField, 1, 0);
		planetDayTextField = new TextField();
		gridPane.add(planetDayTextField, 1, 1);
		planetYearTextField = new TextField();
		gridPane.add(planetYearTextField, 1, 2);
	}
	
	private void addActionForCreatePlanetButton() {
		createPlanetButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				
				
				
			}
		});
		}
		
		
	

	public Scene getMainScene() {
		
		return mainScene;
	}

}
