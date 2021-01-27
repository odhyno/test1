package application;

import java.io.IOException;

//import bean.UserBean;
import boundary.WindowManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application implements RequestScene{
	
	 protected Stage stage;
	// private UserBean loggedUser = null;
	// private List<UserBean> loggedusers = null;

	    @Override
	    public void start(Stage stage) throws Exception
	    {
	        this.stage = stage;
	    
			setNewStage("LoginGUI.fxml", 512, 512, "SocialMusic");
	      
	    }

	


	public static void main(String[] args) {
		
		 launch(args);

	}
	
	 @Override
	    public void setNewStage(String fxmlFile, int sizeX, int sizeY, String title) 
	    {
	        
			try {
				FXMLLoader fxmlLoader = new FXMLLoader();
		        fxmlLoader.setLocation(getClass().getResource("../boundary/" + fxmlFile));
		        Parent root = fxmlLoader.load();

		        stage.setTitle(title);
		        stage.setScene(new Scene(root, sizeX, sizeY));
		        ((WindowManager) fxmlLoader.getController()).setInterface(this);
		        stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}  

	    }

}
