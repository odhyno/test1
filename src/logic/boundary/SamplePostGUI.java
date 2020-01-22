package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import logic.utils.HomepageUtils;
import logic.utils.WindowManagerGUI;

public class SamplePostGUI {

	public static VBox getSamplePostScene() {

		VBox root = new VBox();
		HBox box = new HBox();
		Button homeBTN = new Button("Social Music");
		Button messagesBTN = new Button("Messages");
		Button profileBTN = new Button("Profile");
		Button logoutBTN = new Button("Logout");
		Button BackBTN = new Button("Back");
		Button NewPostBTN = new Button("New Post");

		BackBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadHomePage();
			}
		});

		NewPostBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadInsertPostPage();

			}
		});

		homeBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadHomePage();
			}
		});

		messagesBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadMessagesPage();
			}
		});

		profileBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadProfilePage();
			}
		});

		logoutBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				HomepageUtils.setLog();
				WindowManagerGUI.loadLoginPage();
			}
		});

		box.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		box.getChildren().addAll(homeBTN, messagesBTN, profileBTN, logoutBTN);
		root.getChildren().addAll(box, NewPostBTN, BackBTN);

		return root;
	}

}
