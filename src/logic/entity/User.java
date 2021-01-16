package logic.entity;

import logic.interfaces.IUser;

public class User implements IUser {

	private int idUtente;
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	private String subsDate;
	private String birthDate;
	private String zone;
	private String instrPlayed;
	private int band;
	private String nameBand;
	private int flag;

	public User() {

	}

	public User(int idUtente2, String username2, String password2, String email2, String firstname2, String lastname2,
			String subsDate2, String birthDate2, String zone2, String instrPlayed2, int i, String nameBand2) {

	
		this.idUtente = idUtente2;
		this.username = username2;
		this.password = password2;
		this.email = email2;
		this.firstname = firstname2;
		this.lastname = lastname2;
		this.subsDate = subsDate2;
		this.birthDate = birthDate2;
		this.zone = zone2;
		this.instrPlayed = instrPlayed2;
		this.band = i;
		this.nameBand = nameBand2;
	}

	@Override
	public int getId() {
		return idUtente;
	}

	@Override
	public void setId(int idUtente) {
		this.idUtente = idUtente;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String getFirstname() {
		return firstname;
	}
	
	@Override
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Override
	public String getLastname() {
		return lastname;
	}
	
	@Override
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String getSubsDate() {
		return subsDate;
	}
	
	@Override
	public void setSubsDate(String subsDate) {
		this.subsDate = subsDate;
	}
	
	@Override
	public String getBirthDate() {
		return birthDate;
	}
	
	@Override
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String getZone() {
		return zone;
	}
	
	@Override
	public void setZone(String zone) {
		this.zone = zone;
	}
	
	@Override
	public String getInstrPlayed() {
		return instrPlayed;
	}
	
	@Override
	public void setInstrPlayed(String instrPlayed) {
		this.instrPlayed = instrPlayed;
	}
	
	@Override
	public int getBand() {
		return band;
	}
	
	@Override
	public void setBand(int i) {
		this.band = i;
	}
	
	@Override
	public String getNameBand() {
		return nameBand;
	}
	
	@Override
	public void setNameBand(String nameBand) {
		this.nameBand = nameBand;
	}

	@Override
	public int getFlag() {
		return flag;
	}

	@Override
	public void setFlag(int flag) {
		this.flag = flag;
	}
		

	/*
	 * public abstract void writeRules(); public abstract void moderateUsers();
	 */

	/*public String checkIfRegistered(String username, String password) {

		UserDAO userDAO = new UserDAO();
		return userDAO.checkIfRegistered(username, password);
	}*/

}
