package boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import bean.PostBean;
import control.ControlSamplePost;

import java.io.File;

public class NewSamplePostGUI extends WindowManager{
	
	
	int i;
	static File fl;
	static Media media;
	static MediaPlayer mediaPlayer;
	
	
	@FXML
	private TextArea nSPSongTA;
	
	@FXML
	private VBox root;
	
	@FXML
	private AnchorPane nSPCentrePane;
	
	@FXML
	private TextField nSPTitleTA;
	
	@FXML
	private TextField nSPDescriptionTA;
	
	@FXML
	private Text nSPSocialMusicTXT;
	
	@FXML
	private Text nSPProfileTXT;
	
	@FXML
	private Text nSPMessagesTXT;
	
	@FXML
	private Text nSPLogoutTXT;
	
	@FXML
	private Button nSPMessagesBTN;
	    
	@FXML
	private Button nSPProfileBTN;
	    
	@FXML
	private Button nSPLogoutBTN;
	
    @FXML
	private Button nSPSocialMusicBTN;
    
    @FXML
	private Button nSPBackBTN;
    
    @FXML
   	private Button nSPUploadBTN;
    
    @FXML
	private Button nSPPlayBTN;
    
    @FXML
	private Button nSPStopBTN;
    
    @FXML
	private Button nSPInsertBTN;
    
    @FXML
   	private ImageView nSPProfileIMG;
       
    @FXML
   	private ImageView nSPMessagesIMG;
       
    @FXML
   	private ImageView nSPLogoutIMG;
    
    @FXML
   	private ImageView nSPKeyIMG;
    
   
    
    
    @FXML
	 public void initialize()
	 {
    	nSPPlayBTN.setVisible(false);
    	nSPStopBTN.setVisible(false);
    	
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
	 
	 
	 
	 public void choose() {
		 	FileChooser f = new FileChooser();

			fl = f.showOpenDialog(root.getScene().getWindow());

			nSPSongTA.setText(fl.getName());
			media = new Media(fl.toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			nSPPlayBTN.setVisible(true);
	    	nSPStopBTN.setVisible(true);
	 }
	 
	 
	 public void playSong() {
		 mediaPlayer.play();
	 }
	 
	 public void stopSong() {
		 mediaPlayer.stop();
	 }
	 
	 public void insertPost() {
		 
		 ControlSamplePost ctrlSamplePost = new ControlSamplePost();
		 
		 if (fl == null) {
			
				ctrlSamplePost.insertSamplePostErrorAlert();

			} else {
				
				PostBean postBean = new PostBean();
				
				postBean.setNomeSample(fl.getName());
				postBean.setTitolo(nSPTitleTA.getText());
				postBean.setDescrizione(nSPDescriptionTA.getText());
				
				media = null;
				fl = null;
				nSPPlayBTN.setVisible(false);
		    	nSPStopBTN.setVisible(false);
				
				ctrlSamplePost.insertSamplePost(postBean);
				
				 try {
						requestNewStage.setNewStage("PostsGUI.fxml", 512, 512, "Social Music");
					} catch (Exception e) {
						
						e.printStackTrace();
					}
	
				
				
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
	 public void chooseClick()  { choose(); }
	 
	 @FXML
	 public void playClick()  { playSong(); }
	 
	 @FXML
	 public void stopClick()  { stopSong(); }
   
	 @FXML
	 public void insertPostClick()  { insertPost(); }
    
    
}