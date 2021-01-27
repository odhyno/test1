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
import control.ControlSamplePost;
import control.ControlTopicPost;

public class SearchPostGUI extends WindowManager {

	
	
	@FXML
	private TextArea sSPPostsTA;
	
	@FXML
	private Text sSPSocialMusicTXT;
	
	@FXML
	private Text sSPProfileTXT;
	
	@FXML
	private Text sSPMessagesTXT;
	
	@FXML
	private Text sSPLogoutTXT;
	
	@FXML
	private Button sSPMessagesBTN;
	    
	@FXML
	private Button sSPProfileBTN;
	    
	@FXML
	private Button sSPLogoutBTN;
	
    @FXML
	private Button sSPSocialMusicBTN;
	
    @FXML
	private Button sSPBackBTN;
    
    @FXML
	private Button sSPSearchBTN;
    
    @FXML
   	private ImageView sSPProfileIMG;
       
    @FXML
   	private ImageView sSPMessagesIMG;
       
    @FXML
   	private ImageView sSPLogoutIMG;
    
    @FXML
   	private ImageView sSPKeyIMG;
    
    @FXML
   	private TextField sSPUsernameTA;
    
    
	
	
	 @FXML
	 public void initialize()
	 {
		 sSPPostsTA.setVisible(false);
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
	 
	 
	 public void searchPost() {
		 
		 List<PostBean> postList;
		 
		 switch(WindowManager.type) {
			
			case 1:
				
						ControlSamplePost ctrlSamplePost = new ControlSamplePost();

						postList = ctrlSamplePost.filterSamplePostByUsername(sSPUsernameTA.getText());
						
						sSPPostsTA.setVisible(true);
						
						if(postList.size() == 0) {
							
							sSPPostsTA.setText("No sample posts from this user");
							return;
							
						}
						
						updateSampleTA(postList);
	
				
				break;
				
			case 2:
				
						ControlRequestPost ctrlRequestPost = new ControlRequestPost();
				
						postList = ctrlRequestPost.filterRequestPostByUsername(sSPUsernameTA.getText());
						
						sSPPostsTA.setVisible(true);	
						
						
						if(postList.size() == 0) {
							
							sSPPostsTA.setText("No request posts from this user");
							return;
							
						}
						
						updateRequestTA(postList);
							
				break;
				
			case 3:
				
						ControlTopicPost ctrlTopicPost = new ControlTopicPost();

						postList = ctrlTopicPost.filterTopicPostByUsername(sSPUsernameTA.getText());
						
						sSPPostsTA.setVisible(true);	
						
						if(postList.size() == 0) {
							
							sSPPostsTA.setText("No topic posts from this user");
							return;
							
						} 
						
						updateTopicTA(postList);
			
				break;
				
			default:
				
				return;
				
			}
	 }
	 
	 public void updateTopicTA(List<PostBean> postList) {
		 int i;
		 for(i=0; i<postList.size(); i++) {
				
				sSPPostsTA.setText(sSPPostsTA.getText() + "Post  #" + Integer.toString(i+1) + "\nTitolo:  " + postList.get(i).getTitolo() 
						+ "\nAutore:  " + postList.get(i).getAutore() + "\nArgomento: " + postList.get(i).getArgomento()
						+ "\n\nDescrizione:  " + postList.get(i).getDescrizione() + "\n\n");
			}
	}


	public void updateRequestTA(List<PostBean> postList) {
		 int i;
		 for(i=0; i<postList.size(); i++) {
				
				sSPPostsTA.setText(sSPPostsTA.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
						"\nAutore: " + postList.get(i).getAutore() + "\n\nDescrizione: " + postList.get(i).getDescrizione() + "\n\n");
			}
			
		
	}


	public void updateSampleTA(List<PostBean> postList) {
		 int i;
		 for(i=0; i<postList.size(); i++) {
				
				sSPPostsTA.setText(sSPPostsTA.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
						"\nAutore: " + postList.get(i).getAutore() + "\n\nDescrizione: " + postList.get(i).getDescrizione() +
						"\n\nNome Sample: " + postList.get(i).getNomeSample() + "\n\n");
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
	 public void searchClick()  { searchPost(); }
	 

}
