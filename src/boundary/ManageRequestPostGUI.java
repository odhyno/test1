package boundary;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import bean.PostBean;
import control.ControlRequestPost;

public class ManageRequestPostGUI extends WindowManager {
	
	
	int i;
	
	static int cmd = -1;
	
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
			
			
		 switch(cmd) {
			
			case 0: //remove
				
				ctrlPost.removeRequestPost(Integer.parseInt(mRRPIDTA.getText())-1);
				
				System.out.println("qui1");
				
				mRRPModifyBTN.setVisible(true);
				
				mRRPPostsTA.clear();
				mRRPIDTA.clear();
				cmd = -1;
				
				break;
				
			case 1: //modify
				
				int res = ctrlPost.checkId(Integer.parseInt(mRRPIDTA.getText())-1);
				
				System.out.println("qui 3   " + res);
				
				if(res == -1) {
					
					cmd = -1;
					
					mRRPRemoveBTN.setVisible(true);
					mRRPPostsTA.clear();
					mRRPIDTA.clear();
					
					break;
					
				}
				
				mRRPIDTA.setEditable(false);
				
				cmd = 2;
					
				//break;
			
			case 2:
				
				System.out.println("qui 4   ");
				
				PostBean postBean = new PostBean();
				
				postBean.setTitolo(mRRPTitleTA.getText());
				postBean.setDescrizione(mRRPDescriptionTA.getText());
				
				ctrlPost.modifyRequestPost(postBean, Integer.parseInt(mRRPIDTA.getText()) -1);
				
				cmd = -1;
				
				mRRPRemoveBTN.setVisible(true);				
				mRRPIDTA.clear();
				mRRPTitleTA.setVisible(false);
				mRRPTitleTA.clear();
				mRRPDescriptionTA.setVisible(false);
				mRRPDescriptionTA.clear();
		}	
		 
		 try {
				requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, "Social Music");
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
