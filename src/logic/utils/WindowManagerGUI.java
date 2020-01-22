package logic.utils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.boundary.LoginGUI;
import logic.boundary.RecoverDataGUI;
import logic.boundary.RegisterGUI;
import logic.boundary.SamplePostGUI;
import logic.boundary.SendMessagesGUI;
import logic.boundary.TopicGUI;

public class WindowManagerGUI extends Application {

	private static Scene LoginPage;
	private static Scene RegisterPage;
	private static Scene RecoverDataPage;
	private static Scene HomePage;
	private static Scene MessagesPage;
	private static Scene ProfilePage;
	private static Scene SamplePostPage;
	private static Scene MemberBandPage;
	private static Scene TopicPage;
	private static Scene RankingPage;
	private static Scene DoAReportPage;
	private static Scene ViewRulesPage;
	private static Scene InsertPostPage;
	private static Stage myStage;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage myStage) {
		WindowManagerGUI.myStage = myStage;
		myStage.setTitle("Program Window");

		loadLoginPage();
		myStage.show();
	}

	public static void loadLoginPage() {
		VBox Login = LoginGUI.getLoginPageScene();
		if (LoginPage == null) {
			LoginPage = new Scene(Login, 500, 500);
		}

		WindowManagerGUI.myStage.setScene(LoginPage);
	}

	public static void loadRegisterPage() {
		VBox Register = RegisterGUI.getRegisterPageScene();
		if (RegisterPage == null) {
			RegisterPage = new Scene(Register, 500, 500);
		}
		WindowManagerGUI.myStage.setScene(RegisterPage);
	}

	public static void loadRecoverDataPage() {
		VBox RecoverData = RecoverDataGUI.getRecoverDataPageScene();
		if (RecoverDataPage == null) {
			RecoverDataPage = new Scene(RecoverData, 500, 500);
		}
		WindowManagerGUI.myStage.setScene(RecoverDataPage);
	}

	public static void loadHomePage() {
		VBox Home = HomepageGUI.getHomepageScene();
		if (HomePage == null) {
			HomePage = new Scene(Home, 500, 500);
		}
		WindowManagerGUI.myStage.setScene(HomePage);
	}

	public static void loadMessagesPage() {
		VBox Messages = SendMessagesGUI.getMessagesScene();
		if (MessagesPage == null) {
			MessagesPage = new Scene(Messages, 500, 500);
		}
		WindowManagerGUI.myStage.setScene(MessagesPage);
	}

	public static void loadProfilePage() {
		// VBox Profile = ProfileGUI.getProfileScene();
		if (ProfilePage == null) {
			/* ProfilePage = new Scene(Profile,500,500); */
		}
		WindowManagerGUI.myStage.setScene(ProfilePage);
	}

	public static void loadSamplePostPage() {
		VBox SamplePost = SamplePostGUI.getSamplePostScene();
		if (SamplePostPage == null) {
			SamplePostPage = new Scene(SamplePost, 500, 500);
		}
		WindowManagerGUI.myStage.setScene(SamplePostPage);
	}

	public static void loadMemberBandPage() {
		// VBox MemberBand = MemberBandRequestGUI.getMemberBandScene();
		if (MemberBandPage == null) {
			/* MemberBandPage = new Scene(MemberBand,500,500); */
		}
		WindowManagerGUI.myStage.setScene(MemberBandPage);
	}

	public static void loadTopicPage() {
		VBox Topic = TopicGUI.getTopicScene();
		if (TopicPage == null) {
			TopicPage = new Scene(Topic, 500, 500);
		}
		WindowManagerGUI.myStage.setScene(TopicPage);
	}

	public static void loadRankingPage() {
		VBox Ranking = RankingGUI.getRankingScene();
		if (RankingPage == null) {
			RankingPage = new Scene(Ranking, 500, 500);
		}
		WindowManagerGUI.myStage.setScene(RankingPage);
	}

	public static void loadDoAReportPage() {
		// VBox DoAReport = DoAReportGUI.getDoAReportScene();
		if (DoAReportPage == null) {
			// DoAReportPage = new Scene(DoAReport,500,500);
		}
		WindowManagerGUI.myStage.setScene(DoAReportPage);
	}

	public static void loadViewRulesPage() {
		VBox ViewRules = ViewRulesGUI.getViewRulesScene();
		if (ViewRulesPage == null) {
			ViewRulesPage = new Scene(ViewRules, 500, 500);
		}
		WindowManagerGUI.myStage.setScene(ViewRulesPage);
	}

	public static void setUserInHomePage(String username, String password) {

		HomepageUtils.setUser(username, password);

	}

	public static void loadInsertPostPage() {

		VBox InsertPost = InsertPostGUI.getInsertPostScene();
		if (InsertPostPage == null) {
			InsertPostPage = new Scene(InsertPost, 500, 500);
		}
		WindowManagerGUI.myStage.setScene(InsertPostPage);

	}

}