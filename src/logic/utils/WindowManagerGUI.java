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
import logic.interfaces.IUser;

public class WindowManagerGUI extends Application {
	
	private static WindowManagerGUI instance = null;
	
	private IUser user = null;

	private Scene LoginPage;
	private Scene RegisterPage;
	private Scene RecoverDataPage;
	private Scene HomePage;
	private Scene MessagesPage;
	private Scene ProfilePage;
	private Scene SamplePostPage;
	private Scene MemberBandPage;
	private Scene TopicPage;
	private Scene RankingPage;
	private Scene DoAReportPage;
	private Scene ViewRulesPage;
	private Scene InsertPostPage;
	private Scene FindPostPage;
	private Scene ManagePostPage;
	
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

	public void loadLoginPage() {
		VBox Login = LoginGUI.getLoginPageScene();
		LoginPage = new Scene(Login, 500, 500);
		WindowManagerGUI.myStage.setScene(LoginPage);
	}

	public void loadRegisterPage() {
		VBox Register = RegisterGUI.getRegisterPageScene();
		RegisterPage = new Scene(Register, 500, 500);
		WindowManagerGUI.myStage.setScene(RegisterPage);
	}

	public void loadRecoverDataPage() {
		VBox RecoverData = RecoverDataGUI.getRecoverDataPageScene();
		RecoverDataPage = new Scene(RecoverData, 500, 500);
		WindowManagerGUI.myStage.setScene(RecoverDataPage);
	}

	public void loadHomePage() {
		VBox Home = HomepageGUI.getHomepageScene();
		HomePage = new Scene(Home, 500, 500);
		WindowManagerGUI.myStage.setScene(HomePage);
	}

	public void loadMessagesPage() {
		VBox Messages = SendMessagesGUI.getMessagesScene();
		MessagesPage = new Scene(Messages, 500, 500);
		WindowManagerGUI.myStage.setScene(MessagesPage);
	}

	public void loadProfilePage() {
		// VBox Profile = ProfileGUI.getProfileScene();
		/* ProfilePage = new Scene(Profile,500,500); */
		WindowManagerGUI.myStage.setScene(ProfilePage);
	}

	public void loadSamplePostPage() {
		VBox SamplePost = SamplePostGUI.getSamplePostScene();
		SamplePostPage = new Scene(SamplePost, 500, 500);
		WindowManagerGUI.myStage.setScene(SamplePostPage);
	}

	public void loadMemberBandPage() {
		// VBox MemberBand = MemberBandRequestGUI.getMemberBandScene();
		/* MemberBandPage = new Scene(MemberBand,500,500); */
		WindowManagerGUI.myStage.setScene(MemberBandPage);
	}

	public void loadTopicPage() {
		VBox Topic = TopicGUI.getTopicScene();
		TopicPage = new Scene(Topic, 500, 500);
		WindowManagerGUI.myStage.setScene(TopicPage);
	}

	public void loadRankingPage() {
		VBox Ranking = RankingGUI.getRankingScene();
		RankingPage = new Scene(Ranking, 500, 500);
		WindowManagerGUI.myStage.setScene(RankingPage);
	}

	public void loadDoAReportPage() {
		// VBox DoAReport = DoAReportGUI.getDoAReportScene();
		// DoAReportPage = new Scene(DoAReport,500,500);
		WindowManagerGUI.myStage.setScene(DoAReportPage);
	}

	public void loadViewRulesPage() {
		VBox ViewRules = ViewRulesGUI.getViewRulesScene();
		ViewRulesPage = new Scene(ViewRules, 500, 500);
		WindowManagerGUI.myStage.setScene(ViewRulesPage);
	}

	public void loadInsertPostPage() {

		VBox InsertPost = InsertPostGUI.getInsertPostScene();
		InsertPostPage = new Scene(InsertPost, 500, 500);
		WindowManagerGUI.myStage.setScene(InsertPostPage);

	}
	
	public void loadFindPostPage() {

		VBox FindPost = FindPostGUI.getFindPostScene();
		FindPostPage = new Scene(FindPost, 500, 500);
		WindowManagerGUI.myStage.setScene(FindPostPage);

	}
	
	public void loadManagePostPage() {
		VBox ManagePost = ManagePostGUI.getManagePostScene();
		ManagePostPage = new Scene(ManagePost, 500, 500);
		WindowManagerGUI.myStage.setScene(ManagePostPage);		
	} 
	
	public IUser getUser() {
		return user;
	}

	public void setUser(IUser user) {
		this.user = user;
	}
	
	public static WindowManagerGUI getWindowManagerGUIInstance() {
		if (WindowManagerGUI.instance == null)
			WindowManagerGUI.instance = new WindowManagerGUI();
		return instance;
	}

	

}