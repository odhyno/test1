package logic.boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import logic.bean.UserBean;
import logic.control.ControlProfile;
import logic.exceptions.NotValidEmailException;

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
 
	 public void homePageMD() {
		 
		 try {
			requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 
	 public void logoutMD() {
		 
		 try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 public void messagesMD() 
	 {
		 
		 try {
				requestNewStage.setNewStage("SendMessageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 public void profileMD()
	 {
		 
		 try {
				requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512, socialMusic);
				 
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 public void backMD()
	 {
		 
		 try {
				requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				e.printStackTrace();
			}

	 }
	 
	 public void okDFun() {
		 
		 try {
		 
		 
			 ControlProfile ctrlProfile = ControlProfile.getInstance();
			 
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
					
				requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512, socialMusic);
					 
				
			
	 	} catch (NotValidEmailException e) {
	 		e.printStackTrace();
	 	} catch (Exception e1) {
	 		e1.printStackTrace();
	 	}
	
	}

	 @FXML
	 public void homePageClick() { homePageMD(); }
	 
	 @FXML
	 public void logoutClick() { logoutMD(); }
	 
	 @FXML
	 public void messagesClick() { messagesMD(); }
	 
	 @FXML
	 public void profileClick() { profileMD(); }
	 
	 @FXML
	 public void backClick()  { backMD(); }
	 
	 @FXML
	 public void okPClick()  { okDFun(); } 

}
