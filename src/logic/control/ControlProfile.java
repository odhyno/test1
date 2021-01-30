package logic.control;

import java.util.List;
import logic.bean.UserBean;
import logic.entity.User;
import logic.patterns.FacadeDAO;

public class ControlProfile {
	
	 private static ControlProfile instance = null;
	 
	 private ControlProfile() {
		 
	 }
	 
	//singleton
	 public static ControlProfile getInstance()
	    {

	        if (instance == null) {

	            instance = new ControlProfile();

	        }

	        return instance;

	    }

	 //funzione che ritorna il profilo dell'utente corrente
	public UserBean getCurrentUserData(String username) {
		
		int i;
		UserBean userBean = new UserBean();
		
		List<User> userList = new FacadeDAO().getUserList();
		
		for(i=0; i<userList.size(); i++) {
			
			if(userList.get(i).getEntityUsername().equals(username)) {
				
				userBean.setUsername(userList.get(i).getEntityUsername());
				userBean.setEmail(userList.get(i).getEntityEmail());
				userBean.setFirstname(userList.get(i).getEntityFirstname());
				userBean.setLastname(userList.get(i).getEntityLastname());
				userBean.setSubsDate(userList.get(i).getEntitySubsDate());
				userBean.setBirthDate(userList.get(i).getEntityBirthDate());
				
			}
		}
		
		return userBean;
	}

	//funzione che modifica il profilo dell'utente corrente
	public int modifyCurrentUserProfile(UserBean usBean) {
		
		int i;
		List<User> userList = new FacadeDAO().getUserList();
		
		int check = -1;
		
		for(i=0;i<userList.size();i++) {
			
			if(userList.get(i).getEntityUsername().equals(usBean.getUsername())) {
				
				User user = new User(); 
				user.setEntityUsername(usBean.getUsername());
				user.setEntityFirstname(usBean.getFirstname());
				user.setEntityLastname(usBean.getLastname());
				user.setEntityBirthDate(usBean.getBirthDate());
				
				check = new FacadeDAO().modifyProfile(user);
			
			}
		}
		
		return check;
		
	}
	
	//funzione che modifica i dati dell'utente corrente
		public int modifyCurrentUserData(UserBean usBean) {
		
		int i;
		List<User> userList = new FacadeDAO().getUserList();
		
		int check = -1;
		
		for(i=0;i<userList.size();i++) {
			
			if(userList.get(i).getEntityUsername().equals(usBean.getUsername())) {
				
				User user = new User(); 
				user.setEntityUsername(usBean.getUsername());
				user.setEntityPassword(usBean.getPassword());
				user.setEntityEmail(usBean.getEmail());
				
				check = new FacadeDAO().modifyData(user);
			}
		}
		
		return check;
		
	}
	
	
	//funzione che controlla se l'email inserita è valida
	public boolean checkIfEmailIsValid(String email) {
		
		if (email == null)
    		return false;
    		

		int res= email.indexOf("@");
		return res>0 && email.indexOf(".",res)>0;
		
	}
}
