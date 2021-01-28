package utility;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EmailNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmailNotFoundException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: Email not found. Retry!");

		alert.showAndWait();
	}

}
