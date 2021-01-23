package boundary;


import bean.UserBean;
import logic.RequestScene;

public class WindowManager {
	
	protected static WindowManager instance= null;
	protected RequestScene requestNewStage;
	protected UserBean loggedUser;
	 
	//protected boolean isLoaded;

//	@FXML
//	  public abstract void finishedLoading();
	
	 public static WindowManager getInstance()
	    {

	        if (instance == null) {

	            instance = new WindowManager();

	        }

	        return instance;

	    }
	
	public UserBean getLoggedUser()
	{ 
		return loggedUser;
	}
    public void setLoggedUser(UserBean loggedUser) 
    { 
    	this.loggedUser = loggedUser;
    }

	public  void setInterface(RequestScene requestNewStage)
	{ 
		this.requestNewStage = requestNewStage; 
	}
	
    public RequestScene getInterface()
    {
    	return requestNewStage; 
    }
}
