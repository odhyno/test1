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
	
	private static String socialMusic = "Social Music";
	
	int i;
	
	@FXML
	private TextArea sSPPostsTA;
	
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
	private Button sSPSearchBTN;
    
    @FXML
   	private ImageView mRSPProfileIMG;
       
    @FXML
   	private ImageView mRSPMessagesIMG;
       
    @FXML
   	private ImageView mRSPLogoutIMG;
    
    @FXML
   	private ImageView mRSPKeyIMG;
    
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
	 
	 
	 public void searchPost() {
		 
		 List<PostBean> postList;
		 
		 switch(WindowManager.type) {
			
			case 1:
				
						System.out.println("QUI1");
				
						ControlSamplePost ctrlSamplePost = new ControlSamplePost();

						postList = ctrlSamplePost.filterSamplePostByUsername(sSPUsernameTA.getText());
						
						sSPPostsTA.setVisible(true);
		
						int i;
											
						if(postList.size() == 0) {
							
							sSPPostsTA.setText("No posts from this user");
							
						} else {
							
							for(i=0; i<postList.size(); i++) {
								
								sSPPostsTA.setText(sSPPostsTA.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
										"\nAutore: " + postList.get(i).getAutore() + "\n\nDescrizione: " + postList.get(i).getDescrizione() +
										"\n\nNome Sample: " + postList.get(i).getNomeSample() + "\n\n");
							}
							
						}	
					
				
				
				break;
				
			case 2:
				
						ControlRequestPost ctrlRequestPost = new ControlRequestPost();
				
						postList = ctrlRequestPost.filterRequestPostByUsername(sSPUsernameTA.getText());
						
						sSPPostsTA.setVisible(true);	
						
						
						if(postList.size() == 0) {
							
							sSPPostsTA.setText("No posts from this user");
							
						} else {
							
							for(i=0; i<postList.size(); i++) {
								
								sSPPostsTA.setText(sSPPostsTA.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
										"\nAutore: " + postList.get(i).getAutore() + "\n\nDescrizione: " + postList.get(i).getDescrizione() + "\n\n");
							}
							
						}
				
				break;
				
			case 3:
				
						ControlTopicPost ctrlTopicPost = new ControlTopicPost();

						postList = ctrlTopicPost.filterTopicPostByUsername(sSPUsernameTA.getText());
						
						sSPPostsTA.setVisible(true);	
						
						if(postList.size() == 0) {
							
							sSPPostsTA.setText("No posts from this user");
							
						} else {
							
							for(i=0; i<postList.size(); i++) {
								
								sSPPostsTA.setText(sSPPostsTA.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() 
										+ "\nAutore: " + postList.get(i).getAutore() + "\nArgomento: " + postList.get(i).getArgomento()
										+ "\n\nDescrizione: " + postList.get(i).getDescrizione() + "\n\n");
							}
							
						}
				
				break;
				
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
