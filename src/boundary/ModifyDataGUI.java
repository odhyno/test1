package boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import utility.NotValidEmailException;
import bean.UserBean;
import control.ControlProfile;

public class ModifyDataGUI extends WindowManager {
	
	@FXML
	private TextArea mDPostsTA;
	
	@FXML
	private TextField mDPasswordTA;
	
	@FXML
	private TextField mDEmailTA;
	
	@FXML
	private Text mDSocialMusicTXT;
	
	@FXML
	private Text mDProfileTXT;
	
	@FXML
	private Text mDMessagesTXT;
	
	@FXML
	private Text mDLogoutTXT;
	
	@FXML
	private Button mDMessagesBTN;
	    
	@FXML
	private Button mDProfileBTN;
	    
	@FXML
	private Button mDLogoutBTN;
	
    @FXML
	private Button mDSocialMusicBTN;
	
    @FXML
	private Button mDBackBTN;
    
    @FXML
   	private ImageView mDProfileIMG;
       
    @FXML
   	private ImageView mDMessagesIMG;
       
    @FXML
   	private ImageView mDLogoutIMG;
    
    @FXML
   	private ImageView mDKeyIMG;
    
    @FXML
	private Button mDModifyBTN;
    
    @FXML
	private Button mDRemoveBTN;
    
    @FXML
	private Button mDOkBTN;

	
	 @FXML
	 public void initialize()
	 {
		//we don't need to implement this one
	 }
	 
	 public void modifyUserDataAlert() {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(socialMusic);
			alert.setHeaderText("User Data Modified Successfully");
			alert.setContentText("Success! Your data has been modified!");

			alert.showAndWait();
		}

		public void sendEmailNotValidAlert() {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Modify Email Error");
			alert.setContentText("Error: Email format not valid. Retry!");

			alert.showAndWait();
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
	 
	 public void okDFun() {
				 
		 try {
			 
			 ControlProfile ctrlProfile = new ControlProfile();	 
			 UserBean user = ctrlProfile.getCurrentUserData(getInstance().getLoggedUser().getUsername());
			 
			 if(!mDPasswordTA.getText().trim().isEmpty()) {
					user.setPassword(mDPasswordTA.getText());
				}
				if(!mDEmailTA.getText().trim().isEmpty()) {
					user.setEmail(mDEmailTA.getText());
				}
				
				if (!ctrlProfile.checkIfEmailIsValid(mDEmailTA.getText())) {
	
					throw new NotValidEmailException();
	
				} else {
				
					int res = ctrlProfile.modifyCurrentUserData(user);
					
					if(res==1) {
						
						modifyUserDataAlert();
					}
				
				}	
					
				try {
					requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512, socialMusic);
					 
				} catch (Exception e) {
					
					e.printStackTrace();
				}
	
		 } catch (NotValidEmailException e) {
			 
		 } catch (Exception e1) {
			 e1.printStackTrace();
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
	 public void okPClick()  { okDFun(); } 

}
