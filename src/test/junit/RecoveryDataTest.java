package test.junit;

//Monnati Leonardo
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import logic.bean.UserBean;
import logic.control.ControlLogin;

class RecoveryDataTest {
	
	
	@Test
	public void recoveryDataTest() {
		
		
		ControlLogin ctrlRecoverData = ControlLogin.getInstance();
    	UserBean usBean = new UserBean();
    	
    	usBean.setUsername("leo");
		usBean.setEmail("leonardo.monnati@gmail.com");
		
		int output=ctrlRecoverData.sendEmail(usBean);
		
		assertEquals(1, output);
	}

	
	
	@Test
	public void recoveryDataErrorTest() {
		
		
		ControlLogin ctrlRecoverData = ControlLogin.getInstance();
    	UserBean usBean = new UserBean();
    	
    	usBean.setUsername("trilli");
		usBean.setEmail("leonardo.monnati@gmail.com");
		
		int output=ctrlRecoverData.sendEmail(usBean);
		
		assertEquals(0, output);
	}

}
