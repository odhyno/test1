package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.bean.UserBean;
import logic.dao.UserDAO;

class LoginTest {

	@Test
	public void loginTest() {
		
		UserBean usBean = new UserBean();
		usBean.setUsername("gino");
		usBean.setPassword("gino");
		//usBean.setUsername("admin");
		//usBean.setPassword("admin");
		int output = UserDAO.checkIfRegistered(usBean);
		//assertEquals(1,output);      //adminuser
		assertEquals(0,output);      //normaluser
		
	}
	
	@Test
	public void loginErrorTest() {
		
		UserBean usBean = new UserBean();
		usBean.setUsername("prof");
		usBean.setPassword("prof");
		int output = UserDAO.checkIfRegistered(usBean);
		assertEquals(-1,output);
	}

}
