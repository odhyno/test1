package logic.boundary;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import logic.bean.PostBean;
import logic.control.ControlSamplePost;
import logic.exceptions.EmptyIdException;

public class ManageSamplePostGUI extends WindowManager {
	
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
	private Button mRSPModifyBTN;
    
    @FXML
	private Button mRSPRemoveBTN;
    
    @FXML
	private Button mRSPOkBTN;
  
	
	 @FXML
	 public void initialize()
	 {
		 try {
			 
			 mRSPPostsTA.setEditable(false);
			 ControlSamplePost ctrlPost = ControlSamplePost.getInstance();
				
			 List<PostBean> postList = ctrlPost.filterSamplePostByUsername(getInstance().getLoggedUser().getUsername());
				
			int i;
			 mRSPOkBTN.setVisible(false);
			 mRSPTitleTA.setVisible(false);
			 mRSPDescriptionTA.setVisible(false);
			 mRSPIDTA.setVisible(false);
					
			for(i=0; i<postList.size(); i++) {
						
				mRSPPostsTA.setText(mRSPPostsTA.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
						"\nAutore: " + postList.get(i).getAutore() + "\n\nDescrizione: " + postList.get(i).getDescrizione() +
						"\n\nNome Sample: " + postList.get(i).getNomeSample() + "\n\n");
			}
					
			 
		 } catch(NullPointerException e) {
			 mRSPPostsTA.setText("You have no sample posts inserted in the system");
		 }
	 }
	 
	 public void removeSamplePostAlert() {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Post Removed Successfully");
			alert.setContentText("Success! Your Post has been removed!");

			alert.showAndWait();
		}

		public void removeSamplePostErrorAlert() {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Remove Post Error");
			alert.setContentText("Error: You've inserted an id not valid. Retry!");

			alert.showAndWait();
		}
		
		public void modifySamplePostAlert() {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Post Modify Successfully");
			alert.setContentText("Success! Your Post has been modified!");

			alert.showAndWait();
		}

		public void modifySamplePostErrorAlert() {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Modify Post Error");
			alert.setContentText("Error: You've inserted a not valid id. Retry!");

			alert.showAndWait();
		}
	 
	 
	 public void homePageMSP() {
		 
		 try {
			requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 
	 public void logoutMSP() {
		 
		 try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 public void messagesMSP() 
	 {
		 
		 try {
				requestNewStage.setNewStage("SendMessageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 public void profileMSP()
	 {
		 
		 try {
				requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512, socialMusic);
				 
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 public void backMSP()
	 {
		 
		 try {
				requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				e.printStackTrace();
			}

	 }
	 
	 public void removePost() {
		 
		 cmd = 0;

			mRSPModifyBTN.setVisible(false);
			mRSPIDTA.setVisible(true);
			mRSPOkBTN.setVisible(true);
	 }
	 
	 public void modifyPost() {
		 
		 cmd = 1;

		 	mRSPIDTA.setVisible(true);
			mRSPRemoveBTN.setVisible(false);
			mRSPTitleTA.setVisible(true);
			mRSPDescriptionTA.setVisible(true);	
			mRSPOkBTN.setVisible(true);
	 }
	 
	 
	 public void okFun() {
		 
		 try {
			 ControlSamplePost ctrlPost = ControlSamplePost.getInstance();
			 PostBean post = new PostBean();
			 post.setAutore(getInstance().getLoggedUser().getUsername());
			 
			 if(mRSPIDTA.getText().trim().isEmpty()) {
				 throw new EmptyIdException();
			 }else {
				 post.setId(Integer.parseInt(mRSPIDTA.getText())-1);
			 }
			 
			 if(cmd==0) {
					
					int res= ctrlPost.removeSamplePost(post);
					if(res==-1) {
						removeSamplePostErrorAlert();
					}else {
						removeSamplePostAlert();
					}
					
					mRSPModifyBTN.setVisible(true);
					
					mRSPPostsTA.clear();
					
					mRSPIDTA.clear();
					
					cmd = -1;
					
			 }else {	
					int res = ctrlPost.checkId(post);
					
					if(res == -1) {
						
						cmd = -1;
						
						mRSPRemoveBTN.setVisible(true);
						
						mRSPPostsTA.clear();
						
						mRSPIDTA.clear();
					
						requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, socialMusic);
						
						
						
					}
					
					mRSPIDTA.setEditable(false);
					
					post.setTitolo(mRSPTitleTA.getText());
					post.setDescrizione(mRSPDescriptionTA.getText());
					
					res= ctrlPost.modifySamplePost(post);
					if(res==-1) {
						modifySamplePostErrorAlert();
					}else {
						modifySamplePostAlert();
					}
					
					cmd = -1;
					
					mRSPRemoveBTN.setVisible(true);
					
					
					mRSPIDTA.clear();
					
					mRSPTitleTA.setVisible(false);
					mRSPTitleTA.clear();
					mRSPDescriptionTA.setVisible(false);
					mRSPDescriptionTA.clear();
					
			 }
	
			
			requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, socialMusic);
		} catch (EmptyIdException e) {
					
			e.printStackTrace();
		}  
		 
	}
	 
	 
	 
	 
	 @FXML
	 public void homePageClick() { homePageMSP(); }
	 
	 @FXML
	 public void logoutClick() { logoutMSP(); }
	 
	 @FXML
	 public void messagesClick() { messagesMSP(); }
	 
	 @FXML
	 public void profileClick() { profileMSP(); }
	 
	 @FXML
	 public void backClick()  { backMSP(); }
	 
	 @FXML
	 public void removeClick()  { removePost(); }
	 
	 @FXML
	 public void modifyClick()  { modifyPost(); }
	 
	 @FXML
	 public void okClick()  { okFun(); }
	 
	 
	 

}
