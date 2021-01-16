package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.utils.WindowManagerGUI;

public class ProfileGUI {

	public ProfileGUI() {

	}

	public static VBox getProfileScene() {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();

		VBox root = new VBox();
		HBox hbox = new HBox();
		Text title = new Text();

		title.setText("My Profile");

		Button homeBTN = new Button("Social Music");
		Button messagesBTN = new Button("Messages");
		Button profileBTN = new Button("Profile");
		Button logoutBTN = new Button("Logout");
		Button modifyDataBTN = new Button("Modify Data");
		Button modifyProfileBTN = new Button("Modify Profile");
		Button backBTN = new Button("Back");

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

		modifyDataBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

			}
		});

		hbox.getChildren().addAll(homeBTN, messagesBTN, profileBTN, logoutBTN);
		root.getChildren().addAll(title, hbox, modifyProfileBTN, modifyDataBTN, backBTN);

		return root;
	}

}
