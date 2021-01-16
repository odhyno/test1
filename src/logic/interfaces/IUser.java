package logic.interfaces;

public interface IUser {

	public int getId();

	public void setId(int idUtente);

	public String getUsername();

	public void setUsername(String username);

	public String getPassword();

	public void setPassword(String password);

	public String getEmail();

	public void setEmail(String email);

	public String getFirstname();

	public void setFirstname(String firstname);

	public String getLastname();

	public void setLastname(String lastname);

	public String getSubsDate();

	public void setSubsDate(String subsDate);

	public String getBirthDate();

	public void setBirthDate(String birthDate);

	public String getZone();

	public void setZone(String zone);

	public String getInstrPlayed();

	public void setInstrPlayed(String instrPlayed);

	public int getBand();

	public void setBand(int i);

	public String getNameBand();

	public void setNameBand(String nameBand);
	
	public int getFlag();

	public void setFlag(int flag);
	
}
