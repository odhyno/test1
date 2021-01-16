package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.bean.UserBean;
import logic.control.ControlRecoverData;
import logic.utils.WindowManagerGUI;

public class RecoverDataGUI {

	public static VBox getRecoverDataPageScene() {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();

		VBox root = new VBox();
		
		UserBean usBean = new UserBean();
		
		Text title = new Text();
		TextField usernameField = new TextField();
		TextField emailField = new TextField();
		Button recoverDataBTN = new Button("Recupera Dati");
		Button backBTN = new Button("Back");

		ControlRecoverData ctrlRecoverData = new ControlRecoverData();

		title.setText("Recover Data: Insert your Username & your Email below");
		
		usernameField.setMaxWidth(350);
		usernameField.setAlignment(Pos.CENTER_LEFT);
		usernameField.setPromptText("Username");

		emailField.setMaxWidth(350);
		emailField.setAlignment(Pos.CENTER_LEFT);
		emailField.setPromptText("Email");

		recoverDataBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				if (usernameField.getText() == null || usernameField.getText().trim().isEmpty()) {

					ctrlRecoverData.sendUsernameAlert();

				} else if (emailField.getText() == null || emailField.getText().trim().isEmpty()) {

					ctrlRecoverData.sendEmailAlert();

				} else {
					
					usBean.setUsername(usernameField.getText());
					usBean.setEmail(emailField.getText());

					ctrlRecoverData.sendEmail(usBean);

					
				}
			}
		});

		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				win.loadLoginPage();
			}

		});

		root.getChildren().addAll(title, usernameField, emailField, recoverDataBTN, backBTN);
		root.setAlignment(Pos.CENTER);

		return root;
	}

}
