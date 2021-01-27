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
import control.ControlRequestPost;

public class ManageRequestPostGUI extends WindowManager {
	
	@FXML
	private TextArea mRRPPostsTA;
	
	@FXML
	private TextField mRRPIDTA;
	
	@FXML
	private TextField mRRPTitleTA;
	
	@FXML
	private TextField mRRPDescriptionTA;
	
	@FXML
	private Text mRRPSocialMusicTXT;
	
	@FXML
	private Text mRRPProfileTXT;
	
	@FXML
	private Text mRRPMessagesTXT;
	
	@FXML
	private Text mRRPLogoutTXT;
	
	@FXML
	private Button mRRPMessagesBTN;
	    
	@FXML
	private Button mRRPProfileBTN;
	    
	@FXML
	private Button mRRPLogoutBTN;
	
    @FXML
	private Button mRRPSocialMusicBTN;
	
    @FXML
	private Button mRRPBackBTN;
    
    @FXML
   	private ImageView mRRPProfileIMG;
       
    @FXML
   	private ImageView mRRPMessagesIMG;
       
    @FXML
   	private ImageView mRRPLogoutIMG;
    
    @FXML
   	private ImageView mRRPKeyIMG;
    
    @FXML
	private Button mRRPModifyBTN;
    
    @FXML
	private Button mRRPRemoveBTN;
    
    @FXML
	private Button mRRPOkBTN;
    
    
	
	
	 @FXML
	 public void initialize()
	 {
		 ControlRequestPost ctrlPost = new ControlRequestPost();
			
		 List<PostBean> postList = ctrlPost.filterRequestPostByUsername(getInstance().getLoggedUser().getUsername());
			
		 int i;
		 mRRPOkBTN.setVisible(false);
		 mRRPTitleTA.setVisible(false);
		 mRRPDescriptionTA.setVisible(false);
		 mRRPIDTA.setVisible(false);
		 
		 if(postList.size() == 0) {
				
			 mRRPPostsTA.setText("No Request Posts in the system");
				
			} else {
				
				for(i=0; i<postList.size(); i++) {
					
					mRRPPostsTA.setText(mRRPPostsTA.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
							"\nAutore: " + postList.get(i).getAutore() + "\n\nDescrizione: " + postList.get(i).getDescrizione() + "\n\n");
				}
				
			} 
	 }
	 
	 public void removeRequestPostAlert() {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Post Removed Successfully");
			alert.setContentText("Success! Your Post has been removed!");

			alert.showAndWait();
		}

		public void removeRequestPostErrorAlert() {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Remove Post Error");
			alert.setContentText("Error: You've inserted an id not valid. Retry!");

			alert.showAndWait();
		}
		
		public void modifyRequestPostAlert() {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Post Modify Successfully");
			alert.setContentText("Success! Your Post has been modified!");

			alert.showAndWait();
		}

		public void modifyRequestPostErrorAlert() {

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
	 
	 public void removeRPost() {
		 
		 cmd = 0;

			mRRPModifyBTN.setVisible(false);
			mRRPIDTA.setVisible(true);
			mRRPOkBTN.setVisible(true);
	 }
	 
	 public void modifyRPost() {
		 
		 cmd = 1;

		 	mRRPIDTA.setVisible(true);
			mRRPRemoveBTN.setVisible(false);
			mRRPTitleTA.setVisible(true);
			mRRPDescriptionTA.setVisible(true);	
			mRRPOkBTN.setVisible(true);
	 }
	 
	 
	 public void okRFun() {
		 
		 
		 ControlRequestPost ctrlPost = new ControlRequestPost();
		 PostBean post= new PostBean();
		 post.setAutore(getInstance().getLoggedUser().getUsername());
		 post.setId(Integer.parseInt(mRRPIDTA.getText())-1);
			
		 if(cmd== 0) {
				
				int res= ctrlPost.removeRequestPost(post);
				if(res==-1) {
					removeRequestPostErrorAlert();
					
				}else {
					removeRequestPostAlert();
				}
			
				
				mRRPModifyBTN.setVisible(true);
				
				mRRPPostsTA.clear();
				mRRPIDTA.clear();
				cmd = -1;
				
		 }else {
				
				int res = ctrlPost.checkId(post);
				
				if(res == -1) {
					removeRequestPostErrorAlert();
					cmd = -1;
					
					mRRPRemoveBTN.setVisible(true);
					mRRPPostsTA.clear();
					mRRPIDTA.clear();
					
					try {
						requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, socialMusic);
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					
					
				}
				
				mRRPIDTA.setEditable(false);
				
				post.setTitolo(mRRPTitleTA.getText());
				post.setDescrizione(mRRPDescriptionTA.getText());
				
				res= ctrlPost.modifyRequestPost(post);
				if(res==-1) {
					modifyRequestPostErrorAlert();
					
				}else {
					modifyRequestPostAlert();
				}
				
				cmd = -1;
				
				mRRPRemoveBTN.setVisible(true);				
				mRRPIDTA.clear();
				mRRPTitleTA.setVisible(false);
				mRRPTitleTA.clear();
				mRRPDescriptionTA.setVisible(false);
				mRRPDescriptionTA.clear();
				
				
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
	 public void removeRClick()  { removeRPost(); }
	 
	 @FXML
	 public void modifyRClick()  { modifyRPost(); }
	 
	 @FXML
	 public void okRClick()  { okRFun(); }
	 
	 
	 

}
