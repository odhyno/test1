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
import logic.control.ControlRequestPost;
import logic.exceptions.EmptyIdException;
import logic.exceptions.ModifyRequestPostException;
import logic.exceptions.RemoveRequestPostException;

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
		 try {
			 
		 
			 mRRPPostsTA.setEditable(false);
			 ControlRequestPost ctrlPost = ControlRequestPost.getInstance();
				
			 List<PostBean> postList = ctrlPost.filterRequestPostByUsername(getInstance().getLoggedUser().getUsername());
				
			 int i;
			 mRRPOkBTN.setVisible(false);
			 mRRPTitleTA.setVisible(false);
			 mRRPDescriptionTA.setVisible(false);
			 mRRPIDTA.setVisible(false);
				
					for(i=0; i<postList.size(); i++) {
						
						mRRPPostsTA.setText(mRRPPostsTA.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
								"\nAutore: " + postList.get(i).getAutore() + "\n\nDescrizione: " + postList.get(i).getDescrizione() + "\n\n");
					}
					
		 } catch (NullPointerException e) {
			 mRRPPostsTA.setText("You have not inserted request posts in the system");
		 }
	 }
	 
	 public void removeRequestPostAlert() {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Post  Successfully Removed");
			alert.setContentText("Success! Your Post has been removed!");

			alert.showAndWait();
		}

		public void modifyRequestPostAlert() {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Post Successfully Modified ");
			alert.setContentText("Success! Your Post has been modified!");

			alert.showAndWait();
		}
	 
	 
	 public void homePageMRP() {
		 
		 try {
			requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 
	 public void logoutMRP() {
		 
		 try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 public void messagesMRP() 
	 {
		 
		 try {
				requestNewStage.setNewStage("SendMessageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 public void profileMRP()
	 {
		 
		 try {
				requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512, socialMusic);
				 
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 public void backMRP()
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
		 
		 try {
		 
			 ControlRequestPost ctrlPost = ControlRequestPost.getInstance();
			 PostBean post= new PostBean();
			 post.setAutore(getInstance().getLoggedUser().getUsername());
			 
			 if(mRRPIDTA.getText().trim().isEmpty()) {
				 throw new EmptyIdException();
			 }else {
				
				 post.setId(Integer.parseInt(mRRPIDTA.getText())-1);
			 }
			 
				
			 if(cmd== 0) {
					
					int res= ctrlPost.removeRequestPost(post);
					if(res==-1) {
						requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, socialMusic);
						throw new RemoveRequestPostException();
						
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
				
						cmd = -1;
						
						mRRPRemoveBTN.setVisible(true);
						mRRPPostsTA.clear();
						mRRPIDTA.clear();
						
						requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, socialMusic);
						
						throw new ModifyRequestPostException();			
						
					}
					
					mRRPIDTA.setEditable(false);
					
					post.setTitolo(mRRPTitleTA.getText());
					post.setId(res);
					post.setDescrizione(mRRPDescriptionTA.getText());
					
					
					res= ctrlPost.modifyRequestPost(post);
					if(res==-1) {
						requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, socialMusic);
						throw new ModifyRequestPostException();
						
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
			 
			
			requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, socialMusic);
			
		 } catch (RemoveRequestPostException e) {
			 e.printStackTrace();
		 } catch (ModifyRequestPostException e1) {
			 e1.printStackTrace();
		 } catch (EmptyIdException e2) {
				
			 e2.printStackTrace();
			 
	   	 } catch (Exception e3) {
					
				e3.printStackTrace();
		 }
	}
	 
	 
	 
	 
	 @FXML
	 public void homePageClick() { homePageMRP(); }
	 
	 @FXML
	 public void logoutClick() { logoutMRP(); }
	 
	 @FXML
	 public void messagesClick() { messagesMRP(); }
	 
	 @FXML
	 public void profileClick() { profileMRP(); }
	 
	 @FXML
	 public void backClick()  { backMRP(); }
	 
	 @FXML
	 public void removeRClick()  { removeRPost(); }
	 
	 @FXML
	 public void modifyRClick()  { modifyRPost(); }
	 
	 @FXML
	 public void okRClick()  { okRFun(); }
	 
	 
	 

}
