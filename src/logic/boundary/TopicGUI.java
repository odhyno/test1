package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.utils.WindowManagerGUI;

public class TopicGUI {

	public static VBox getTopicScene() {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();

		Text title = new Text("Topics");
		VBox root = new VBox();

		Button homeBTN = new Button("Social Music");
		Button messagesBTN = new Button("Messages");
		Button profileBTN = new Button("Profile");
		Button logoutBTN = new Button("Logout");
		Button backBTN = new Button("Back");
		Button filterByBTN = new Button("Filter By");
		Button myTopicsBTN = new Button("My Topics");
		Button newTopicBTN = new Button("New Topic");

		homeBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				//win.loadHomePage();
			}
		});

		messagesBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadMessagesPage();
			}
		});

		profileBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadProfilePage();
			}
		});

		logoutBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadLoginPage();
			}
		});

		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				//win.loadHomePage();
			}

		});

		filterByBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				// TODO Not implemented yet.
			}
		});

		myTopicsBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				// TODO Not implemented yet.
			}
		});

		newTopicBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				// TODO Not implemented yet.
			}
		});

		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title, homeBTN, messagesBTN, profileBTN, logoutBTN, backBTN, filterByBTN, myTopicsBTN,
				newTopicBTN);

		return root;
	}

}
