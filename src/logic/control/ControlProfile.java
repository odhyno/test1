package logic.control;

import java.util.List;
import logic.bean.UserBean;
import logic.dao.UserDAO;
import logic.entity.User;

public class ControlProfile {
	
	 private static ControlProfile instance = null;
	    
	
	 public static ControlProfile getInstance()
	    {

	        if (instance == null) {

	            instance = new ControlProfile();

	        }

	        return instance;

	    }

	public UserBean getCurrentUserData(String username) {
		
		int i;
		UserBean userBean = new UserBean();
		List<User> userList = UserDAO.getUserList();
		
		for(i=0; i<userList.size(); i++) {
			
			if(userList.get(i).getEntityUsername().equals(username)) {
				
				userBean.setUsername(userList.get(i).getEntityUsername());
				userBean.setPassword(userList.get(i).getEntityPassword()); //Sarebbe meglio di no
				userBean.setEmail(userList.get(i).getEntityEmail());
				userBean.setFirstname(userList.get(i).getEntityFirstname());
				userBean.setLastname(userList.get(i).getEntityLastname());
				userBean.setSubsDate(userList.get(i).getEntitySubsDate());
				userBean.setBirthDate(userList.get(i).getEntityBirthDate());
				
			}
		}
		
		return userBean;
	}

	public int modifyCurrentUserProfile(UserBean user) {
		
		int i;
		List<User> userList = UserDAO.getUserList();
		
		int check = -1;
		
		for(i=0;i<userList.size();i++) {
			
			if(userList.get(i).getEntityUsername().equals(user.getUsername())) {
				
				UserDAO.modifyProfile(user);
				check = 1;
			}
		}
		
		return check;
		
	}
	
		public int modifyCurrentUserData(UserBean user) {
		
		int i;
		List<User> userList = UserDAO.getUserList();
		
		int check = -1;
		
		for(i=0;i<userList.size();i++) {
			
			if(userList.get(i).getEntityUsername().equals(user.getUsername())) {
				
				UserDAO.modifyData(user);
				check = 1;
			}
		}
		
		return check;
		
	}
	
	
	
	public boolean checkIfEmailIsValid(String email) {
		
		if (email == null)
    		return false;
    		

		int res= email.indexOf("@");
		return res>0 && email.indexOf(".",res)>0;
		
	}
}
