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
    	//isLoaded = false;
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
    
    public void recoveryData()throws Exception {
    	
    	System.out.println("stamo3");
    	
    	if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

			sendUsernameAlert();

		} else if (emailField.getText() == null || emailField.getText().trim().isEmpty()) {

			sendEmailAlert();

		} else {
			
			System.out.println("stamo4");
			
			usBean.setUsername(usernameField.getText());
			
			System.out.println("stamo5");
			usBean.setEmail(emailField.getText());
			
			System.out.println("stamo6");

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
  	public void back ()throws Exception {
  		
  		requestNewStage.setNewStage("LoginGUI.fxml", 512, 620, "Social Music");
  }
  	
  	
  	
    //Metodi per la gestione dei bottoni
  	
  	 @FXML
     public void RecoveryMouseClick() throws Exception {recoveryData(); }
     
     @FXML
     public void backMouseClick() throws Exception { back(); }

		
	

}
