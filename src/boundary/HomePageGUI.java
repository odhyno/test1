package boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class HomePageGUI extends WindowManager {
	
	
	@FXML
	private Text hPWelcomeTXT;
	
	@FXML
	private Text hPTopicPostsTXT;
	
	@FXML
	private Text hPBandPostsTXT;
	
	@FXML
	private Text hPRankingsTXT;
    
    @FXML
	private Button socialMusicBTN;
    
    @FXML
	private ImageView hPPlayIMG;
    
    @FXML
	private ImageView hPStopIMG;
    
    @FXML
	private ImageView hPFFIMG;
    
    @FXML
	private ImageView hPProfileIMG;
    
    @FXML
	private ImageView hPMessagesIMG;
    
    @FXML
	private ImageView hPLogoutIMG;
    
    @FXML
   	private ImageView hPTopicIMG;
    
    @FXML
   	private ImageView hPBandIMG;
    
    @FXML
   	private ImageView hPNoteIMG;
    
    @FXML
   	private ImageView hPRankingsIMG;
    
    @FXML
	private Button hPMessagesBTN;
    
    @FXML
	private Button hPProfileBTN;
    
    @FXML
	private Button hPPogoutBTN;
    
    @FXML
	private Button samplePostBTN;
    
    @FXML
	private Button bandBTN;
    
    @FXML
	private Button topicPostsBTN;
    
    @FXML
	private Button rankingBTN;
    
    @FXML
	private Button doReportBTN;
    
    @FXML
	private Button manageReportsBTN;
    
    @FXML
	private Button rulesBTN;
    
    @FXML
	private Button manageRulesBTN;
    
    @FXML
	private Button manageUsersBTN;
    
    
   
    
    
	
	
	 @FXML
	 public void initialize()
	 {
		 hPWelcomeTXT.setText(" WELCOME " + getInstance().getLoggedUser().getUsername());
		 
		 if(( getInstance().getLoggedUser().getType()==1)){
			 doReportBTN.setVisible(false);
			 rulesBTN.setVisible(false);
			 
		 } else {
			 manageRulesBTN.setVisible(false);
			 manageReportsBTN.setVisible(false);
			 manageUsersBTN.setVisible(false);
			 
		 }
	     
	    
	     

	 }
	 
	 
	 
	 public void logout() {
		 
		 try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, "Social Music");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 public void samplePosts() 
	 {
		 
		 System.out.println("SAMPLE POSTS");

	 }
	 
	 public void bandPosts() 
	 {
		 
		 System.out.println("BAND POSTS");

	 }
	 
	 public void topicPosts() 
	 {
		 
		 System.out.println("TOPIC POSTS");

	 }
	 
	 public void messages() 
	 {
		 
		 System.out.println("MESSAGES");

	 }
	 
	 public void profile()
	 {
		 
		 System.out.println("PROFILE");

	 }
	 
	 public void ranking() 
	 {
		 
		 System.out.println("RANKING");

	 }
	 
	 public void showRules() 
	 {
		 
		 System.out.println("SHOW RULES");

	 }
	 
	 public void manageRules() 
	 {
		 
		 System.out.println("MANAGE RULES");

	 }
	 
	 public void manageReport() 
	 {
		 
		 System.out.println("MANAGE REPORT");

	 }
	 
	 public void doReport() 
	 {
		 
		 System.out.println("DO REPORT");

	 }
	 
	 public void manageUsers() 
	 {
		 
		 System.out.println("MANAGE USERS");

	 }
	 
 
	 @FXML
	 public void logoutClick() { logout(); }
	 
	 @FXML
	 public void samplePostsClick() { samplePosts(); }
	 
	 @FXML
	 public void bandPostsClick() { bandPosts(); }
	 
	 @FXML
	 public void topicPostsClick() { topicPosts(); }
	 
	 @FXML
	 public void messagesClick() { messages(); }
	 
	 @FXML
	 public void profileClick() { profile(); }
	 
	 @FXML
	 public void manageRulesClick() { manageRules(); }
	 
	 @FXML
	 public void showRulesClick() { showRules(); }
	 
	 @FXML
	 public void manageReportClick() { manageReport(); }
	 
	 @FXML
	 public void doReportClick() { doReport(); }
	 
	 @FXML
	 public void manageUsersClick() { manageUsers(); }
	 
	 @FXML
	 public void rankingClick() { ranking(); }

	 

}
