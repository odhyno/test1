package logic.entity;

public class User {

	private int idUtente;
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	private String subsDate;
	private String birthDate;
	private int flag;

	public User() {

	}

	public User(String username2, String password2, String email2, String firstname2, String lastname2,
			String subsDate2, String birthDate2) {

	
		this.username = username2;
		this.password = password2;
		this.email = email2;
		this.firstname = firstname2;
		this.lastname = lastname2;
		this.subsDate = subsDate2;
		this.birthDate = birthDate2;
	}

	
	public int getEntityId() {
		return idUtente;
	}

	
	public void setEntityId(int idUtente) {
		this.idUtente = idUtente;
	}
	
	
	public String getEntityUsername() {
		return username;
	}
	
	
	public void setEntityUsername(String username) {
		this.username = username;
	}
	
	
	public String getEntityPassword() {
		return password;
	}
	
	public void setEntityPassword(String password) {
		this.password = password;
	}
	
	
	public String getEntityEmail() {
		return email;
	}
	
	
	public void setEntityEmail(String email) {
		this.email = email;
	}
	
	
	public String getEntityFirstname() {
		return firstname;
	}
	
	
	public void setEntityFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	public String getEntityLastname() {
		return lastname;
	}
	
	
	public void setEntityLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	public String getEntitySubsDate() {
		return subsDate;
	}
	
	
	public void setEntitySubsDate(String subsDate) {
		this.subsDate = subsDate;
	}
	
	
	public String getEntityBirthDate() {
		return birthDate;
	}
	
	
	public void setEntityBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	
	public int getEntityFlag() {
		return flag;
	}

	
	public void setEntityFlag(int flag) {
		this.flag = flag;
	}
	
}
