package boundary;

import bean.UserBean;
import controller.ControllerLogin;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;


/**
 *  Boundary che funge da controllore per LoginGUI.fxml
 *  @author Leonardo Monnati,Vicenzo Visconti,Alessandro Corsico
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

    private ControllerLogin controllerLogin;
    
    UserBean usBean = new UserBean();
    




    @FXML
    public void initialize()
    {
    	
        controllerLogin = ControllerLogin.getInstance();

    }

    public void sendUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public void sendPasswordAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: You didn't insert Password. Retry!");

		alert.showAndWait();
	}
	
	
	public void sendDataNotFoundAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: Data not found. Retry!");

		alert.showAndWait();
	}
    
    public void login ()  throws Exception
    {


			if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

				sendUsernameAlert();

			} else if (passwordField.getText() == null || passwordField.getText().trim().isEmpty()) {

				sendPasswordAlert();

			} else {
				
				 //setto lo UserBean
				usBean.setUsername(usernameField.getText());
				usBean.setPassword(passwordField.getText());
				
				//Chiamo il mio Controllore
				int res=controllerLogin.checkLogin(usBean);
				
				if(res==-1)
				{

					 sendDataNotFoundAlert();
					 return;
				}
					
				
				usBean.setType(res);
				getInstance().setLoggedUser(usBean); 
				System.out.println("qui 7 "+ usBean.getUsername());
					//requestNewStage.setLoggedUser(usBean);
					//System.out.println("qui 7 " + requestNewStage.getLoggedUser().getUsername());
		        requestNewStage.setNewStage("HomePageGUI.fxml", 512, 512, "Social Music");
		        System.out.println("ok");
				
		
				 usernameField.setText("");
			     passwordField.setText("");
	
			}
    };
    
    
    
    public void register ()throws Exception {
    	  
    	  requestNewStage.setNewStage("RegisterGUI.fxml", 512, 512, "Social Music");
    	        System.out.println("ok register scene");
    }
    	 
     public void recovery ()throws Exception {
    	  
    	  requestNewStage.setNewStage("RecoverDataGUI.fxml", 512, 512, "Social Music");
    	        System.out.println("ok register scene");
     }


 

    //Metodi per la gestione dei bottoni

    @FXML
    public void proceedMouseEntered() { 
    	String style= "<font-style> RED"; 
    	loginBTN.setStyle(style);
    	
    
    }

    @FXML
    public void proceedMouseExited()
    {
    	String style= "<font-style> ORANGE"; 
    	loginBTN.setStyle(style);
    }

    @FXML
    public void proceedMousePressed() { 
    	
    	String style= " -fx-background-color: RED"; 
    	loginBTN.setStyle(style); 
    	
    }

    @FXML
    public void proceedMouseReleased()
    {
    	String style= " -fx-background-color: ORANGE"; 
    	loginBTN.setStyle(style);
    }

    @FXML
    public void proceedMouseClick() throws Exception { login(); }
    
    @FXML
    public void loginMouseClick() throws Exception { login(); }
    
    @FXML
    public void registerMouseClick() throws Exception { register(); }
    
    @FXML
    public void recoverMouseClick() throws Exception { recovery(); }


   

}
