package logic.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TextAreaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TextAreaException() {
		Alert alert = new Alert(AlertType.ERROR);
   		alert.setTitle("Social Music");
   		alert.setHeaderText("Unselected user Error");
   		alert.setContentText("Error: Empty Unselected user . Retry!");

   			alert.showAndWait();
	}

}
