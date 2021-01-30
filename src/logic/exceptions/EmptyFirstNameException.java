package logic.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EmptyFirstNameException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyFirstNameException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Empty First Name");
		alert.setContentText("Error: You didn't insert First name. Retry!");

		alert.showAndWait();
	}

}
