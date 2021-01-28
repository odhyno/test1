package boundary;

import bean.UserBean;
import control.ControlLogin;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Rectangle;
import utility.EmailNotFoundException;
import utility.EmptyEmailException;
import utility.EmptyUsernameException;

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

 /*   public void sendUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Empty username");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public void sendEmailAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Empty Email");
		alert.setContentText("Error: You didn't insert Email. Retry!");

		alert.showAndWait();
	}
*/
	public void mailSentAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Recover Data");
		alert.setContentText("Success! Your Data has been sent at your email!");

		alert.showAndWait();
	}
/*
	public void sendDataNotFoundAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: Email not found. Retry!");

		alert.showAndWait();
	}
*/    
    public void recoveryData() {
    	
    	
    	
    	try {
    		
    		ControlLogin ctrlRecoverData = ControlLogin.getInstance();
        	UserBean usBean = new UserBean();
    		
    		if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {
    			
				throw new EmptyUsernameException();
	
			} else if (emailField.getText() == null || emailField.getText().trim().isEmpty()) {
	
				throw new EmptyEmailException();
	
			} else {
				
				usBean.setUsername(usernameField.getText());
				usBean.setEmail(emailField.getText());
				
				int res=ctrlRecoverData.sendEmail(usBean);
				if(res==1) {
					mailSentAlert();
				}
				else {
			
					throw new EmailNotFoundException();
				}
	
			}
    		
    	} catch (EmptyUsernameException e1) {
    		
    	} catch (EmptyEmailException e2 ) {
    		
    	} catch (EmailNotFoundException e3) {
    		
    	}catch (Exception e4) {
			 e4.printStackTrace();
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
