package utility;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EmptyDateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyDateException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Empty Birth Date");
		alert.setContentText("Error: You didn't insert Birth Date. Retry!");

		alert.showAndWait();
	}
}
