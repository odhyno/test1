package boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import bean.PostBean;
import control.ControlTopicPost;

public class NewTopicPostGUI extends WindowManager {
	
	
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
	private Button nRPInsertBTN;
    
    @FXML
   	private ImageView mRSPProfileIMG;
       
    @FXML
   	private ImageView mRSPMessagesIMG;
       
    @FXML
   	private ImageView mRSPLogoutIMG;
    
    @FXML
   	private ImageView mRSPKeyIMG;
    
    @FXML
   	private TextField nRPTitleTA;
    
    @FXML
   	private TextField nTPTopicTA;
    
    @FXML
   	private TextField nRPDescriptionTA;
    
	
	 @FXML
	 public void initialize()
	 {
		 //we don't need to implement this one
	 }
	 
	 public void insertTopicPostAlert() {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Social Music");
			alert.setHeaderText("Insert Post Success");
			alert.setContentText("Success! Your Post has been inserted!");

			alert.showAndWait();
		}
		
		public void insertTopicPostErrorAlert() {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Social Music");
			alert.setHeaderText("Remove Post Error");
			alert.setContentText("Error: You can't insert post with empty fields. Retry!");

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
	 
	 
	 public void insertTopic() {
		 
		 	PostBean post = new PostBean();
		 
		 	ControlTopicPost ctrlTopicPost = new ControlTopicPost();
			
			post.setAutore(getInstance().getLoggedUser().getUsername());
			post.setTitolo(nRPTitleTA.getText());
			post.setArgomento(nTPTopicTA.getText());
			post.setDescrizione(nRPDescriptionTA.getText());
			
			int res= ctrlTopicPost.insertTopicPost(post);
			if(res==-1) {
				insertTopicPostErrorAlert();
			}else {
				insertTopicPostAlert();
			}
			
			nRPTitleTA.clear();
			nRPDescriptionTA.clear();
			nTPTopicTA.clear();
		
			try {
				requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, socialMusic);
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
	 public void insertTopicClick()  { insertTopic(); }
	 
	
	 

}
