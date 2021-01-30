package logic.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EmptyIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyIdException() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Muisc");
		alert.setHeaderText("Id not inserted");
		alert.setContentText("Please insert the Id");

		alert.showAndWait();
	}
	
	

}
