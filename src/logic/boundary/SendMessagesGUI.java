package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.utils.WindowManagerGUI;

public class SendMessagesGUI {

	public static VBox getMessagesScene() {
		VBox root = new VBox();
		Text title = new Text();
		title.setText("messaggi");

		Button sendMessageBTN = new Button("Send message");
		Button homePageBTN = new Button("Home");
		Button logoutBTN = new Button("Logout");
		Button profileBTN = new Button("Profile");
		Button backBTN = new Button("Back");

		sendMessageBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				// TODO Not implemented yet.

			}
		});

		homePageBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadHomePage();

			}
		});

		logoutBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadLoginPage();
			}
		});

		profileBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadProfilePage();

			}

		});

		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadHomePage();

			}

		});

		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title, sendMessageBTN, homePageBTN, logoutBTN, backBTN);

		return root;

	}

}
