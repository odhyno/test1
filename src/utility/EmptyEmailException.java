package utility;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EmptyEmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyEmailException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Empty Email");
		alert.setContentText("Error: You didn't insert Email. Retry!");

		alert.showAndWait();
	}
}
