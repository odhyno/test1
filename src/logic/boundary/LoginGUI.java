package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.actors.User;
import logic.control.ControlLogin;
import logic.utils.WindowManagerGUI;

public class LoginGUI {

	public static VBox getLoginPageScene() {

		VBox root = new VBox();

		Text title = new Text();

		ControlLogin ctrlLogin = new ControlLogin();

		title.setText("Benvenuto in Social Music!");

		TextField usernameField = new TextField();
		PasswordField passwordField = new PasswordField();

		Button loginBTN = new Button("Accedi");
		Button registerBTN = new Button("Registrati");
		Button recoverDataBTN = new Button("Recupera Dati");

		WindowManagerGUI win = new WindowManagerGUI();

		usernameField.setMaxWidth(200);
		usernameField.setAlignment(Pos.CENTER_LEFT);
		usernameField.setPromptText("Username");

		passwordField.setMaxWidth(200);
		passwordField.setAlignment(Pos.CENTER_LEFT);
		passwordField.setPromptText("Password");

		loginBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

					ctrlLogin.sendUsernameAlert();

				} else if (passwordField.getText() == null || passwordField.getText().trim().isEmpty()) {

					ctrlLogin.sendPasswordAlert();

				} else {

					String result = ctrlLogin.checkIfRegistered(usernameField.getText(), passwordField.getText());

					if (result.equals("trovato")) {
						
						User user = ctrlLogin.getUser(usernameField.getText(), passwordField.getText());
	
						win.loadHomePage(user);

					} else {

						ctrlLogin.sendDataNotFoundAlert();
						usernameField.clear();
						passwordField.clear();

					}
				}
			}
		});

		registerBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadRegisterPage();
			}
		});

		recoverDataBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadRecoverDataPage();
			}
		});

		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title, usernameField, passwordField, loginBTN, registerBTN, recoverDataBTN);

		return root;

	}
}
