package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import logic.control.ControlRecoverData;
import logic.utils.WindowManagerGUI;

public class RecoverDataGUI {

	public static VBox getRecoverDataPageScene() {

		VBox root = new VBox();
		Text title = new Text();
		TextField emailField = new TextField();
		Button recoverDataBTN = new Button("Recupera Dati");
		Button backBTN = new Button("Back");

		ControlRecoverData ctrlRecoverData = new ControlRecoverData();

		title.setText("Recover Data: Insert your Email below");

		emailField.setMaxWidth(350);
		emailField.setAlignment(Pos.CENTER_LEFT);
		emailField.setPromptText("Email");

		recoverDataBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				if (emailField.getText() == null || emailField.getText().trim().isEmpty()) {

					ctrlRecoverData.sendEmailAlert();

				} else {

					String result = ctrlRecoverData.checkIfRegistered(emailField.getText());

					if (result.equals("trovato")) {

						ctrlRecoverData.sendEmail(emailField.getText());
						ctrlRecoverData.mailSentAlert();
						WindowManagerGUI.loadLoginPage();

					} else {

						ctrlRecoverData.sendDataNotFoundAlert();
						emailField.clear();

					}
				}
			}
		});

		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadLoginPage();
			}

		});

		root.getChildren().addAll(title, emailField, recoverDataBTN, backBTN);
		root.setAlignment(Pos.CENTER);

		return root;
	}

}
