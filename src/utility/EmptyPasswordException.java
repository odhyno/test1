package utility;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EmptyPasswordException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyPasswordException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Empty Password");
		alert.setContentText("Error: You didn't insert Password. Retry!");

		alert.showAndWait();
	}
	
}
