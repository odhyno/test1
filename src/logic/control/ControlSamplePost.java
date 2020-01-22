package logic.control;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControlSamplePost {

	public void sendPostAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Insert Post Success");
		alert.setContentText("Success! Your Post has been inserted!");

		alert.showAndWait();
	}

	public void sendPostErrorAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Insert Post Error");
		alert.setContentText("Error: You didn't insert any file. Retry!");

		alert.showAndWait();
	}
}
