package logic.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import logic.bean.UserBean;
import logic.entity.User;
import logic.patterns.FacadeDAO;
import logic.patterns.GoogleAdapter;
import logic.patterns.GoogleWeb;
import logic.patterns.IUser;
import logic.utility.MailSender;

/**
 * Controller per il Login La classe è un Singleton.
 * 
 * @author Leonardo Monnati,Vincenzo Visconti,Alessandro Corsico
 * @version 1.0
 */
public class ControlLogin {

	private static ControlLogin instance = null;

	private ControlLogin() {

	}

	// Singleton

	public static ControlLogin getInstance() {

		if (instance == null) {

			instance = new ControlLogin();

		}

		return instance;

	}

	// funzione che verifica se un utente è registrato nel sistema
	public int checkLogin(UserBean loginUser) {

		User user = new User();
		user.setEntityUsername(loginUser.getUsername());
		user.setEntityPassword(loginUser.getPassword());
		return new FacadeDAO().checkIfRegistered(user);

	}

	// funzione che verifica se l'utente che sta accedendo con google è già
	// registrato nel sistema
	public UserBean checkIfGoogleRegistered() {

		User user = new User();
		IUser googleUser = new GoogleAdapter(new GoogleWeb());
		user.setEntityEmail(googleUser.getEntityEmail());
		user.setEntityFirstname(googleUser.getEntityFirstname());
		user.setEntityLastname(googleUser.getEntityLastname());

		UserBean usBean = new UserBean();
		user = new FacadeDAO().checkIfGoogleEmailRegistered(user);

		usBean.setUsername(user.getEntityUsername());
		usBean.setEmail(user.getEntityEmail());
		usBean.setFirstname(user.getEntityFirstname());
		usBean.setLastname(user.getEntityLastname());
		usBean.setType(user.getEntityFlag());

		return usBean;

	}

	// funzione che chiama la DAO per il check username

	public String checkUsernameAlreadyTaken(String username) {

		return new FacadeDAO().checkUsernameAlreadyTaken(username);
	}

	// funzione che converte la data in stringa e chiama la DAO per il register

	public void registerUser(UserBean usBean) {

		String subsDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

		User user = new User();

		user.setEntityUsername(usBean.getUsername());
		user.setEntityPassword(usBean.getPassword());
		user.setEntityEmail(usBean.getEmail());
		user.setEntityFirstname(usBean.getFirstname());
		user.setEntityLastname(usBean.getLastname());
		user.setEntitySubsDate(subsDate);
		user.setEntityBirthDate(usBean.getBirthDate());

		new FacadeDAO().registerUser(user);

	}

	// funzione che verifica se la mail da inserire è valida

	public boolean checkIfEmailIsValid(String email) {

		if (email == null)
			return false;

		int res = email.indexOf("@");
		return res > 0 && email.indexOf(".", res) > 0;

	}

	// funzione che invia una email

	public int sendEmail(UserBean usBean) {

		
		User user = new User();
		user.setEntityUsername(usBean.getUsername());
		user.setEntityEmail(usBean.getEmail());
		String password = new FacadeDAO().checkEmail(user);

		if (password != null) {

			MailSender ms = new MailSender();
			ms.sendMail(usBean.getEmail(), usBean.getUsername(), password);
			return 1;

		}

		return 0;

	}
}
