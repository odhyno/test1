package logic.control;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.actors.User;
import logic.dao.UserDAO;

public class ControlLogin {

	public void sendUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public void sendPasswordAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: You didn't insert Password. Retry!");

		alert.showAndWait();
	}

	public void sendDataNotFoundAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: Data not found. Retry!");

		alert.showAndWait();
	}

	public String checkIfRegistered(String username, String password) {

		User user = new User();
		String result = user.checkIfRegistered(username, password);

		return result;
	}

	public User getUserFromUsernameAndPassword(String username, String password) {

		UserDAO userDAO = new UserDAO();

		return userDAO.getUserFromUsernameAndPassword(username, password);

	}

}
