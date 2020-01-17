package logic.actors;

import java.util.Date;

import logic.dao.UserDAO;

public class User {

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
	private String logged = "NON LOGGATO";

	public User() {

	}

	public User(int idUtente2, String username2, String password2, String email2, String firstname2,
			String lastname2, Date subsDate2, Date birthDate2, String zone2, String instrPlayed2, Boolean band2,
			String nameBand2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return idUtente;
	}

	public void setId(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSubsDate() {
		return subsDate;
	}

	public void setSubsDate(String subsDate) {
		this.subsDate = subsDate;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getInstrPlayed() {
		return instrPlayed;
	}

	public void setInstrPlayed(String instrPlayed) {
		this.instrPlayed = instrPlayed;
	}

	public int getBand() {
		return band;
	}

	public void setBand(int i) {
		this.band = i;
	}

	public String getNameBand() {
		return nameBand;
	}

	public void setNameBand(String nameBand) {
		this.nameBand = nameBand;
	}
	
	public String getLogged() {
		return logged;
	}

	public void setLogged(String logged) {
		this.logged = logged;
	}

	/*
	 * public abstract void writeRules(); public abstract void moderateUsers();
	 */

	public String checkIfRegistered(String username, String password) {

		UserDAO userDAO = new UserDAO();
		String result = userDAO.checkIfRegistered(username, password);

		return result;
	}

	public User getUserFromUsernameAndPassword(String username, String password) {

		User user = new User();
		UserDAO userDAO = new UserDAO();
		user = userDAO.getData(username, password);
		
		return user;
		
	}
}
