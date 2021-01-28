package boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import bean.UserBean;
import control.ControlProfile;

public class ProfileGUI extends WindowManager {
	
	@FXML
	private TextArea mRSPPostsTA;
	
	@FXML
	private TextField mRSPIDTA;
	
	@FXML
	private TextField mRSPTitleTA;
	
	@FXML
	private TextField mRSPDescriptionTA;
	
	@FXML
	private Text mRSPSocialMusicTXT;
	
	@FXML
	private Text mRSPProfileTXT;
	
	@FXML
	private Text mRSPMessagesTXT;
	
	@FXML
	private Text mRSPLogoutTXT;
	
	@FXML
	private Button mRSPMessagesBTN;
	    
	@FXML
	private Button mRSPProfileBTN;
	    
	@FXML
	private Button mRSPLogoutBTN;
	
    @FXML
	private Button mRSPSocialMusicBTN;
	
    @FXML
	private Button mRSPBackBTN;
    
    @FXML
   	private ImageView mRSPProfileIMG;
       
    @FXML
   	private ImageView mRSPMessagesIMG;
       
    @FXML
   	private ImageView mRSPLogoutIMG;
    
    @FXML
   	private ImageView mRSPKeyIMG;
    
    @FXML
	private Button pModifyDataBTN;
    
    @FXML
	private Button pModifyProfileBTN;
    
    
    

	
	
	 @FXML
	 public void initialize()
	 {
		 
		 ControlProfile ctrlProfile = new ControlProfile();
		 UserBean user = ctrlProfile.getCurrentUserData(getInstance().getLoggedUser().getUsername());
		 mRSPPostsTA.setText("YOUR PROFILE:\n\nUsername: " + user.getUsername() 
		 + "\nEmail: "+ user.getEmail() + "\nFirst name: " + user.getFirstname() 
		 + "\nLast name: " + user.getLastname() + "\nSubs Date: " + user.getSubsDate()
		 + "\nBirth Date: " + user.getBirthDate());
	
	 }
	 
	 
	 public void homePage() {
		 
		 try {
			requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 
	 public void logout() {
		 
		 try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 public void messages() 
	 {
		 
		 try {
				requestNewStage.setNewStage("SendMessageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 public void back()
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
	 public void homePageClick() { homePage(); }
	 
	 @FXML
	 public void logoutClick() { logout(); }
	 
	 @FXML
	 public void messagesClick() { messages(); }
	 
	 @FXML
	 public void backClick()  { back(); }
	 
	 @FXML
	 public void modifyProfileClick()  { modifyProfile(); }
	 
	 @FXML
	 public void modifyDataClick()  { modifyData(); }

}
