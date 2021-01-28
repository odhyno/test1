package utility;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UsernameAlreadyTakenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsernameAlreadyTakenException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Error username");
		alert.setContentText("Error: Username already in use. Retry!");

		alert.showAndWait();
	}

}
