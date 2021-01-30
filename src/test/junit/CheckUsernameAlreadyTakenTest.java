package test.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.control.ControlLogin;


class CheckUsernameAlreadyTakenTest {

	@Test
	public void checkUserAlreadyTaken() {
		
		
		ControlLogin ctrlRegister = ControlLogin.getInstance();
		
		String output = ctrlRegister.checkUsernameAlreadyTaken("gino");
		
		assertEquals("trovato", output); //username already taken
		
	}
	
	@Test
	public void checkUserNotTaken() {
		
		ControlLogin ctrlRegister = ControlLogin.getInstance();
		
		String output = ctrlRegister.checkUsernameAlreadyTaken("pippo");
		
		assertEquals("non trovato", output); //username free
	}

}
