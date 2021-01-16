package logic.utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HomepageGUI {
	
	public static VBox getHomepageScene() {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();

		VBox root = new VBox();
		Text title = new Text();
		Text welcome = new Text();
		HBox hbox = new HBox();
		
		title.setText("Homepage");
		welcome.setText("Welcome " + win.getUser().getUsername() + "!!!");

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
		
		Button manageReportBTN = new Button("Manage Report");
		Button manageUsersBTN = new Button("Manage Users");
		Button manageRulesBTN = new Button("Manage Rules");

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
				
				win.setUser(null);
				win.loadLoginPage();
			}
		});

		samplePostBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadSamplePostPage();
			}
		});

		searchMemberBandBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadMemberBandPage();
			}
		});

		topicBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadTopicPage();
			}
		});

		rankingBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadRankingPage();
			}
		});

		doAReportBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadDoAReportPage();
			}
		});

		viewRulesBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadViewRulesPage();
			}
		});
		
		manageReportBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadHomePage();
				//win.loadManageReportPage();
			}
		});
		
		manageUsersBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadHomePage();
				//win.loadManageUsersPage();
			}
		});
		
		manageRulesBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadHomePage();
				//win.loadManageRulesPage();
			}
		});
		
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(homeBTN, messagesBTN, profileBTN, logoutBTN);
		root.setAlignment(Pos.CENTER);
				
		if(win.getUser().getFlag() == 0) {
			
			/*manageReportBTN.setVisible(false);
			manageUsersBTN.setVisible(false);
			manageRulesBTN.setVisible(false);*/
			root.getChildren().addAll(title, welcome, hbox, samplePostBTN, searchMemberBandBTN, topicBTN, rankingBTN,
					doAReportBTN, viewRulesBTN);
			
		} else {
			
		/*	doAReportBTN.setVisible(false);
			viewRulesBTN.setVisible(false);*/
			root.getChildren().addAll(title, welcome, hbox, samplePostBTN, searchMemberBandBTN, topicBTN, rankingBTN,
				 manageReportBTN, manageRulesBTN, manageUsersBTN);
		}

		return root;
	}
}
