package logic.actors;

import java.util.Date;

public class AdminUser extends User{
	
	public AdminUser(int idUtente, String username, String password, String email, String firstname, String lastname,
			Date subsDate, Date birthDate, String zone, String instrPlayed, Boolean band, String nameBand) {
		super(idUtente, username, password, email, firstname, lastname, subsDate, birthDate, zone, instrPlayed, band, nameBand);
	}

	public void writeRules() {
		
	}

	public void moderateUsers() {
		
	}

}
