package test.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import logic.bean.UserBean;
import logic.control.ControlProfile;

class ModifyCurrentUserProfileTest {
	
	@Test
	public void modifyCurrentUserProfile() {
		
		ControlProfile ctrlProfile = ControlProfile.getInstance();
		UserBean userBean = new UserBean();
		
		userBean.setUsername("Utente test");
		userBean.setFirstname("Modified name");
		userBean.setLastname("Modified surname");
		userBean.setBirthDate("2000-10-10");
		
		int output = ctrlProfile.modifyCurrentUserProfile(userBean);
		
		assertEquals(1, output);
	}
	
	@Test
	public void modifyCurrentUserData() {
		
		ControlProfile ctrlProfile = ControlProfile.getInstance();
		UserBean userBean = new UserBean();
		
		userBean.setUsername("Utente test");
		userBean.setPassword("Modified Password");
		userBean.setEmail("Modified@Email.com");
		
		int output = ctrlProfile.modifyCurrentUserData(userBean);
		
		assertEquals(1, output);
	}
	
}
