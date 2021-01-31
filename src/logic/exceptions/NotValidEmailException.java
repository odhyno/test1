package logic.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NotValidEmailException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotValidEmailException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Not valid Email");
		alert.setContentText("Error: Email format not valid. Retry!");

		alert.showAndWait();
	}

}
