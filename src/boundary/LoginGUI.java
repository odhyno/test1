package boundary;

import bean.UserBean;
import control.ControlLogin;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import utility.EmptyPasswordException;
import utility.EmptyUsernameException;
import utility.LoginException;


/**
 *  Boundary che funge da controllore per LoginGUI.fxml
 *  @author Leonardo Monnati,Vincenzo Visconti, Alessandro Corsico
 *  @version 1.0
 */
public class LoginGUI extends WindowManager{
	
	@FXML
	private Button registerBTN;
	    
	@FXML
	private Button recoveryBTN;
    
	@FXML
	private Rectangle rectangle;
	 
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

 /*   public void sendUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Empty username");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public void sendPasswordAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Empty password");
		alert.setContentText("Error: You didn't insert Password. Retry!");

		alert.showAndWait();
	}
	
	
	public void sendDataNotFoundAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(socialMusic);
		alert.setHeaderText("Error login");
		alert.setContentText("Error: Data not found. Retry!");

		alert.showAndWait();
	}
 */   
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
		  
		  
    	} catch(EmptyPasswordException e1)
    	{
    		System.out.println(e1.getMessage());
    		
    	} catch( LoginException e2)
    	{
    		
		} catch (Exception e3) 
		{	
			e3.printStackTrace();
		}
		       
				
		
				 usernameField.setText("");
			     passwordField.setText("");
	
			
    }
    
    
    
    public void register () {
    	  
    	  try {
			requestNewStage.setNewStage("RegisterGUI.fxml", 512, 620, socialMusic);
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


   

}
