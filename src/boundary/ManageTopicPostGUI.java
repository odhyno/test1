package boundary;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import bean.PostBean;
import control.ControlTopicPost;

public class ManageTopicPostGUI extends WindowManager {
	
	@FXML
	private TextArea mRTPPostsTA;
	
	@FXML
	private TextField mRTPIDTA;
	
	@FXML
	private TextField mRTPTitleTA;
	
	@FXML
	private TextField mRTPDescriptionTA;
	
	@FXML
	private TextField mTPTopicTA;
	
	@FXML
	private Text mRTPSocialMusicTXT;
	
	@FXML
	private Text mRTPProfileTXT;
	
	@FXML
	private Text mRTPMessagesTXT;
	
	@FXML
	private Text mRTPLogoutTXT;
	
	@FXML
	private Button mRTPMessagesBTN;
	    
	@FXML
	private Button mRTPProfileBTN;
	    
	@FXML
	private Button mRTPLogoutBTN;
	
    @FXML
	private Button mRTPSocialMusicBTN;
	
    @FXML
	private Button mRTPBackBTN;
    
    @FXML
   	private ImageView mRTPProfileIMG;
       
    @FXML
   	private ImageView mRTPMessagesIMG;
       
    @FXML
   	private ImageView mRTPLogoutIMG;
    
    @FXML
   	private ImageView mRTPKeyIMG;
    
    @FXML
	private Button mRTPModifyBTN;
    
    @FXML
	private Button mRTPRemoveBTN;
    
    @FXML
	private Button mRTPOkBTN;
    
	
	
	 @FXML
	 public void initialize()
	 {
		 
		 ControlTopicPost ctrlPost = new ControlTopicPost();
			
		 List<PostBean> postList = ctrlPost.filterTopicPostByUsername(getInstance().getLoggedUser().getUsername());
			
		 int i;
		 mRTPOkBTN.setVisible(false);
		 mRTPTitleTA.setVisible(false);
		 mRTPDescriptionTA.setVisible(false);
		 mTPTopicTA.setVisible(false);
		 mRTPIDTA.setVisible(false);
		 
		 if(postList.size() == 0) {
				
			 mRTPPostsTA.setText("No Request Posts in the system");
				
			} else {
				
				for(i=0; i<postList.size(); i++) {
					
					mRTPPostsTA.setText(mRTPPostsTA.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
							"\nAutore: " + postList.get(i).getAutore() + "\nArgomento: " + postList.get(i).getArgomento() +
							"\n\nDescrizione: " + postList.get(i).getDescrizione() + "\n\n");
				}
				
			} 
	 }
	 
	 public void removeTopicPostAlert() {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Post Removed Successfully");
			alert.setContentText("Success! Your Post has been removed!");

			alert.showAndWait();
		}

		public void removeTopicPostErrorAlert() {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Remove Post Error");
			alert.setContentText("Error: You've inserted an id not valid. Retry!");

			alert.showAndWait();
		}
		
		public void modifyTopicPostAlert() {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Post Modify Successfully");
			alert.setContentText("Success! Your Post has been modified!");

			alert.showAndWait();
		}

		public void modifyTopicPostErrorAlert() {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Modify Post Error");
			alert.setContentText("Error: You've inserted an id not valid. Retry!");

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
	 
	 public void removeTPost() {
		 
		 cmd = 0;

			mRTPModifyBTN.setVisible(false);
			mRTPIDTA.setVisible(true);
			mRTPOkBTN.setVisible(true);
	 }
	 
	 public void modifyTPost() {
		 
		 cmd = 1;

		 	mRTPIDTA.setVisible(true);
			mRTPRemoveBTN.setVisible(false);
			mRTPTitleTA.setVisible(true);
			mRTPDescriptionTA.setVisible(true);	
			mRTPOkBTN.setVisible(true);
			mTPTopicTA.setVisible(true);
	 }
	 
	 
	 public void okTFun() {
		 
		 ControlTopicPost ctrlPost = new ControlTopicPost();
		 PostBean post= new PostBean();
		 post.setAutore(getInstance().getLoggedUser().getUsername());
		 post.setId(Integer.parseInt(mRTPIDTA.getText())-1);
		 
		if(cmd==0) {
				
				int res= ctrlPost.removeTopicPost(post);
				if(res==-1) {
					removeTopicPostErrorAlert();
				}else {
					removeTopicPostAlert();
				}
				
				mRTPModifyBTN.setVisible(true);
				
				mRTPPostsTA.clear();
				mRTPIDTA.clear();
				cmd = -1;
				
		}else {
				
				int res = ctrlPost.checkId(post);
				
				if(res == -1) {
					modifyTopicPostErrorAlert();
					cmd = -1;
					
					mRTPRemoveBTN.setVisible(true);
					
					mRTPPostsTA.clear();
					mRTPIDTA.clear();
					
					try {
						requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, socialMusic);
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					
				}
				
				mRTPIDTA.setEditable(false);
				
				PostBean postBean = new PostBean();
				postBean.setAutore(getInstance().getLoggedUser().getUsername());
				postBean.setTitolo(mRTPTitleTA.getText());
				postBean.setDescrizione(mRTPDescriptionTA.getText());
				postBean.setArgomento(mTPTopicTA.getText());
				
				res= ctrlPost.modifyTopicPost(postBean);
				if(res==-1) {
					modifyTopicPostErrorAlert();
				}else {
					modifyTopicPostAlert();
				}
				
				cmd = -1;
				
				mRTPRemoveBTN.setVisible(true);
				mRTPIDTA.clear();
				mRTPTitleTA.setVisible(false);
				mRTPTitleTA.clear();
				mRTPDescriptionTA.setVisible(false);
				mRTPDescriptionTA.clear();
				mTPTopicTA.setVisible(false);
				mTPTopicTA.clear();
		}	
		 
		 try {
				requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, socialMusic);
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
	 public void removeTClick()  { removeTPost(); }
	 
	 @FXML
	 public void modifyTClick()  { modifyTPost(); }
	 
	 @FXML
	 public void okTClick()  { okTFun(); }
	 
	 
	 

}
