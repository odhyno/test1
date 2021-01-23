package utility;

import entity.AdminUser;
import entity.User;
import interfaces.IUser;

public class FactoryUser {
			
	public IUser createUser(int type) {
		
		switch (type) {
		
			case 0: 
				User user = new User();
				user.setFlag(type);
				System.out.println("qui2");
				return user;
			case 1: 
				
				AdminUser aUser = new AdminUser();
				aUser.setFlag(type);
				System.out.println("qui20");
				return aUser;
				
			default: return null;
			
		}
	
	}

}
