package logic.utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.actors.User;

public class HomepageGUI {

	public static VBox getHomepageScene() {

		VBox root = new VBox();
		Text title = new Text();
		Text welcome = new Text();
		HBox hbox = new HBox();

		final User user = HomepageUtils.getUser();

		title.setText("Homepage");
		welcome.setText("Welcome " + user.getUsername() + "!!!");

		Button homeBTN = new Button("Social Music");
		Button messagesBTN = new Button("Messages");
		Button profileBTN = new Button("Profile");
		Button logoutBTN = new Button("Logout");
		Button samplePostBTN = new Button("Sample Posts");
		Button searchMemberBandBTN = new Button("Search Member / Search Band");
		Button topicBTN = new Button("Topics");
		Button rankingBTN = new Button("Ranking");
		Button doAReportBTN = new Button("Do a Report");
		Button viewRulesBTN = new Button("View Rules");

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

		samplePostBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadSamplePostPage();
			}
		});

		searchMemberBandBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadMemberBandPage();
			}
		});

		topicBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadTopicPage();
			}
		});

		rankingBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadRankingPage();
			}
		});

		doAReportBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadDoAReportPage();
			}
		});

		viewRulesBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadViewRulesPage();
			}
		});

		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(homeBTN, messagesBTN, profileBTN, logoutBTN);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title, welcome, hbox, samplePostBTN, searchMemberBandBTN, topicBTN, rankingBTN,
				doAReportBTN, viewRulesBTN);

		return root;
	}
}
