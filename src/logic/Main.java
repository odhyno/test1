package logic;

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
	    public void setNewStage(String fxmlFile, int sizeX, int sizeY, String title) throws Exception
	    {
	        FXMLLoader fxmlLoader = new FXMLLoader();
	        System.out.println("ok 1");
	        fxmlLoader.setLocation(getClass().getResource("../boundary/" + fxmlFile));
	        System.out.println("ok 2");
	        Parent root = fxmlLoader.load();
	        System.out.println("ok 3");

	        stage.setTitle(title);
	        System.out.println("ok");
	        stage.setScene(new Scene(root, sizeX, sizeY));
	        System.out.println("ok");
	        ((WindowManager) fxmlLoader.getController()).setInterface(this);
	        System.out.println("ok");
	        stage.show();

	    }
/*
	 @Override
	    public void setLoggedUser(UserBean beanBackOfficeUser)
	    {
		   
	        this.loggedUser = beanBackOfficeUser;
	    }
	 
	 @Override
	    public UserBean getLoggedUser() {
	        return loggedUser;
	    }
*/
	/* @Override
	    public void setLoggedUsers(UserBean beanBackOfficeUser)
	    {
		    loggedusers = getLoggedUsers();
	        this.loggedusers.add(beanBackOfficeUser) ;
	    }

	 
	    
	  @Override
	    public List<UserBean> getLoggedUsers() {
	    	
	    	if(loggedusers != null) {
	    		
	    		return loggedusers;
	    	}
			return new ArrayList<UserBean>();
	    
	    }*/
}
