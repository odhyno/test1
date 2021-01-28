package utility;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginException extends Exception {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Error Login");
		alert.setContentText("Error: You are not registered!");

		alert.showAndWait();
	}
	
}
