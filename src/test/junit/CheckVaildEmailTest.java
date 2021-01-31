package test.junit;

//Visconti Vincenzo
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.control.ControlLogin;


class CheckVaildEmailTest {

	@Test
	public void validEmailTest() {
		
		ControlLogin ctrlRegister = ControlLogin.getInstance();
		
		boolean output = ctrlRegister.checkIfEmailIsValid("gino@gino.gino");
		
		assertEquals(true,output);
	}
	
	@Test
	public void notValidEmailTest() {
		
		ControlLogin ctrlRegister = ControlLogin.getInstance();
		
		boolean output = ctrlRegister.checkIfEmailIsValid("prova.prova.prova");
		
		assertEquals(false,output);
	}

}
