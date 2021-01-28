package logic.boundary;

import logic.bean.UserBean;
import logic.control.ControlLogin;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

/*
*  Boundary che funge da controllore per RegistGUI.fxml
*  @author Leonardo Monnati,Vicenzo Visconti,Alessandro Corsico
*  @version 1.0
*/


public class RegisterGUI extends WindowManager {

	 
    @FXML
    private TextField usernameField;
    
    @FXML
    private TextField passwordField;

    @FXML
    private TextField emailField;
    
    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;
    
    @FXML
	private DatePicker birthDateField;
    
    @FXML
	private Button registBTN;
    
    @FXML
	private Button backBTN;
    
    @FXML
   	private Pane pane;
       
    
    @FXML
    public void initialize()
    {	
        birthDateField.setEditable(false);
    }
    
    
    public void sendRegisterUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Empty username");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public void sendRegisterPasswordAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Empty password");
		alert.setContentText("Error: You didn't insert Password. Retry!");

		alert.showAndWait();
	}

	public void sendEmailRegisterAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Empty Email");
		alert.setContentText("Error: You didn't insert Email. Retry!");

		alert.showAndWait();
	}
	
	public void sendBirthDateAlert() {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Empty birthdate");
		alert.setContentText("Error: You didn't insert BirthDate. Retry!");

		alert.showAndWait();		
	}

	public void sendFirstNameRegisterAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Empty firstname");
		alert.setContentText("Error: You didn't insert First Name. Retry!");

		alert.showAndWait();
	}

	public void sendEmailNotValidRegisterAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Not valid Email");
		alert.setContentText("Error: Email format not valid. Retry!");

		alert.showAndWait();
	}

	public void sendUsernameAlreadyTakenRegisterAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Error username");
		alert.setContentText("Error: Username already in use. Retry!");

		alert.showAndWait();
	}

	public void sendEmailAlreadyTakenRegisterAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Error Email");
		alert.setContentText("Error: Email already in use. Retry!");

		alert.showAndWait();
	}

	public void registrationAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Registration");
		alert.setContentText("Success! Your Account has been registrated!");

		alert.showAndWait();
	}
	
	
	//funzione che torna il log in
	public void back () {
		
		try {
			requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
    
	// funzione che registra l utente
    public void register () {
    	
    	ControlLogin controllerRegist = ControlLogin.getInstance();
    					
		try {
	    	if (usernameField.getText().trim().isEmpty()) {

				sendRegisterUsernameAlert();

			} else if (passwordField.getText().trim().isEmpty()) {

				sendRegisterPasswordAlert();

			} else if (emailField.getText().trim().isEmpty()) {

				sendEmailRegisterAlert();
				
			} else if (birthDateField.getValue().toString().trim().isEmpty()) {

				sendBirthDateAlert();

			} else if (firstNameField.getText().trim().isEmpty()) {

				sendFirstNameRegisterAlert();

			} else if (!controllerRegist.checkIfEmailIsValid(emailField.getText())) {

				sendEmailNotValidRegisterAlert();
				emailField.clear();

			}else {
				
				String result =controllerRegist.checkUsernameAlreadyTaken(usernameField.getText());

				if (result.equals("trovato")) {

					sendUsernameAlreadyTakenRegisterAlert();
					usernameField.clear();

				} else {
					
					UserBean usBean = new UserBean();
					
					usBean.setUsername(usernameField.getText());
					usBean.setPassword(passwordField.getText());
					usBean.setEmail(emailField.getText());
					usBean.setFirstname(firstNameField.getText());
					
					if(lastNameField.getLength()>0) {
						
						usBean.setLastname(lastNameField.getText());
					} else {
						
						usBean.setLastname(null);
					}
					
					usBean.setBirthDate(birthDateField.getValue().toString());
					controllerRegist.registerUser(usBean);
					
					registrationAlert();

					usernameField.clear();
					passwordField.clear();
					emailField.clear();
					firstNameField.clear();
					lastNameField.clear();
					birthDateField.setValue(null);
					
					requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, socialMusic);
					
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				
    }

    @FXML
    public void registClick() { register(); }
    
    @FXML
    public void backClick()  { back(); }
    
    
}
