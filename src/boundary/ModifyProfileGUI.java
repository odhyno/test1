package boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import bean.UserBean;
import control.ControlProfile;

public class ModifyProfileGUI extends WindowManager {
	
	@FXML
	private TextArea mPPostsTA;
	
	@FXML
	private TextField mPFirstTA;
	
	@FXML
	private TextField mPLastTA;
	
	@FXML
	private DatePicker mPDateFLD;
	
	@FXML
	private Text mPSocialMusicTXT;
	
	@FXML
	private Text mPProfileTXT;
	
	@FXML
	private Text mPMessagesTXT;
	
	@FXML
	private Text mPLogoutTXT;
	
	@FXML
	private Button mPMessagesBTN;
	    
	@FXML
	private Button mPProfileBTN;
	    
	@FXML
	private Button mPLogoutBTN;
	
    @FXML
	private Button mPSocialMusicBTN;
	
    @FXML
	private Button mPBackBTN;
    
    @FXML
   	private ImageView mPProfileIMG;
       
    @FXML
   	private ImageView mPMessagesIMG;
       
    @FXML
   	private ImageView mPLogoutIMG;
    
    @FXML
   	private ImageView mPKeyIMG;
    
    @FXML
	private Button mPModifyBTN;
    
    @FXML
	private Button mPRemoveBTN;
    
    @FXML
	private Button mPOkBTN;
	
	
	 @FXML
	 public void initialize()
	 {
		//we don't need to implement this one
	 }
	 
	 
	 public void homePage() {
		 
		 try {
			requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512,socialMusic);
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
	 
	 public void profile()
	 {
		 
		 try {
				requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512, socialMusic);
				 
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
	 
	 public void okPFun() {
		 
		 ControlProfile ctrlProfile = new ControlProfile();
		 
		 UserBean user = ctrlProfile.getCurrentUserData(getInstance().getLoggedUser().getUsername());
		 
		 if(!mPFirstTA.getText().trim().isEmpty()) {
				user.setFirstname(mPFirstTA.getText());
			}
			if(!mPLastTA.getText().trim().isEmpty()) {
				user.setLastname(mPLastTA.getText());
			}
			if(mPDateFLD.getValue() != null) {
				user.setBirthDate(mPDateFLD.getValue().toString());
				
			}
			
			ctrlProfile.modifyCurrentUserProfile(user);
			
			try {
				requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512, socialMusic);
				 
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
	 public void profileClick() { profile(); }
	 
	 @FXML
	 public void backClick()  { back(); }
	 
	 @FXML
	 public void okPClick()  { okPFun(); }
	 
	 
	 

}
