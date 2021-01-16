package logic.control;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.bean.UserBean;
import logic.dao.UserDAO;
import logic.utils.MailSender;
import logic.utils.WindowManagerGUI;

public class ControlRecoverData {
	
	public void sendUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public void sendEmailAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: You didn't insert Email. Retry!");

		alert.showAndWait();
	}

	public void mailSentAlert() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data");
		alert.setContentText("Success! Your Data has been sent at your email!");

		alert.showAndWait();
	}

	public void sendDataNotFoundAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Recover Data Error");
		alert.setContentText("Error: Email not found. Retry!");

		alert.showAndWait();
	}

	public void sendEmail(UserBean usBean) {
		
		String password;
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		password = UserDAO.checkEmail(usBean);
		
		if(password != null) {
			
			MailSender ms = new MailSender();

			ms.sendMail(usBean.getEmail(), usBean.getUsername(), password);
			mailSentAlert();
			win.loadLoginPage();
		
		} else {
			
			sendDataNotFoundAlert();
			win.loadLoginPage();
		}
		
	}

}
