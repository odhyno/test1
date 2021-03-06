package logic.utility;


import logic.bean.MessageBean;
import logic.bean.UserBean;
import logic.interfaces.RequestScene;

public class WindowManager {
	
	protected static WindowManager instance= null;
	protected RequestScene requestNewStage;
	protected UserBean loggedUser;
	protected static String socialMusic = "Social Music";
	protected MessageBean message;
	protected static int cmd = -1;
	
	protected static int type;
	
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
    
    public MessageBean getMessage()
   	{ 
   		return message;
   	}
       
       
       public void setMessage(MessageBean message) 
       { 
       	this. message =  message;
       }

}
