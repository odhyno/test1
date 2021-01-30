package logic.boundary;

import logic.bean.UserBean;
import logic.control.ControlLogin;
import logic.exceptions.EmptyPasswordException;
import logic.exceptions.EmptyUsernameException;
import logic.exceptions.LoginException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


/**
 *  Boundary che funge da controllore per LoginGUI.fxml
 *  @author Leonardo Monnati,Vincenzo Visconti, Alessandro Corsico
 *  @version 1.0
 */
public class LoginGUI extends WindowManager{
	
	@FXML
	private Button registerBTN;
	
	@FXML
	private Button googleLoginBTN;
	    
	@FXML
	private Button recoveryBTN;
	 
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;
    
    @FXML
	private Button loginBTN;
    
    
    



    
    @FXML
    public void initialize()
    {
    	
    	//we don't need to implement this one

    }

    
    public void login ()  
    {
    	try {
    		
    			ControlLogin controllerLogin = ControlLogin.getInstance();
    			UserBean usBean = new UserBean();
		        	
		        if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

		        	throw new EmptyUsernameException();

				} else if (passwordField.getText() == null || passwordField.getText().trim().isEmpty()) {

					throw new EmptyPasswordException();

				} else {
						
					 //setto lo UserBean
					usBean.setUsername(usernameField.getText());
					usBean.setPassword(passwordField.getText());
					
					//Chiamo il mio Controllore
					int res=controllerLogin.checkLogin(usBean);
						
					if(res==-1)
					{

						throw new LoginException();
						
					}
							
						
					usBean.setType(res);
					getInstance().setLoggedUser(usBean);
				    requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
				       
						
				
					 usernameField.setText("");
					 passwordField.setText("");
					 	 
					 
				}
    	} catch( EmptyUsernameException e)
    	{
    		e.printStackTrace();
		  
    	} catch(EmptyPasswordException e1)
    	{
    		e1.printStackTrace();
    		
    	} catch( LoginException e2)
    	{
    		e2.printStackTrace();
    		
		} catch (Exception e3) 
		{	
			e3.printStackTrace();
		}
			
    }
    
    public void googleLogin() {
    	
    	try {
    		
    		ControlLogin controlLogin = ControlLogin.getInstance();
	    	UserBean usBean = controlLogin.checkIfGoogleRegistered();
	    	getInstance().setLoggedUser(usBean);
	    	if(usBean.getType()==-1) {
	    		
	    		requestNewStage.setNewStage("RegisterGUI.fxml", 512, 512, socialMusic);
	    		
	    	}else {
	    		
	    	    requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, socialMusic);
	        	
	    	}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
	    	
    	
    }
    
    
    
    public void register () {
    	  
    	  try {
			requestNewStage.setNewStage("RegisterGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	       
    }
    	 
     public void recovery () {
    	  
    	  try {
			requestNewStage.setNewStage("RecoverDataGUI.fxml", 512, 512, socialMusic);
		} catch (Exception e) {
			e.printStackTrace();
		}
     }


 

    //Metodi per la gestione dei bottoni

  

    @FXML
    public void proceedMouseClick() { login(); }
    
    @FXML
    public void loginMouseClick() { login(); }
    
    @FXML
    public void registerMouseClick() { register(); }
    
    @FXML
    public void recoverMouseClick()  { recovery(); }
    
    @FXML
    public void googleLoginClick()  { googleLogin(); }


   

}
