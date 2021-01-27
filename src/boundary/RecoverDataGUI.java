package boundary;

import bean.UserBean;
import control.ControlLogin;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Rectangle;

public class RecoverDataGUI extends WindowManager {
	
	
	@FXML
	private Rectangle rectangle;
	 
    @FXML
    private TextField usernameField;
    
    @FXML
    private TextField emailField;
    
    @FXML
   	private Button recoveryBTN;
       
    @FXML
   	private Button backBTN;
    
    
    @FXML
    public void initialize()
    {
    		//we don't need to implement this one
    }

    public void sendDataUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);		
		alert.setHeaderText("Empty username");		
		alert.setContentText("Error: You didn't insert Your Username. Retry!");
		

		alert.showAndWait();
	}

	public void sendDataEmailAlert() {

		Alert alert = new Alert(AlertType.ERROR);		
		alert.setTitle(socialMusic);		
		alert.setHeaderText("Empty Email");		
		alert.setContentText("Error: You didn't insert Your Email. Retry!");
		alert.showAndWait();
	}

	public void mailSentDataAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);		
		alert.setTitle(socialMusic);		
		alert.setHeaderText("Recover  Data");		
		alert.setContentText("Success! Your Data has been sent at your email!");
		alert.showAndWait();
	}

	public void sendDataNotFoundAlert() {

		Alert alert = new Alert(AlertType.ERROR);		
		alert.setTitle(socialMusic);		
		alert.setHeaderText("Error Recover Data ");		
		alert.setContentText("Error: Email not found. Retry!");
		alert.showAndWait();
	}
    
    public void recoveryData() {
    	
    	ControlLogin ctrlRecoverData = ControlLogin.getInstance();
    	UserBean usBean = new UserBean();
    	
    	if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

			sendDataUsernameAlert();

		} else if (emailField.getText() == null || emailField.getText().trim().isEmpty()) {

			sendDataEmailAlert();

		} else {
			
			usBean.setUsername(usernameField.getText());
			usBean.setEmail(emailField.getText());
			
			int res=ctrlRecoverData.sendEmail(usBean);
			if(res==1) {
				mailSentDataAlert();
			}
			else {
		
				sendDataNotFoundAlert();
			}

		}
   }
    
  //funzione che torna il log in
  	public void back () {
  		
  		try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 620, socialMusic);
		} catch (Exception e) {
			e.printStackTrace();
		}
  }
  	
  	
  	
    //Metodi per la gestione dei bottoni
  	
  	 @FXML
     public void recoveryMouseClick() {recoveryData(); }
     
     @FXML
     public void backMouseClick() { back(); }

		
	

}
