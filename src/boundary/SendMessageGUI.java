package boundary;

import java.util.List;

import bean.MessageBean;

import control.ControllerSendMessage;
import interfaces.Observer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import thread.CheckThread;



public class SendMessageGUI extends WindowManager {
	
	
	@FXML
    public  Pane pane;

	@FXML
	private ListView<String> userView;
	    
	@FXML
	private TextArea messageArea;
    
	@FXML
	private Rectangle rectangle;
	 
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
    
    
    public int notifyNumb;
   
    
    @FXML
    public void initialize()
    {
    	Observer controllerSendMessage = ControllerSendMessage.getInstance();

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
    
    
    
    // allert per il messaggio vuoto
  	public void sendTextAllert() {
  		Alert alert = new Alert(AlertType.ERROR);
  		alert.setTitle("Social Music");
  		alert.setHeaderText("Empty text Error");
  		alert.setContentText("Error: Empty text. Retry!");

  			alert.showAndWait();
 	
  	}
  	
  	
 // alert per non aver contattato nessun utente
   	public void sendTextAreaAllert() {
   		Alert alert = new Alert(AlertType.ERROR);
   		alert.setTitle("Social Music");
   		alert.setHeaderText("Unselected user Error");
   		alert.setContentText("Error: Empty Unselected user . Retry!");

   			alert.showAndWait();
  	
   	}
  	
  	   
    // fnzione che si attiva alla pressione del pulsante back
    public void back ()throws Exception {
		
    	Observer controllerSendMessage = ControllerSendMessage.getInstance();
    	controllerSendMessage.removeObserver();
		requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, "Social Music");
	}
    
    
    
    // funzione che si attiva all apressione di uno degli elementi della listView
    public void userViewButton() {
    	    	
    	Observer controllerSendMessage = ControllerSendMessage.getInstance();
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
    		
    		sendTextAreaAllert();
    		return;
    		
    	}
    	
    	
    	getInstance().setMessage(messageBean);
    	
    	chatText.setText(" CHAT CON " + ricevente);
    	 
    	changeTextArea();
    	 
    	return;
    	    	 
    }
   
    
    
 /*   // funzione che invia la notifica
 	public  synchronized  void sendNotify(int newValue) {
 		
 		System.out.println(" hai "+newValue + " nuove notifiche");//VA LASCIATA
 		
 		// setto il notifyBean
 		notifyBean.setUsername(getInstance().getLoggedUser().getUsername());
 		notifyBean.setValoreConosciuto(newValue);
 		
 		
 		controllerSendMessage.addNotify(notifyBean);  
 		
 	}*/
 	
 	
    // funzione che cambia la textArea dei messaggi precedenti
    public void changeTextArea() {
    	
    	MessageBean messageBean=getInstance().getMessage();
    	
    	Observer ctrlSendMessage = ControllerSendMessage.getInstance();
    	
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
    	
    	return;
		
	}
    
    
    // funzione che invia il messaggio
 	public void send() {
 		
 		Observer controllerSendMessage = ControllerSendMessage.getInstance();
 		
 		int res=checkTesto(messageField.getText());
		if(res==0) {
			
			sendTextAllert();
			return;
		}
		
 		MessageBean messageBean=getInstance().getMessage();
 		
 			
	 	//setto il messageBean
		messageBean.setTesto(messageField.getText());
			
		controllerSendMessage.inserText(messageBean);
		changeTextArea();
			
		messageField.setText("");
			
		return;
		/*}else {
			sendTextAreaAllert();
			return;
		}*/
					
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
    public void listViewMouseClick() throws Exception { userViewButton(); }
	
	@FXML
    public void backMouseClick() throws Exception { back(); }
	
	@FXML
    public void sendMouseClick() throws Exception { send(); }
		
}



		