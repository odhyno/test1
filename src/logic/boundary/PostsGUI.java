package logic.boundary;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import logic.bean.PostBean;
import logic.control.ControlRequestPost;
import logic.control.ControlSamplePost;
import logic.control.ControlTopicPost;

public class PostsGUI extends WindowManager {
	
	
	
	@FXML
	private TextArea sPPostsTA;
	
	@FXML
	private Text sPSocialMusicTXT;
	
	@FXML
	private Text sPProfileTXT;
	
	@FXML
	private Text sPMessagesTXT;
	
	@FXML
	private Text sPLogoutTXT;
	
	@FXML
	private Text sPNewPostTXT;
	
	@FXML
	private Text sPManagePostsTXT;
	
	@FXML
	private Text sPSearchPostTXT;
	
	@FXML
	private Button sPMessagesBTN;
	    
	@FXML
	private Button sPProfileBTN;
	    
	@FXML
	private Button sPLogoutBTN;
	
    @FXML
	private Button sPSocialMusicBTN;
    
    @FXML
	private Button sPNewPostBTN;
	    
	@FXML
	private Button sPManagePostsBTN;
	    
	@FXML
	private Button sPSearchPostBTN;
	
    @FXML
	private Button sPBackBTN;
    
    @FXML
   	private ImageView sPProfileIMG;
       
    @FXML
   	private ImageView sPMessagesIMG;
       
    @FXML
   	private ImageView sPLogoutIMG;
    
    @FXML
   	private ImageView sPKeyIMG;
    
    @FXML
   	private ImageView sPNewPostIMG;
       
    @FXML
   	private ImageView sPSearchPostIMG;
    
    @FXML
   	private ImageView sPManagePostsIMG;
    
	
	
	
	 @FXML
	 public void initialize()
	 {
		 sPPostsTA.setEditable(false);
		 
		 switch(type) {
		 
		 case 1:
			 
			 ControlSamplePost ctrlPost =  ControlSamplePost.getInstance();
				
			 List<PostBean> postList = ctrlPost.getSamplePosts();
			 
			 if(postList.size() == 0) {
					
				 sPPostsTA.setText("No Sample Posts in the system");
				 return;
					
			} 
			 
			 updateSampleTA(postList);
					
			
					
			
			 
			 break;
			 
		 case 2:
			 
			 ControlRequestPost ctrlRequestPost =  ControlRequestPost.getInstance();
				
			 List<PostBean> postList2 = ctrlRequestPost.getRequestPosts();
				
				sPPostsTA.setVisible(true);	
				
				
				if(postList2.size() == 0) {
					
					sPPostsTA.setText("No Request Posts in the system");
					return;
					
				} 
					
				updateRequestTA(postList2);
				
				break;
			 
		 case 3:	 
			 
			 ControlTopicPost ctrlTopicPost = new ControlTopicPost();

			 List<PostBean> postList3 = ctrlTopicPost.getTopicPosts();
				
				sPPostsTA.setVisible(true);	
				
				if(postList3.size() == 0) {
					
					sPPostsTA.setText("No Topic posts in the system");
					return;
					
				}
					
				updloadTopicTA(postList3);
				
		
			break;
		
		default:
			
			return;
		
		 
		 }	 
	 }
	 
	public void updloadTopicTA(List<PostBean> postList3) {
		int i;
		for(i=0; i<postList3.size(); i++) {
			
			sPPostsTA.setText(sPPostsTA.getText() + "Post  #" + Integer.toString(i+1) + "\nTitolo:  " + postList3.get(i).getTitolo() 
					+ "\nAutore:  " + postList3.get(i).getAutore() + "\nArgomento: " + postList3.get(i).getArgomento()
					+ "\n\nDescrizione:  " + postList3.get(i).getDescrizione() + "\n\n");
		}
		
	}

	public void updateRequestTA(List<PostBean> postList2) {
		int i;
		for(i=0; i<postList2.size(); i++) {
			
			sPPostsTA.setText(sPPostsTA.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList2.get(i).getTitolo() +
					"\nAutore: " + postList2.get(i).getAutore() + "\n\nDescrizione: " + postList2.get(i).getDescrizione() + "\n\n");
		}
	}

	public void  updateSampleTA( List<PostBean> postList) {
		 
		 int i;
		 for(i=0; i<postList.size(); i++) {
				
				sPPostsTA.setText(sPPostsTA.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
						"\nAutore: " + postList.get(i).getAutore() + "\n\nDescrizione: " + postList.get(i).getDescrizione() +
						"\n\nNome Sample: " + postList.get(i).getNomeSample() + "\n\n");
			}
	 }
	 
	 
	 public void homePageP() {
		 
		 try {
			requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 
	 public void logoutP() {
		 
		 try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 public void messagesP() 
	 {
		 
		 try {
				requestNewStage.setNewStage("SendMessageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				
				e.printStackTrace();
			}


	 }
	 
	 public void profileP()
	 {
		 
		 try {
				requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512, socialMusic);
				 
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 public void newPost()
	 {
		 
		 switch(WindowManager.type) {
		 
		 case 1:
				 try {
						requestNewStage.setNewStage("NewSamplePostGUI.fxml", 512, 512, socialMusic);
				} catch (Exception e) {
						e.printStackTrace();
				}
				 
				break;
		 case 2:
			 
				 try {
						requestNewStage.setNewStage("NewRequestPostGUI.fxml", 512, 512, "Social Music");
				} catch (Exception e) {
						e.printStackTrace();
				}
				 
				 break;
				 
		 case 3:

				 try {
						requestNewStage.setNewStage("NewTopicPostGUI.fxml", 512, 512, socialMusic);
				} catch (Exception e) {
						e.printStackTrace();
				}
				 break;
		default:
				
				return;
		
		 }

	 }
	 
	 public void searchPost()
	 {
		 
		 try {
				requestNewStage.setNewStage("SearchPostGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
	 
	 public void managePosts()
	 {
		if(WindowManager.type==1) {
			 
				 try {
						requestNewStage.setNewStage("ManageSamplePostGUI.fxml", 512, 512, socialMusic);
				} catch (Exception e) {
						e.printStackTrace();
				}
				 
		}else if(WindowManager.type==2) {
				 try {
						requestNewStage.setNewStage("ManageRequestPostGUI.fxml", 512, 512, socialMusic);
				} catch (Exception e) {
						e.printStackTrace();
				}
				 
		}else if(WindowManager.type==3) {
				 try {
						requestNewStage.setNewStage("ManageTopicPostGUI.fxml", 512, 512, socialMusic);
				} catch (Exception e) {
						e.printStackTrace();
				}
		
		}

	 }
	 
	 public void backP()
	 {
		 
		 try {
				requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
			} catch (Exception e) {
				e.printStackTrace();
			}

	 }
	 
	 
	 
	 @FXML
	 public void homePageClick() { homePageP(); }
	 
	 @FXML
	 public void logoutClick() { logoutP(); }
	 
	 @FXML
	 public void messagesClick() { messagesP(); }
	 
	 @FXML
	 public void profileClick() { profileP(); }
	 
	 @FXML
	 public void backClick()  { backP(); }
	 
	 @FXML
	 public void newPostClick()  { newPost(); }
	 
	 @FXML
	 public void searchPostClick()  { searchPost(); }
	 
	 @FXML
	 public void managePostsClick()  { managePosts(); }

}
