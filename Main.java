package projectATM;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
		}

	
	public void start(Stage primaryStage) throws Exception {
		GUI gui =  new GUI(primaryStage);
		primaryStage.setTitle("ATM");
		gui.welcome();
		primaryStage.setScene(gui.getScene());
		
		primaryStage.show();
	} 

		
	}


