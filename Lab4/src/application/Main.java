package application;
	
import application.GUI.mainThreadGUI;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			mainThreadGUI QuestGUIScene = new mainThreadGUI();
			primaryStage.setTitle("Lab4");
			primaryStage.setScene(QuestGUIScene.getMainScene());
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
