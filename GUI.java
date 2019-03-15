package projectATM;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI {
	CreditCard card;
	Transaction trans = new Transaction();
	Scene scene;
	Stage stage;
	int val = trans.getValue();

	public GUI(Stage stage) {
		this.stage = stage;
	}

	public void welcome() {
		card = new CreditCard();
		String check1 = card.savedCard;
		Label welcome1 = new Label("type your card number");
		Label valid = new Label();
		TextField card = new TextField();
		Button button = new Button("next");
		GridPane welc = new GridPane();
		welc.add(welcome1, 0, 0);
		welc.add(card, 0, 1);
		welc.add(button, 0, 2);
		welc.add(valid, 0, 3);
		scene = new Scene(welc, 600, 400);

		button.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				String check = card.getText();
				if (check.equals(check1)) {
					stage.setScene(menu());
				} else {
					valid.setText("This Card is not found please enter a valid card");
				}

			}
		});

	}

	public Scene getScene() {
		return this.scene;
	}

	public Scene menu() {
		//trans.value=val;
		trans.setValue(val);
		Label label1 = new Label();
		Button butWD = new Button("WithDraw");
		butWD.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {	
				stage.setScene(withdraw());
			}
		});
		Button butDEP = new Button("Deposit");
		butDEP.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				stage.setScene(deposit());
			}
		});

		Button butBI = new Button("Balance Inquiry");
		butBI.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				stage.setScene(inq());
			}
		});
		Button butPR = new Button("Prev");
		
		butPR.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				trans.prev();
				label1.setText(trans.getString());
				
			}
		});
		Button butNE = new Button("Next");
		
		butNE.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				trans.next();
				label1.setText(trans.getString());
				
			}
		});
		GridPane grid = new GridPane();
		grid.add(butWD, 0, 0);
		grid.add(label1, 1, 0);
		grid.add(butDEP, 0, 1);
		grid.add(butBI, 0, 2);
		grid.add(butPR, 0, 3);
		grid.add(butNE, 1, 3);
		Scene main = new Scene(grid, 600, 400);
		return main;
	}

	public Scene withdraw() {
		Scene WD;
		//trans.value=val;
		trans.setValue(val);
		Label label1 = new Label("Your current amount : " + val);
		Label label2 = new Label("type the amount you want to withdraw");
		Label label3 = new Label();
		TextField text = new TextField();
		Button menu = new Button("Back to menu");
		menu.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			stage.setScene(menu());
				
			}
		});
		Button butcheck = new Button("Done");
		GridPane grid = new GridPane();
		grid.add(label1, 0, 0);
		grid.add(label2, 0, 1);
		grid.add(text, 1, 1);
		grid.add(label3, 0, 2);
		grid.add(butcheck, 0, 3);
		grid.add(menu, 0, 4);
		
		butcheck.setOnAction(new EventHandler<ActionEvent>() {
			

			public void handle(ActionEvent event) {
			//	int x = Integer.parseInt(text.getText());
				try {
				    Integer.parseInt(text.getText());
				    if (trans.withdraw(Integer.parseInt(text.getText()))) {
						val-=Integer.parseInt(text.getText());
						label3.setText("your transaction was done successfully");
					} else
						label3.setText("Sorry this amount is invalid");
				

				} catch (NumberFormatException e) {
				label3.setText("INVALID INPUT!");
				}
			}
		});
		WD = new Scene(grid, 600, 400);
		return WD;
	}

	public Scene deposit() {
		trans.setValue(val);
		Label label1 = new Label("Your current amount : " + val);
		Label label2 = new Label("type the amount you want to Deposit");
		Label label3 = new Label();
		TextField text = new TextField();
		Button butcheck = new Button("done");
		Button menu = new Button("Back to menu");
		menu.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			stage.setScene(menu());
				
			}
		});
		butcheck.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
				  //  Integer.parseInt(text.getText());
				    int x = Integer.parseInt(text.getText());
					if(trans.deposit(x))
					{val+=x;
					label3.setText("Your new amount is" + val);
					}
					else
						label3.setText("Sorry you entered a negative nuber");

				} catch (NumberFormatException e) {
				label3.setText("INVALID INPUT!");
				}
			}
		});

		GridPane grid = new GridPane();
		grid.add(label1, 0, 0);
		grid.add(label2, 0, 1);
		grid.add(label3, 0, 2);
		grid.add(text, 1, 1);
		grid.add(butcheck, 0, 3);
		grid.add(menu, 0, 4);
		Scene DEP = new Scene(grid, 600, 400);

		return DEP;

	}

	public Scene inq() {
		trans.setValue(val);
		trans.inq();
		Label label1 = new Label("Your current amount : " + val);
		Button menu = new Button("Back to menu");
		menu.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			stage.setScene(menu());
				
			}
		});
		GridPane grid = new GridPane();
		grid.add(label1, 0, 0);
		grid.add(menu, 0, 4);
		Scene inq = new Scene(grid, 600, 400);
		return inq;
	}

}
