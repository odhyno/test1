package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;
import bean.UserBean;
import dao.DAOLogin;
import utility.MailSender;


/**
 *  Controller per il Login 
 *  La classe � un Singleton.
 *  @author Leonardo Monnati,Vincenzo Visconti,Alessandro Corsico
 *  @version 1.0
 */
public class ControllerLogin 
{

    private static ControllerLogin instance = null;
    
    private ControllerLogin()
    {
    	
    }

    //Singleton
    
    public static ControllerLogin getInstance()
    {

        if (instance == null) {

            instance = new ControllerLogin();

        }

        return instance;

    }

    public int checkLogin(UserBean loginUser)
    {
        //Inizializzo il BackOfficeUser
    	//int type = DAOLogin.checkIfRegistered(loginUser);
    	
	//	FactoryUser factory = new FactoryUser();
	
		//IUser user = factory.createUser(type);
		
		    	
    	//return type;
    	
    	return DAOLogin.checkIfRegistered(loginUser);
    }
    
    
    //funzione che chiama la DAO per il chech username
    
    public String checkUsernameAlreadyTaken(String username) {

		//String result = DAOLogin.checkUsernameAlreadyTaken(username);

		//return result;
    	
    	return DAOLogin.checkUsernameAlreadyTaken(username);
	}

    
    //funzione che converte la data in stringa e chiama la DAO per il register
    
    public void registerUser(UserBean usBean) {
		

		String subsDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
		
		usBean.setSubsDate(subsDate);

		DAOLogin.registerUser(usBean);
		
	}
    
    
    
    
    //funzione che verifica se la mail da inserire � valida
    
    public boolean checkIfEmailIsValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
    
    
    //funzione che invia una email
    
    public int sendEmail(UserBean usBean) {
		
		String password;
		password = DAOLogin.checkEmail(usBean);
		
		if(password != null) {
			
			MailSender ms = new MailSender();
			ms.sendMail(usBean.getEmail(), usBean.getUsername(), password);
			return 1;
			
		} 
		
		return 0;
		
	}
}
