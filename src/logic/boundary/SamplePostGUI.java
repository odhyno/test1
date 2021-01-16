package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.utils.WindowManagerGUI;

public class SamplePostGUI {

	public static VBox getSamplePostScene() {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();

		VBox root = new VBox();
		HBox box = new HBox();
		
		Text title = new Text();
		
		title.setText("Sample Post GUI");
		
		Button homeBTN = new Button("Social Music");
		Button messagesBTN = new Button("Messages");
		Button profileBTN = new Button("Profile");
		Button logoutBTN = new Button("Logout");
		Button backBTN = new Button("Back");
		Button newPostBTN = new Button("New Post");
		Button findPostBTN = new Button("Search Post");
		Button manageMyPostBTN = new Button("Manage My Posts");

		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadHomePage();
			}
		});

		newPostBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadInsertPostPage();

			}
		});
		
		manageMyPostBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadManagePostPage();

			}
		});
		
		findPostBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadFindPostPage();

			}
		});

		homeBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadHomePage();
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

		box.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		box.getChildren().addAll(homeBTN, messagesBTN, profileBTN, logoutBTN);
		root.getChildren().addAll(title, box, newPostBTN, manageMyPostBTN, findPostBTN, backBTN);

		return root;
	}

}
