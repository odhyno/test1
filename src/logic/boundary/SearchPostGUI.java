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
import logic.control.ControlSamplePost;
import logic.control.ControlTopicPost;

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
	 
	 public void emptySearchAlert() {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(socialMusic);
			alert.setHeaderText("Wrong Username");
			alert.setContentText("Error: you have inserted incorrect username");

			alert.showAndWait();
		}
	 
	 
	 public void homePageSSP() {
		 
		 try {
			requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 
	 public void logoutSSP() {
		 
		 try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 public void messagesSSP() 
	 {
		 
		 try {
				requestNewStage.setNewStage("SendMessageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				
				e.printStackTrace();
			}


	 }
	 
	 public void profileSSP()
	 {
		 try {
				requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512, socialMusic);
				 
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 
	 public void searchPost() {
		 
		 List<PostBean> postList;
		 
		 try {
			 
			 
			 switch(WindowManager.type) {
				
				case 1:
					
							ControlSamplePost ctrlSamplePost = ControlSamplePost.getInstance();
	
							postList = ctrlSamplePost.filterSamplePostByUsername(sSPUsernameTA.getText());
							
							sSPPostsTA.setVisible(true);
							sSPPostsTA.setEditable(false);
							
							if(postList.size() == 0) {
								
								sSPPostsTA.setText("No sample posts from this user");
								return;
								
							}
							
							updateSampleTA(postList);
		
					
					break;
					
				case 2:
					
							ControlRequestPost ctrlRequestPost = ControlRequestPost.getInstance();
					
							postList = ctrlRequestPost.filterRequestPostByUsername(sSPUsernameTA.getText());
							
							sSPPostsTA.setVisible(true);
							sSPPostsTA.setEditable(false);
							
							
							if(postList.size() == 0) {
								
								sSPPostsTA.setText("No request posts from this user");
								return;
								
							}
							
							updateRequestTA(postList);
								
					break;
					
				case 3:
					
							ControlTopicPost ctrlTopicPost = ControlTopicPost.getInstance();
	
							postList = ctrlTopicPost.filterTopicPostByUsername(sSPUsernameTA.getText());
							
							sSPPostsTA.setVisible(true);
							sSPPostsTA.setEditable(false);
							
							if(postList.size() == 0) {
								
								sSPPostsTA.setText("No topic posts from this user");
								return;
								
							} 
							
							updateTopicTA(postList);
				
					break;
					
				default:
					
					return;
			 }
				
		} catch(NullPointerException e) {
			emptySearchAlert();
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


	public void backSSP()
	 {
		 
		 try {
				requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				e.printStackTrace();
			}

	 }
	 
	 
	 
	 @FXML
	 public void homePageClick() { homePageSSP(); }
	 
	 @FXML
	 public void logoutClick() { logoutSSP(); }
	 
	 @FXML
	 public void messagesClick() { messagesSSP(); }
	 
	 @FXML
	 public void profileClick() { profileSSP(); }
	 
	 @FXML
	 public void backClick()  { backSSP(); }
	 
	 @FXML
	 public void searchClick()  { searchPost(); }
	 

}
