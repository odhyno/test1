package entity;

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
	
	
	public int getFlag() {
		return flag;
	}

	
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
