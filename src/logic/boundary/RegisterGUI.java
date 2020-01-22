package logic.boundary;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import logic.control.ControlRegister;
import logic.utils.WindowManagerGUI;

public class RegisterGUI {

	public static VBox getRegisterPageScene() {

		VBox root = new VBox();

		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 = new HBox();
		HBox hb4 = new HBox();
		HBox hb5 = new HBox();
		HBox hb6 = new HBox();

		Button registerBTN = new Button("Registrati");
		Button backBTN = new Button("Back");
		Text title = new Text();
		title.setText("Registrazione:");

		TextField usernameField = new TextField();
		PasswordField passwordField = new PasswordField();
		TextField emailField = new TextField();
		TextField firstNameField = new TextField();
		TextField lastNameField = new TextField();
		DatePicker birthDateField = new DatePicker();
		TextField zoneField = new TextField();
		TextField instrPlayedField = new TextField();
		CheckBox bandField = new CheckBox();
		TextField nameBandField = new TextField();

		ControlRegister ctrlRegister = new ControlRegister();

		usernameField.setMaxWidth(200);
		usernameField.setAlignment(Pos.CENTER_LEFT);
		usernameField.setPromptText("Username");

		passwordField.setMaxWidth(200);
		passwordField.setAlignment(Pos.CENTER_LEFT);
		passwordField.setPromptText("Password");

		emailField.setMaxWidth(350);
		emailField.setAlignment(Pos.CENTER_LEFT);
		emailField.setPromptText("Email");

		firstNameField.setMaxWidth(200);
		firstNameField.setAlignment(Pos.CENTER_LEFT);
		firstNameField.setPromptText("First Name");

		lastNameField.setMaxWidth(200);
		lastNameField.setAlignment(Pos.CENTER_LEFT);
		lastNameField.setPromptText("Last Name");

		birthDateField.setEditable(false);

		zoneField.setMaxWidth(200);
		zoneField.setAlignment(Pos.CENTER_LEFT);
		zoneField.setPromptText("Zone");

		instrPlayedField.setMaxWidth(200);
		instrPlayedField.setAlignment(Pos.CENTER_LEFT);
		instrPlayedField.setPromptText("Instrument");

		nameBandField.setMaxWidth(200);
		nameBandField.setAlignment(Pos.CENTER_LEFT);
		nameBandField.setPromptText("Name Band");
		nameBandField.setVisible(false);

		Text birth = new Text();
		birth.setText("When were you born?  ");

		Text band = new Text();
		band.setText("Are you in a band?");

		bandField.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				nameBandField.setVisible(newValue);
			}
		});

		registerBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

					ctrlRegister.sendUsernameAlert();

				} else if (passwordField.getText() == null || passwordField.getText().trim().isEmpty()) {

					ctrlRegister.sendPasswordAlert();

				} else if (emailField.getText() == null || emailField.getText().trim().isEmpty()) {

					ctrlRegister.sendEmailAlert();

				} else if (firstNameField.getText() == null || firstNameField.getText().trim().isEmpty()) {

					ctrlRegister.sendFirstNameAlert();

				} else if (instrPlayedField.getText() == null || instrPlayedField.getText().trim().isEmpty()) {

					ctrlRegister.sendInstrPlayedAlert();

				} else if (bandField.isSelected() && nameBandField.getText().equals("")) {

					ctrlRegister.sendNameBandAlert();

				} else if (!ctrlRegister.checkIfEmailIsValid(emailField.getText())) {

					ctrlRegister.sendEmailNotValidAlert();
					emailField.clear();

				} else {

					String bandFlag = null;

					if (bandField.isSelected() && !nameBandField.getText().equals("")) {

						bandFlag = "band";

					} else {

						bandFlag = "noband";

					}

					String result1 = ctrlRegister.checkUsernameAlreadyTaken(usernameField.getText());
					String result2 = ctrlRegister.checkEmailAlreadyTaken(emailField.getText());

					if (result1.equals("trovato")) {

						ctrlRegister.sendUsernameAlreadyTakenAlert();
						usernameField.clear();

					} else if (result2.equals("trovato")) {

						ctrlRegister.sendEmailAlreadyTakenAlert();
						emailField.clear();
					}

					else {

						ctrlRegister.registerUser(usernameField.getText(), passwordField.getText(),
								emailField.getText(), firstNameField.getText(), lastNameField.getText(),
								birthDateField.getValue().toString(), zoneField.getText(), instrPlayedField.getText(),
								bandFlag, nameBandField.getText());

						usernameField.clear();
						passwordField.clear();
						emailField.clear();
						firstNameField.clear();
						lastNameField.clear();
						birthDateField.setValue(null);
						zoneField.clear();
						instrPlayedField.clear();
						bandField.setSelected(false);
						nameBandField.clear();
						ctrlRegister.registrationAlert();
						WindowManagerGUI.loadLoginPage();
					}

				}
			}
		});

		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				WindowManagerGUI.loadLoginPage();
			}

		});

		hb1.getChildren().addAll(usernameField, passwordField);
		hb2.getChildren().addAll(emailField);
		hb3.getChildren().addAll(firstNameField, lastNameField);
		hb4.getChildren().addAll(zoneField, instrPlayedField);
		hb5.getChildren().addAll(band, bandField, nameBandField);
		hb6.getChildren().addAll(birth, birthDateField);

		hb1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.CENTER);
		hb3.setAlignment(Pos.CENTER);
		hb4.setAlignment(Pos.CENTER);
		hb5.setAlignment(Pos.CENTER);
		hb6.setAlignment(Pos.CENTER);

		root.getChildren().addAll(title, hb1, hb2, hb3, hb4, hb5, hb6, registerBTN, backBTN);
		root.setAlignment(Pos.CENTER);

		return root;

	}
}
