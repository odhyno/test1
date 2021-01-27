package boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import bean.PostBean;
import control.ControlRequestPost;

public class NewRequestPostGUI extends WindowManager {
	

	@FXML
	private Text nRPSocialMusicTXT;
	
	@FXML
	private Text nRPProfileTXT;
	
	@FXML
	private Text nRPMessagesTXT;
	
	@FXML
	private Text nRPLogoutTXT;
	
	@FXML
	private Button nRPMessagesBTN;
	    
	@FXML
	private Button nRPProfileBTN;
	    
	@FXML
	private Button nRPLogoutBTN;
	
    @FXML
	private Button nRPSocialMusicBTN;
	
    @FXML
	private Button nRPBackBTN;
    
    @FXML
	private Button nRPInsertBTN;
    
    @FXML
   	private ImageView nRPProfileIMG;
       
    @FXML
   	private ImageView nRPMessagesIMG;
       
    @FXML
   	private ImageView nRPLogoutIMG;
    
    @FXML
   	private ImageView nRPKeyIMG;
    
    @FXML
   	private TextField nRPTitleTA;
    
    @FXML
   	private TextField nRPDescriptionTA;
    
    
	
	
	 @FXML
	 public void initialize()
	 {
		 //we don't need to implement this one
	 }
	 
	 public void insertRequestPostAlert() {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Insert Post Success");
			alert.setContentText("Success! Your Post has been inserted!");

			alert.showAndWait();
		}
		
		public void insertRequestPostErrorAlert() {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Remove Post Error");
			alert.setContentText("Error: You can't insert post with empty fields. Retry!");

			alert.showAndWait();
		}
	 
	 
	 public void homePageNRP() {
		 
		 try {
			requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 
	 public void logoutNRP() {
		 
		 try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 public void messagesNRP() 
	 {
		 
		 try {
				requestNewStage.setNewStage("SendMessageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				
				e.printStackTrace();
			}


	 }
	 
	 public void profileNRP()
	 {
		 
		 try {
				requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512,socialMusic);
				 
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 
	 public void insertRequest() {
		 
		 	PostBean post = new PostBean();
		 	
		 	ControlRequestPost ctrlRequestPost = new ControlRequestPost();
			
			post.setAutore(getInstance().getLoggedUser().getUsername());
			post.setTitolo(nRPTitleTA.getText());
			post.setDescrizione(nRPDescriptionTA.getText());
			
			int res = ctrlRequestPost.insertRequestPost(post);
			if(res==-1) {
				insertRequestPostErrorAlert();
			}else {
				insertRequestPostAlert();
			}
			
			nRPTitleTA.clear();
			nRPDescriptionTA.clear();

			try {
				requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }
	 
	 
	 
	 public void backNRP()
	 {
		 
		 try {
				requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				e.printStackTrace();
			}

	 }
	 
	 
	 
	 @FXML
	 public void homePageClick() { homePageNRP(); }
	 
	 @FXML
	 public void logoutClick() { logoutNRP(); }
	 
	 @FXML
	 public void messagesClick() { messagesNRP(); }
	 
	 @FXML
	 public void profileClick() { profileNRP(); }
	 
	 @FXML
	 public void backClick()  { backNRP(); }
	 
	 @FXML
	 public void insertRequestClick()  { insertRequest(); }
	 
	
	 

}
