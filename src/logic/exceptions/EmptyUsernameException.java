package logic.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EmptyUsernameException extends Exception {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyUsernameException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Empty username");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}
	
}
