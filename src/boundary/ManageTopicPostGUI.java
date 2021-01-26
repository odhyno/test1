package boundary;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import bean.PostBean;
import control.ControlTopicPost;

public class ManageTopicPostGUI extends WindowManager {
	
	private static String socialMusic = "Social Music";
	
	int i;
	
	static int cmd = -1;
	
	@FXML
	private TextArea mRSPPostsTA;
	
	@FXML
	private TextField mRSPIDTA;
	
	@FXML
	private TextField mRSPTitleTA;
	
	@FXML
	private TextField mRSPDescriptionTA;
	
	@FXML
	private TextField mTPTopicTA;
	
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
		 
		 ControlTopicPost ctrlPost = new ControlTopicPost();
			
		 List<PostBean> postList = ctrlPost.filterTopicPostByUsername(getInstance().getLoggedUser().getUsername());
			
		 
		 mRSPOkBTN.setVisible(false);
		 mRSPTitleTA.setVisible(false);
		 mRSPDescriptionTA.setVisible(false);
		 mTPTopicTA.setVisible(false);
		 mRSPIDTA.setVisible(false);
		 
		 if(postList.size() == 0) {
				
			 mRSPPostsTA.setText("No Request Posts in the system");
				
			} else {
				
				for(i=0; i<postList.size(); i++) {
					
					mRSPPostsTA.setText(mRSPPostsTA.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
							"\nAutore: " + postList.get(i).getAutore() + "\nArgomento: " + postList.get(i).getArgomento() +
							"\n\nDescrizione: " + postList.get(i).getDescrizione() + "\n\n");
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
	 
	 public void removeTPost() {
		 
		 cmd = 0;

			mRSPModifyBTN.setVisible(false);
			mRSPIDTA.setVisible(true);
			mRSPOkBTN.setVisible(true);
	 }
	 
	 public void modifyTPost() {
		 
		 cmd = 1;

		 	mRSPIDTA.setVisible(true);
			mRSPRemoveBTN.setVisible(false);
			mRSPTitleTA.setVisible(true);
			mRSPDescriptionTA.setVisible(true);	
			mRSPOkBTN.setVisible(true);
			mTPTopicTA.setVisible(true);
	 }
	 
	 
	 public void okTFun() {
		 
		 ControlTopicPost ctrlPost = new ControlTopicPost();
		 
		 
		 switch(cmd) {	
			
			case 0: //remove
				
				ctrlPost.removeTopicPost(Integer.parseInt(mRSPIDTA.getText())-1);
				
				System.out.println("qui1");
				
				mRSPModifyBTN.setVisible(true);
				
				mRSPPostsTA.clear();
				mRSPIDTA.clear();
				cmd = -1;
				
				break;
				
			case 1: //modify
				
				int res = ctrlPost.checkId(Integer.parseInt(mRSPIDTA.getText())-1);
				
				System.out.println("qui 3   " + res);
				
				if(res == -1) {
					
					cmd = -1;
					
					mRSPRemoveBTN.setVisible(true);
					
					mRSPPostsTA.clear();
					mRSPIDTA.clear();
					
					break;
					
				}
				
				mRSPIDTA.setEditable(false);
				
				cmd = 2;
			
			case 2:
				
				PostBean postBean = new PostBean();
				
				postBean.setTitolo(mRSPTitleTA.getText());
				postBean.setDescrizione(mRSPDescriptionTA.getText());
				postBean.setArgomento(mTPTopicTA.getText());
				
				ctrlPost.modifyTopicPost(postBean, Integer.parseInt(mRSPIDTA.getText()) -1);
				
				cmd = -1;
				
				mRSPRemoveBTN.setVisible(true);
				mRSPIDTA.clear();
				mRSPTitleTA.setVisible(false);
				mRSPTitleTA.clear();
				mRSPDescriptionTA.setVisible(false);
				mRSPDescriptionTA.clear();
				mTPTopicTA.setVisible(false);
				mTPTopicTA.clear();
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
	 public void removeTClick()  { removeTPost(); }
	 
	 @FXML
	 public void modifyTClick()  { modifyTPost(); }
	 
	 @FXML
	 public void okTClick()  { okTFun(); }
	 
	 
	 

}
