package boundary;

import bean.UserBean;
import controller.ControllerLogin;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;


/*
*  Boundary che funge da controllore per RegistGUI.fxml
*  @author Leonardo Monnati,Vicenzo Visconti,Alessandro Corsico
*  @version 1.0
*/


public class RegisterGUI extends WindowManager {

	@FXML
	private Rectangle rectangle;
	 
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
    private TextField zoneField;

    @FXML
    private TextField instrumentField;
    
    @FXML
    private TextField nameBandField;
    
    @FXML
   	private CheckBox bandCheckBox;
    
    @FXML
	private DatePicker birthDateField;
    
    @FXML
	private Button registBTN;
    
    @FXML
	private Button backBTN;
    
    @FXML
   	private Pane pane;
    
    private int checkBox;
       
    
    

    private ControllerLogin controllerRegist;
    
    @FXML
    public void initialize()
    {
    	
    	//isLoaded = false;
        controllerRegist = ControllerLogin.getInstance();
        birthDateField.setEditable(false);
        nameBandField.setVisible(false);
    }
    
    
    public void sendUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public void sendPasswordAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert Password. Retry!");

		alert.showAndWait();
	}

	public void sendEmailAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert Email. Retry!");

		alert.showAndWait();
	}
	
	public void sendBirthDateAlert() {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert BirthDate. Retry!");

		alert.showAndWait();		
	}

	public void sendFirstNameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert First Name. Retry!");

		alert.showAndWait();
	}

	public void sendInstrPlayedAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert the Instrument Played. Retry!");

		alert.showAndWait();
	}

	public void sendNameBandAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: You didn't insert Name of your Band. Retry!");

		alert.showAndWait();
	}

	public void sendEmailNotValidAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: Email format not valid. Retry!");

		alert.showAndWait();
	}

	public void sendUsernameAlreadyTakenAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: Username already in use. Retry!");

		alert.showAndWait();
	}

	public void sendEmailAlreadyTakenAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration Error");
		alert.setContentText("Error: Email already in use. Retry!");

		alert.showAndWait();
	}

	public void registrationAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Registration");
		alert.setContentText("Success! Your Account has been registrated!");

		alert.showAndWait();
	}
	
	
	// funzione che rende visibile il campo "Name Band" dopo aver premuto il checkBox se era invisibile e viceversa
	public void nameBandVisible ()throws Exception {
		
			if(checkBox == 0) {
				
				nameBandField.setVisible(true);
				checkBox=1;
			}
			else{
				
				nameBandField.setVisible(false);
				checkBox=0;
			}
	}
	
	
	//funzione che torna il log in
	public void back ()throws Exception {
		
		requestNewStage.setNewStage("LoginGUI.fxml", 512, 512, "Social Music");
}
	
    
	// funzione che registra l utente
    public void register ()throws Exception {
    	
    	
    	if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

			sendUsernameAlert();

		} else if (passwordField.getText() == null || passwordField.getText().trim().isEmpty()) {

			sendPasswordAlert();

		} else if (emailField.getText() == null || emailField.getText().trim().isEmpty()) {

			sendEmailAlert();
			
		} else if (birthDateField.getValue() == null || birthDateField.getValue().toString().trim().isEmpty()) {

			sendBirthDateAlert();

		} else if (firstNameField.getText() == null || firstNameField.getText().trim().isEmpty()) {

			sendFirstNameAlert();

		} else if (instrumentField.getText() == null || instrumentField.getText().trim().isEmpty()) {

			sendInstrPlayedAlert();

		} else if (bandCheckBox.isSelected() && nameBandField.getText().equals("")) {

			sendNameBandAlert();

		} else if (!controllerRegist.checkIfEmailIsValid(emailField.getText())) {

			sendEmailNotValidAlert();
			emailField.clear();

		} else {

			int bandFlag = -1;

			if (bandCheckBox.isSelected() && !nameBandField.getText().equals("")) {

				bandFlag = 1;

			} else {

				bandFlag = 0;

			}
			
			String result =controllerRegist.checkUsernameAlreadyTaken(usernameField.getText());

			if (result.equals("trovato")) {

				sendUsernameAlreadyTakenAlert();
				usernameField.clear();

			} else {
				
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
				
				if(zoneField.getLength()>0) {
					
					usBean.setZone(zoneField.getText());
					
				} else {
					
					usBean.setZone(null);
				}
				
				usBean.setInstrPlayed(instrumentField.getText());
				usBean.setBand(bandFlag);
				if (bandFlag == 1) {
					usBean.setNameBand(nameBandField.getText());
				} else if (bandFlag == 0) {
					usBean.setNameBand(null);
				}

				controllerRegist.registerUser(usBean);
				
				registrationAlert();

				usernameField.clear();
				passwordField.clear();
				emailField.clear();
				firstNameField.clear();
				lastNameField.clear();
				birthDateField.setValue(null);
				zoneField.clear();
				instrumentField.clear();
				bandCheckBox.setSelected(false);
				nameBandField.clear();
				
				requestNewStage.setNewStage("LoginGUI.fxml", 512, 620, "Social Music");
				
			}

		}
	}
    
    
    UserBean usBean = new UserBean();
    
    
    @FXML
    public void registClick() throws Exception { register(); }
    
    @FXML
    public void checkBoxClick() throws Exception { nameBandVisible(); }
    
    @FXML
    public void backClick() throws Exception { back(); }
    
    
}
