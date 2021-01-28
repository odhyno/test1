package utility;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TextException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextException() {
		Alert alert = new Alert(AlertType.ERROR);
  		alert.setTitle("Social Music");
  		alert.setHeaderText("Empty text Error");
  		alert.setContentText("Error: Empty text. Retry!");

  		alert.showAndWait();
 	
	}
}
