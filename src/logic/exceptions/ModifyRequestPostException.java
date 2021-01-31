package logic.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ModifyRequestPostException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ModifyRequestPostException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Modify Post Error");
		alert.setContentText("Error: post not modified. Retry!");

		alert.showAndWait();
	}

}
