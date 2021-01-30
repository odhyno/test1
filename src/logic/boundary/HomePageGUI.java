package logic.boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class HomePageGUI extends WindowManager {
	
	
	@FXML
	private Text hPWelcomeTXT;
	
	@FXML
	private Text socialMusicTXT;
	
	@FXML
	private Text hPProfileTXT;
	
	@FXML
	private Text hPMessagesTXT;
	
	@FXML
	private Text hPLogoutTXT;
	
	@FXML
	private Text hPTopicPostsTXT;
	
	@FXML
	private Text hPSamplePostsTXT;
	
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
	private Button hPLogoutBTN;
    
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
	 
	 public void genericAlert() {
		 Alert alert = new Alert(AlertType.ERROR);
		 alert.setTitle(socialMusic);
		 alert.setHeaderText("unimplemented method Error");
		 alert.setContentText("Error: Not implemented yet!");

		 alert.showAndWait();
	 	
	  }
	 
	 
	 
	 public void logout() {
		 
		 try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	
	 
	 public void changeScene() {
		 
		 try {
			 	requestNewStage.setNewStage("PostsGUI.fxml", 512, 512,socialMusic);
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	}
	 
	 public void samplePosts() 
	 {
	 
		WindowManager.type= 1;
		changeScene();
				
	 }



	public void bandPosts() 
	 {
		
		WindowManager.type= 2;
		 changeScene();

	 }
	 
	 public void topicPosts() 
	 {
		WindowManager.type= 3;
		changeScene();
	 }
	 
	 public void messages() 
	 {
		 
		 try {
				requestNewStage.setNewStage("SendMessageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 public void profile()
	 {
		 
		 try {
				requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512, socialMusic);
				 
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 public void ranking() 
	 {
		 
		 genericAlert();

	 }
	 
	 public void showRules() 
	 {
		 
		 genericAlert();

	 }
	 
	 public void manageRules() 
	 {
		 
		 genericAlert();

	 }
	 
	 public void manageReport() 
	 {
		 
		 genericAlert();

	 }
	 
	 public void doReport() 
	 {
		 
		 genericAlert();
	 }
	 
	 public void manageUsers() 
	 {
		 
		 genericAlert();

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
