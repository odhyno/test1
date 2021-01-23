package boundary;

import bean.UserBean;
import controller.ControllerLogin;
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
    
    private ControllerLogin ctrlRecoverData;

    UserBean usBean = new UserBean();
    
    @FXML
    public void initialize()
    {
    	ctrlRecoverData = ControllerLogin.getInstance();
    }

    public void sendUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public void sendEmailAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: You didn't insert Email. Retry!");

		alert.showAndWait();
	}

	public void mailSentAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data");
		alert.setContentText("Success! Your Data has been sent at your email!");

		alert.showAndWait();
	}

	public void sendDataNotFoundAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: Email not found. Retry!");

		alert.showAndWait();
	}
    
    public void recoveryData() {
    	
    	
    	if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

			sendUsernameAlert();

		} else if (emailField.getText() == null || emailField.getText().trim().isEmpty()) {

			sendEmailAlert();

		} else {
			
			usBean.setUsername(usernameField.getText());
			usBean.setEmail(emailField.getText());
			
			int res=ctrlRecoverData.sendEmail(usBean);
			if(res==1) {
				mailSentAlert();
			}
			else {
		
				sendDataNotFoundAlert();
			}

		}
   }
    
  //funzione che torna il log in
  	public void back () {
  		
  		try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 620, "Social Music");
		} catch (Exception e) {
			e.printStackTrace();
		}
  }
  	
  	
  	
    //Metodi per la gestione dei bottoni
  	
  	 @FXML
     public void RecoveryMouseClick() {recoveryData(); }
     
     @FXML
     public void backMouseClick() { back(); }

		
	

}
