package logic.boundary;

import java.util.List;

import logic.bean.MessageBean;

import logic.control.ControlSendMessage;
import logic.interfaces.Observer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import logic.thread.CheckThread;



public class SendMessageGUI extends WindowManager {
	

	@FXML
	private ListView<String> userView;
	    
	@FXML
	private TextArea messageArea;
 
    @FXML
    private TextField messageField;
       
    @FXML
	public  Text chatText;

    @FXML
	private Button sendBTN;
	 
    @FXML
    private Button backBTN;
    
    @FXML
    private Button notifyBTN;
    
    @FXML
	private Button sMProfileBTN;
	    
	@FXML
	private Button sMLogoutBTN;
	
    @FXML
	private Button sMSocialMusicBTN;
    
    @FXML
   	private ImageView sMProfileIMG;
       
    @FXML
   	private ImageView sMLogoutIMG;
    
    @FXML
   	private ImageView sMKeyIMG;
    
    @FXML
	private Text sMSocialMusicTXT;
	
	@FXML
	private Text sMProfileTXT;

	@FXML
	private Text sMLogoutTXT;

    
    @FXML
    public void initialize()
    {
    	Observer controllerSendMessage = ControlSendMessage.getInstance();
    	controllerSendMessage.add();
    	
    	String username = getInstance().getLoggedUser().getUsername();
    	
    	Thread thread = new Thread(new CheckThread(username));
    	thread.start();
    	
    	MessageBean messageBean = new MessageBean();
    	
    	messageBean.setMittente(getInstance().getLoggedUser().getUsername());
    	
    	
    	List<String> usernameList =controllerSendMessage.showUsers(username);
    	
    	    
    	int n=usernameList.size();
    	        
    	for(int i=0;i<n;i++) {
    	        
    	        userView.getItems().add(usernameList.get(i));
    	    	        
    	}
    	
    }
    
    public void homePageSM() {
		 
		 try {
			requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 
	 public void logoutSM() {
		 
		 try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	 }
	 
	 public void profileSM()
	 {
		 
		 try {
				requestNewStage.setNewStage("ProfileGUI.fxml", 512, 512, socialMusic);
				 
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	 }
    

    // alert per il messaggio vuoto
  	public void sendTextAlert() {
  		Alert alert = new Alert(AlertType.ERROR);
  		alert.setTitle(socialMusic);
  		alert.setHeaderText("Empty text Error");
  		alert.setContentText("Error: Empty text. Retry!");

  			alert.showAndWait();
 	
  	}
  	
  	
 // alert per non aver contattato nessun utente
   	public void sendTextAreaAlert() {
   		Alert alert = new Alert(AlertType.ERROR);
   		alert.setTitle(socialMusic);
   		alert.setHeaderText("Unselected user Error");
   		alert.setContentText("Error: Empty Unselected user . Retry!");

   			alert.showAndWait();
  	
   	}
  	
  	   
    // fnzione che si attiva alla pressione del pulsante back
    public void backSM () {
		
    	Observer controllerSendMessage = ControlSendMessage.getInstance();
    	controllerSendMessage.removeObserver();
		requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
	}
    
    
    
    // funzione che si attiva all apressione di uno degli elementi della listView
    public void userViewButton() {
    	    	
    	Observer controllerSendMessage = ControlSendMessage.getInstance();
    	String ricevente = null;
    	
    	userView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	 
    	ObservableList<String> listOfItem = userView.getSelectionModel().getSelectedItems();
    	 
    	for(Object item: listOfItem) {
    		 ricevente= String.format((String)item);
    	 }
    	MessageBean messageBean = new MessageBean();
    	
    	messageBean.setMittente(getInstance().getLoggedUser().getUsername());
    	messageBean.setRicevente(ricevente);
    	
    	int res=controllerSendMessage.checkUser(ricevente);
    	if(res==0) {
    		
    		sendTextAreaAlert();
    		return;
    		
    	}
    	
    	
    	getInstance().setMessage(messageBean);
    	
    	chatText.setText(" CHAT CON " + ricevente);
    	 
    	changeTextArea();
    	 
    	    	 
    }
 	
 	
    // funzione che cambia la textArea dei messaggi precedenti
    public void changeTextArea() {
    	
    	MessageBean messageBean=getInstance().getMessage();
    	
    	Observer ctrlSendMessage = ControlSendMessage.getInstance();
    	
    	 List<MessageBean> messages= ctrlSendMessage.showMessages(messageBean);
    	if(messages.size()>=1 ) {
		 
    		messageArea.setText("Messagges\n\n");
		 
		 		for(int i=0; i<messages.size(); i++) {
			
		 			messageArea.setText(messageArea.getText() + Integer.toString(i+1) + "\nMittente: " + messages.get(messages.size()-1-i).getMittente() +
		 					"\nRicevente: " + messages.get(messages.size()-1-i).getRicevente() + "\nTesto: " + messages.get(messages.size()-1-i).getTesto() + "\n\n");
		 		}
    	}
    	else {
		 
   			messageArea.setText("non ci sono messaggi\n\n");
    		
    	}
	}
    
    
    // funzione che invia il messaggio
 	public void send() {
 		
 		Observer controllerSendMessage = ControlSendMessage.getInstance();
 		
 		int res=checkTesto(messageField.getText());
		if(res==0) {
			
			sendTextAlert();
			return;
		}
		
 		MessageBean messageBean=getInstance().getMessage();
 		
 			
	 	//setto il messageBean
		messageBean.setTesto(messageField.getText());
			
		controllerSendMessage.inserText(messageBean);
		changeTextArea();
			
		messageField.setText("");
					
 	}

 	// funzione per il check del testo scritto
 	public int checkTesto(String text) {
	
 		if(text.length()==0) {
 			return 0;
 		}
 		return 1;
 	} 	

    // Metodi per i bottoni
	@FXML
    public void listViewMouseClick() { userViewButton(); }
	
	@FXML
    public void backMouseClick() { backSM(); }
	
	@FXML
    public void sendMouseClick()  { send(); }
	
	 @FXML
	 public void homePageSMClick() { homePageSM(); }
	 
	 @FXML
	 public void logoutSMClick() { logoutSM(); }
	 
	 @FXML
	 public void profileSMClick() { profileSM(); }
	 
		
}



		