package logic.utils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.actors.User;
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
    private static Stage myStage;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage myStage) {
        WindowManagerGUI.myStage = myStage;
        myStage.setTitle("Program Window");
        User user = new User();
        VBox Login = LoginGUI.getLoginPageScene();
        VBox Register = RegisterGUI.getRegisterPageScene();
        VBox RecoverData = RecoverDataGUI.getRecoverDataPageScene();
        VBox Home = HomepageGUI.getHomepageScene(user);
        VBox Messages = SendMessagesGUI.getMessagesScene();
        //VBox Profile = ProfileGUI.getProfileScene();
        VBox SamplePost = SamplePostGUI.getSamplePostScene();
        //VBox MemberBand = MemberBandRequestGUI.getMemberBandScene();
        VBox Topic = TopicGUI.getTopicScene();
        VBox Ranking = RankingGUI.getRankingScene();
        //VBox DoAReport = DoAReportGUI.getDoAReportScene();
        VBox ViewRules = ViewRulesGUI.getViewRulesScene();

        LoginPage = new Scene(Login, 500, 500);
        RegisterPage = new Scene(Register, 500, 500);
        RecoverDataPage = new Scene(RecoverData,500,500);
        HomePage = new Scene(Home,500,500);
        MessagesPage = new Scene(Messages,500,500);
        /*ProfilePage = new Scene(Profile,500,500);*/
        SamplePostPage = new Scene(SamplePost,500,500);
        /*MemberBandPage = new Scene(MemberBand,500,500);*/
        TopicPage = new Scene(Topic,500,500);
        RankingPage = new Scene(Ranking,500,500);
        //DoAReportPage = new Scene(DoAReport,500,500);
        ViewRulesPage = new Scene(ViewRules,500,500);

        loadLoginPage();
        myStage.show();
    }

    public static void loadLoginPage() {
        WindowManagerGUI.myStage.setScene(LoginPage);
    }

    public static void loadRegisterPage() {
        WindowManagerGUI.myStage.setScene(RegisterPage);
    }
    
    public static void loadRecoverDataPage() {
    	WindowManagerGUI.myStage.setScene(RecoverDataPage);
    }
    
	public static void loadHomePage(User user) {
		WindowManagerGUI.myStage.setScene(HomePage);
	}
	
	public static void loadMessagesPage() {
		WindowManagerGUI.myStage.setScene(MessagesPage);
	}
	
	public static void loadProfilePage() {
		WindowManagerGUI.myStage.setScene(ProfilePage);
	}
	
	public static void loadSamplePostPage() {
		WindowManagerGUI.myStage.setScene(SamplePostPage);
	}
	
	public static void loadMemberBandPage() {
		WindowManagerGUI.myStage.setScene(MemberBandPage);
	}
	
	public static void loadTopicPage() {
		WindowManagerGUI.myStage.setScene(TopicPage);
	}
	
	public static void loadRankingPage() {
		WindowManagerGUI.myStage.setScene(RankingPage);
	}
	
	public static void loadDoAReportPage() {
		WindowManagerGUI.myStage.setScene(DoAReportPage);
	}
	
	public static void loadViewRulesPage() {
		WindowManagerGUI.myStage.setScene(ViewRulesPage);
	}
	
}