package logic.boundary;

import logic.bean.UserBean;
import logic.control.ControlLogin;
import logic.exceptions.EmailNotFoundException;
import logic.exceptions.EmptyEmailException;
import logic.exceptions.EmptyUsernameException;
import logic.utility.WindowManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class RecoverDataGUI extends WindowManager {
	
	 
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
    
	public void mailSentDataAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);		
		alert.setTitle(socialMusic);		
		alert.setHeaderText("Recover  Data");		
		alert.setContentText("Success! Your Data has been sent at your email!");
		alert.showAndWait();
	}
  
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
					mailSentDataAlert();
				}
				else {
			
					throw new EmailNotFoundException();
				}
	
			}
    	
    	
    	} catch (EmptyUsernameException e) {
    		e.printStackTrace();
    	} catch (EmptyEmailException e1 ) {
    		e1.printStackTrace();
    	} catch (EmailNotFoundException e2) {
    		e2.printStackTrace();
    	}catch (Exception e3) {
    		e3.printStackTrace();
    	}
   }
    
  //funzione che torna il log in
  	public void back () {
  		
  		try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
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
