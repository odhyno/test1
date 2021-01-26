package boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import bean.UserBean;
import control.ControlProfile;

public class ModifyDataGUI extends WindowManager {
	
	private static String socialMusic = "Social Music";
	
	int i;
	
	static int cmd = -1;
	
	@FXML
	private TextArea mRSPPostsTA;
	
	@FXML
	private TextField mPPasswordTA;
	
	@FXML
	private TextField mPEmailTA;
	
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
	private Button mRSPModifyBTN;
    
    @FXML
	private Button mRSPRemoveBTN;
    
    @FXML
	private Button mRSPOkBTN;

	
	 @FXML
	 public void initialize()
	 {
		
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
		 
		 System.out.println("MESSAGES");

	 }
	 
	 public void profile()
	 {
		 
		 try {
				requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512, "Social Music");
				 
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
	 
	 public void okDFun() {
		 
		 ControlProfile ctrlProfile = new ControlProfile();
		 
		 UserBean user = ctrlProfile.getCurrentUserData();
		 
		 if(!mPPasswordTA.getText().trim().isEmpty()) {
				user.setPassword(mPPasswordTA.getText());
			}
			if(!mPEmailTA.getText().trim().isEmpty()) {
				user.setEmail(mPEmailTA.getText());
			}
			
			if (!ctrlProfile.checkIfEmailIsValid(mPEmailTA.getText())) {

				sendEmailNotValidAlert();

			} else {
			
				int res = ctrlProfile.modifyCurrentUserData(user);
				
				if(res==1) {
					
					modifyUserDataAlert();
				}
			
			}	
				
			try {
				requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512, "Social Music");
				 
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			

		
	}
	 
	 
	 public static void modifyUserDataAlert() {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Social Music");
			alert.setHeaderText("User Data Modified Successfully");
			alert.setContentText("Success! Your data has been modified!");

			alert.showAndWait();
		}

		public static void sendEmailNotValidAlert() {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Social Music");
			alert.setHeaderText("Modify Email Error");
			alert.setContentText("Error: Email format not valid. Retry!");

			alert.showAndWait();
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
	 public void okPClick()  { okDFun(); }
	 
	 
	 

}
