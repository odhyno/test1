package utility;

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
		alert.setHeaderText("Remove Post Error");
		alert.setContentText("Error: You've inserted an id not valid. Retry!");

		alert.showAndWait();
	}

}
