package logic.patterns;

import logic.entity.AdminUser;
import logic.entity.User;
import logic.interfaces.IUser;

public class FactoryUser {
			
	public IUser createUser(int type) {
		
		switch (type) {
		
			case 0: 
				User user = new User();
				user.setFlag(type);
				return user;
			case 1: 
				
				AdminUser aUser = new AdminUser();
				aUser.setFlag(type);
				return aUser;
				
			default: return null;
			
		}
	
	}

}
