package logic.patterns;

import logic.interfaces.IUser;
import logic.utility.GoogleWeb;

public class GoogleAdapter implements IUser{
	
	private GoogleWeb googleUser=null;
	
	public GoogleAdapter(GoogleWeb google) {
		this.googleUser= google;
	}

	@Override
	public String getEntityEmail() {
		return googleUser.getGoogleEmail();
	}

	@Override
	public String getEntityFirstname() {
		return googleUser.getGoogleGivenName();
	}

	@Override
	public String getEntityLastname() {
		return googleUser.getGoogleFamilyName();
	}
	
	
 
}
