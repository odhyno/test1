package control;

import java.util.List;
import bean.UserBean;
import dao.UserDAO;
import entity.User;

public class ControlProfile {

	public UserBean getCurrentUserData(String username) {
		
		int i;
		UserBean userBean = new UserBean();
		List<User> userList = UserDAO.getUserList();
		
		for(i=0; i<userList.size(); i++) {
			
			if(userList.get(i).getUsername().equals(username)) {
				
				userBean.setUsername(userList.get(i).getUsername());
				userBean.setPassword(userList.get(i).getPassword()); //Sarebbe meglio di no
				userBean.setEmail(userList.get(i).getEmail());
				userBean.setFirstname(userList.get(i).getFirstname());
				userBean.setLastname(userList.get(i).getLastname());
				userBean.setSubsDate(userList.get(i).getSubsDate());
				userBean.setBirthDate(userList.get(i).getBirthDate());
				
			}
		}
		
		return userBean;
	}

	public int modifyCurrentUserProfile(UserBean user) {
		
		int i;
		List<User> userList = UserDAO.getUserList();
		
		int check = -1;
		
		for(i=0;i<userList.size();i++) {
			
			if(userList.get(i).getUsername().equals(user.getUsername())) {
				
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
			
			if(userList.get(i).getUsername().equals(user.getUsername())) {
				
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
		if(res<=0) {
			return false;
		}
		int rem= email.indexOf(".",res);
		if(rem<=0) {
			return false;
		}
		return true;
	}
}
