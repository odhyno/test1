package boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class HomePageGUI extends WindowManager {
	
	
	@FXML
	private Text HPWelcomeTXT;
	
	@FXML
	private Text HPTopicPostsTXT;
	
	@FXML
	private Text HPBandPostsTXT;
	
	@FXML
	private Text HPRankingsTXT;
    
    @FXML
	private Button SocialMusicBTN;
    
    @FXML
	private ImageView HPPlayIMG;
    
    @FXML
	private ImageView HPStopIMG;
    
    @FXML
	private ImageView HPFFIMG;
    
    @FXML
	private ImageView HPProfileIMG;
    
    @FXML
	private ImageView HPMessagesIMG;
    
    @FXML
	private ImageView HPLogoutIMG;
    
    @FXML
   	private ImageView HPTopicIMG;
    
    @FXML
   	private ImageView HPBandIMG;
    
    @FXML
   	private ImageView HPNoteIMG;
    
    @FXML
   	private ImageView HPRankingsIMG;
    
    @FXML
	private Button MessagesBTN;
    
    @FXML
	private Button ProfileBTN;
    
    @FXML
	private Button LogoutBTN;
    
    @FXML
	private Button SamplePostBTN;
    
    @FXML
	private Button BandBTN;
    
    @FXML
	private Button TopicPostsBTN;
    
    @FXML
	private Button RankingBTN;
    
    @FXML
	private Button DoReportBTN;
    
    @FXML
	private Button ManageReportsBTN;
    
    @FXML
	private Button RulesBTN;
    
    @FXML
	private Button ManageRulesBTN;
    
    @FXML
	private Button ManageUsersBTN;
    
    
   
    
    
	
	
	 @FXML
	 public void initialize()
	 {
		 HPWelcomeTXT.setText(" WELCOME " + getInstance().getLoggedUser().getUsername());
		 
		 if(( getInstance().getLoggedUser().getType()==1)){
			 DoReportBTN.setVisible(false);
			 RulesBTN.setVisible(false);
			 
		 } else {
			 ManageRulesBTN.setVisible(false);
			 ManageReportsBTN.setVisible(false);
			 ManageUsersBTN.setVisible(false);
			 
		 }
	     
	    
	     

	 }
	 
	 
	 
	 public void logout() throws Exception {
		 
		 requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, "Social Music");

	 }
	 
	 public void samplePosts() throws Exception {
		 
		 System.out.println("SAMPLE POSTS");

	 }
	 
	 public void bandPosts() throws Exception {
		 
		 System.out.println("BAND POSTS");

	 }
	 
	 public void topicPosts() throws Exception {
		 
		 System.out.println("TOPIC POSTS");

	 }
	 
	 public void messages() throws Exception {
		 
		 System.out.println("MESSAGES");

	 }
	 
	 public void profile() throws Exception {
		 
		 System.out.println("PROFILE");

	 }
	 
	 public void ranking() throws Exception {
		 
		 System.out.println("RANKING");

	 }
	 
	 public void showRules() throws Exception {
		 
		 System.out.println("SHOW RULES");

	 }
	 
	 public void manageRules() throws Exception {
		 
		 System.out.println("MANAGE RULES");

	 }
	 
	 public void manageReport() throws Exception {
		 
		 System.out.println("MANAGE REPORT");

	 }
	 
	 public void doReport() throws Exception {
		 
		 System.out.println("DO REPORT");

	 }
	 
	 public void manageUsers() throws Exception {
		 
		 System.out.println("MANAGE USERS");

	 }
	 
 
	 @FXML
	 public void logoutClick() throws Exception { logout(); }
	 
	 @FXML
	 public void samplePostsClick() throws Exception { samplePosts(); }
	 
	 @FXML
	 public void bandPostsClick() throws Exception { bandPosts(); }
	 
	 @FXML
	 public void topicPostsClick() throws Exception { topicPosts(); }
	 
	 @FXML
	 public void messagesClick() throws Exception { messages(); }
	 
	 @FXML
	 public void profileClick() throws Exception { profile(); }
	 
	 @FXML
	 public void manageRulesClick() throws Exception { manageRules(); }
	 
	 @FXML
	 public void showRulesClick() throws Exception { showRules(); }
	 
	 @FXML
	 public void manageReportClick() throws Exception { manageReport(); }
	 
	 @FXML
	 public void doReportClick() throws Exception { doReport(); }
	 
	 @FXML
	 public void manageUsersClick() throws Exception { manageUsers(); }
	 
	 @FXML
	 public void rankingClick() throws Exception { ranking(); }

	 

}
