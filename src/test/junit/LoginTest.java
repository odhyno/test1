package test.junit;

//Monnati Leonardo
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.dao.UserDAO;
import logic.entity.User;

class LoginTest {

	@Test
	public void loginUserTest() {
		
		User user = new User();
		user.setEntityUsername("gino");
		user.setEntityPassword("gino");
		int output = UserDAO.checkIfRegistered(user);
		assertEquals(0,output);      //normaluser
		
	}
	
	@Test
	public void loginAdminTest() {
		
		User user = new User();
		user.setEntityUsername("admin");
		user.setEntityPassword("admin");
		int output = UserDAO.checkIfRegistered(user);
		assertEquals(1,output);      //adminuser
	
	}
	
	@Test
	public void loginErrorTest() {
		
		User user = new User();
		user.setEntityUsername("Falessi");
		user.setEntityPassword("DeAngelis");
		int output = UserDAO.checkIfRegistered(user);
		assertEquals(-1,output);
	}

}
