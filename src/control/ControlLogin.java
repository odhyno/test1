package control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;
import bean.UserBean;
import dao.NotifyDAO;
import dao.LoginDAO;
import utility.MailSender;


/**
 *  Controller per il Login 
 *  La classe è un Singleton.
 *  @author Leonardo Monnati,Vincenzo Visconti,Alessandro Corsico
 *  @version 1.0
 */
public class ControlLogin 
{

    private static ControlLogin instance = null;
    
    private ControlLogin()
    {
    	
    }

    //Singleton
    
    public static ControlLogin getInstance()
    {

        if (instance == null) {

            instance = new ControlLogin();

        }

        return instance;

    }

    public int checkLogin(UserBean loginUser)
    {
    	
    	return LoginDAO.checkIfRegistered(loginUser);
    }
    
    
    //funzione che chiama la DAO per il check username
    
    public String checkUsernameAlreadyTaken(String username) {

    	
    	return LoginDAO.checkUsernameAlreadyTaken(username);
	}

    
    //funzione che converte la data in stringa e chiama la DAO per il register
    
    public void registerUser(UserBean usBean) {
		

		String subsDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
		
		usBean.setSubsDate(subsDate);

		LoginDAO.registerUser(usBean);
		NotifyDAO.inizializeNotify(usBean.getUsername());
		
	}
    
    
    
    
    //funzione che verifica se la mail da inserire è valida
    
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
		password = LoginDAO.checkEmail(usBean);
		
		if(password != null) {
			
			MailSender ms = new MailSender();
			ms.sendMail(usBean.getEmail(), usBean.getUsername(), password);
			return 1;
			
		} 
		
		return 0;
		
	}
}
