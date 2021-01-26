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

	
	int i;
	
	static int cmd = -1;
	
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
		 
		 
		 switch(cmd) {	
			
			case 0: //remove
				
				ctrlPost.removeTopicPost(Integer.parseInt(mRTPIDTA.getText())-1);
				
				System.out.println("qui1");
				
				mRTPModifyBTN.setVisible(true);
				
				mRTPPostsTA.clear();
				mRTPIDTA.clear();
				cmd = -1;
				
				break;
				
			case 1: //modify
				
				int res = ctrlPost.checkId(Integer.parseInt(mRTPIDTA.getText())-1);
				
				System.out.println("qui 3   " + res);
				
				if(res == -1) {
					
					cmd = -1;
					
					mRTPRemoveBTN.setVisible(true);
					
					mRTPPostsTA.clear();
					mRTPIDTA.clear();
					
					break;
					
				}
				
				mRTPIDTA.setEditable(false);
				
				cmd = 2;
			
			case 2:
				
				PostBean postBean = new PostBean();
				
				postBean.setTitolo(mRTPTitleTA.getText());
				postBean.setDescrizione(mRTPDescriptionTA.getText());
				postBean.setArgomento(mTPTopicTA.getText());
				
				ctrlPost.modifyTopicPost(postBean, Integer.parseInt(mRTPIDTA.getText()) -1);
				
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
