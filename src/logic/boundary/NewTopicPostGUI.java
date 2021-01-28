package logic.boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import logic.bean.PostBean;
import logic.control.ControlTopicPost;

public class NewTopicPostGUI extends WindowManager {
	
	
	@FXML
	private Text nTPSocialMusicTXT;
	
	@FXML
	private Text nTPProfileTXT;
	
	@FXML
	private Text nTPMessagesTXT;
	
	@FXML
	private Text nTPLogoutTXT;
	
	@FXML
	private Button nTPMessagesBTN;
	    
	@FXML
	private Button nTPProfileBTN;
	    
	@FXML
	private Button nTPLogoutBTN;
	
    @FXML
	private Button nTPSocialMusicBTN;
	
    @FXML
	private Button nTPBackBTN;
    
    @FXML
	private Button nTPInsertBTN;
    
    @FXML
   	private ImageView nTPProfileIMG;
       
    @FXML
   	private ImageView nTPMessagesIMG;
       
    @FXML
   	private ImageView nTPLogoutIMG;
    
    @FXML
   	private ImageView nTPKeyIMG;
    
    @FXML
   	private TextField nTPTitleTA;
    
    @FXML
   	private TextField nTPTopicTA;
    
    @FXML
   	private TextField nTPDescriptionTA;
    
	
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
	 
	 
	 public void homePageNTP() {
		 
		 try {
			requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 
	 public void logoutNTP() {
		 
		 try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 public void messagesNTP() 
	 {
		 
		 try {
				requestNewStage.setNewStage("SendMessageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				
				e.printStackTrace();
			}


	 }
	 
	 public void profileNTP()
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
			post.setTitolo(nTPTitleTA.getText());
			post.setArgomento(nTPTopicTA.getText());
			post.setDescrizione(nTPDescriptionTA.getText());
			
			int res= ctrlTopicPost.insertTopicPost(post);
			if(res==-1) {
				insertTopicPostErrorAlert();
			}else {
				insertTopicPostAlert();
			}
			
			nTPTitleTA.clear();
			nTPDescriptionTA.clear();
			nTPTopicTA.clear();
		
			try {
				requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }
	 
	 
	 
	 public void backNTP()
	 {
		 
		 try {
				requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				e.printStackTrace();
			}

	 }
	 
	 
	 
	 @FXML
	 public void homePageClick() { homePageNTP(); }
	 
	 @FXML
	 public void logoutClick() { logoutNTP(); }
	 
	 @FXML
	 public void messagesClick() { messagesNTP(); }
	 
	 @FXML
	 public void profileClick() { profileNTP(); }
	 
	 @FXML
	 public void backClick()  { backNTP(); }
	 
	 @FXML
	 public void insertTopicClick()  { insertTopic(); }
	 
	
	 

}
