package logic.boundary;

import logic.bean.UserBean;
import logic.control.ControlLogin;
import logic.exceptions.EmptyDateException;
import logic.exceptions.EmptyEmailException;
import logic.exceptions.EmptyFirstNameException;
import logic.exceptions.EmptyPasswordException;
import logic.exceptions.EmptyUsernameException;
import logic.exceptions.NotValidEmailException;
import logic.exceptions.UsernameAlreadyTakenException;
import logic.utility.WindowManager;
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
    	UserBean usBean = getInstance().getLoggedUser();
        birthDateField.setEditable(false);
        
        if(usBean!=null) {
        	firstNameField.setText(usBean.getFirstname());
        	firstNameField.setEditable(false);
        	emailField.setText(usBean.getEmail());
        	emailField.setEditable(false);
        	lastNameField.setText(usBean.getLastname());
        	lastNameField.setEditable(false);
        }
        
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
    public void register ()  {
    					
		try {
			
			if(checkEmptyFields()==1) {
				
			
			
				ControlLogin controllerRegist = ControlLogin.getInstance();
	/*			
		    	if (usernameField.getText().trim().isEmpty()) {
	
		    		throw new EmptyUsernameException();
	
				} else if (passwordField.getText().trim().isEmpty()) {
	
					throw new EmptyPasswordException();
					
				} else if (emailField.getText().trim().isEmpty()) {
	
					throw new EmptyEmailException();
					
				} else if (birthDateField.getValue() == null) {
	
					throw new EmptyDateException();
					
				} else if (firstNameField.getText().trim().isEmpty()) {
	
					throw new EmptyFirstNameException();
	
				} else if (!controllerRegist.checkIfEmailIsValid(emailField.getText())) {
	*/			
				if (!controllerRegist.checkIfEmailIsValid(emailField.getText())) {
		
					emailField.clear();
					throw new NotValidEmailException();
	
				}else {
					
					String result =controllerRegist.checkUsernameAlreadyTaken(usernameField.getText());
	
					if (result.equals("trovato")) {
						
						usernameField.clear();
						throw new UsernameAlreadyTakenException();
						
	
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

			}
/*		} catch (EmptyUsernameException e) {
			e.printStackTrace();
		} catch (EmptyPasswordException e1) {
			e1.printStackTrace();
		} catch (EmptyEmailException e2) {
			e2.printStackTrace();
		} catch (EmptyDateException e3) {
			e3.printStackTrace();
		} catch (EmptyFirstNameException e4) {   
			e4.printStackTrace();                           */
		} catch (NotValidEmailException e5) {
			e5.printStackTrace();
		} catch (UsernameAlreadyTakenException e6) {
			e6.printStackTrace();
		}
				
    }
    
    public int checkEmptyFields() {
    	
    	int res = 1;
    	
    	try {
    	
	    	if (usernameField.getText().trim().isEmpty()) {
	    		res= -1;
	    		throw new EmptyUsernameException();
	
			} else if (passwordField.getText().trim().isEmpty()) {
				res= -1;
				throw new EmptyPasswordException();
				
			} else if (emailField.getText().trim().isEmpty()) {
				res= -1;
				throw new EmptyEmailException();
				
			} else if (birthDateField.getValue() == null) {
				res= -1;
				throw new EmptyDateException();
				
			} else if (firstNameField.getText().trim().isEmpty()) {
				res= -1;
				throw new EmptyFirstNameException();
			}
	    	
	    	return res;
	    	
    	} catch (EmptyUsernameException e) {
			e.printStackTrace();
			return res;
		} catch (EmptyPasswordException e1) {
			e1.printStackTrace();
			return res;
		} catch (EmptyEmailException e2) {
			e2.printStackTrace();
			return res;
		} catch (EmptyDateException e3) {
			e3.printStackTrace();
			return res;
		} catch (EmptyFirstNameException e4) {
			e4.printStackTrace();
			return res;
		}
    }

    @FXML
    public void registClick() { register(); }
    
    @FXML
    public void backClick()  { back(); }
    
    
}
