package logic.utils;

import logic.actors.User;
import logic.dao.UserDAO;

public class HomepageUtils {

	static User user = null;

	public static User getUser() {

		if (user == null) {
			user = new User();
		}
		return user;
	}

	public static void setUser(String username, String password) {

		UserDAO userDAO = new UserDAO();
		user = userDAO.getUserFromUsernameAndPassword(username, password);

	}

	public static void setLog() {

		if (user.getLogged().equals("LOGGATO")) {

			user.setLogged("NON LOGGATO");
		} else {

			user.setLogged("LOGGATO");
		}

	}

}
