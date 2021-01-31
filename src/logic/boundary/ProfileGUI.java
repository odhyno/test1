package logic.boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import logic.bean.UserBean;
import logic.control.ControlProfile;
import logic.utility.WindowManager;

public class ProfileGUI extends WindowManager {
	
	@FXML
	private TextArea pPostsTA;
	
	@FXML
	private TextField pIDTA;
	
	@FXML
	private TextField pTitleTA;
	
	@FXML
	private TextField pDescriptionTA;
	
	@FXML
	private Text pSocialMusicTXT;
	
	@FXML
	private Text pProfileTXT;
	
	@FXML
	private Text pMessagesTXT;
	
	@FXML
	private Text pLogoutTXT;
	
	@FXML
	private Button pMessagesBTN;
	    
	@FXML
	private Button pProfileBTN;
	    
	@FXML
	private Button pLogoutBTN;
	
    @FXML
	private Button pSocialMusicBTN;
	
    @FXML
	private Button pBackBTN;
    
    @FXML
   	private ImageView pProfileIMG;
       
    @FXML
   	private ImageView pMessagesIMG;
       
    @FXML
   	private ImageView pLogoutIMG;
    
    @FXML
   	private ImageView pKeyIMG;
    
    @FXML
	private Button pModifyDataBTN;
    
    @FXML
	private Button pModifyProfileBTN;
    
    
    

	
	
	 @FXML
	 public void initialize()
	 {
		 
		 ControlProfile ctrlProfile = ControlProfile.getInstance();
		 UserBean user = ctrlProfile.getCurrentUserData(getInstance().getLoggedUser().getUsername());
		 pPostsTA.setText("YOUR PROFILE:\n\nUsername: " + user.getUsername() 
		 + "\nEmail: "+ user.getEmail() + "\nFirst name: " + user.getFirstname() 
		 + "\nLast name: " + user.getLastname() + "\nSubs Date: " + user.getSubsDate()
		 + "\nBirth Date: " + user.getBirthDate());
	
	 }
	 
	 
	 public void homePagePR() {
		 
		 try {
			requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 
	 public void logoutPR() {
		 
		 try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 public void messagesPR() 
	 {
		 
		 try {
				requestNewStage.setNewStage("SendMessageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 public void backPR()
	 {
		 
		 try {
				requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				e.printStackTrace();
			}

	 }
	 
	 public void modifyProfile() {
		 
		 try {
				requestNewStage.setNewStage("ModifyProfileGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
	}
	 
	 public void modifyData() {
		 
		 try {
				requestNewStage.setNewStage("ModifyDataGUI.fxml", 512, 512, socialMusic);
				 
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		 
	}

	 
	 @FXML
	 public void homePageClick() { homePagePR(); }
	 
	 @FXML
	 public void logoutClick() { logoutPR(); }
	 
	 @FXML
	 public void messagesClick() { messagesPR(); }
	 
	 @FXML
	 public void backClick()  { backPR(); }
	 
	 @FXML
	 public void modifyProfileClick()  { modifyProfile(); }
	 
	 @FXML
	 public void modifyDataClick()  { modifyData(); }

}
