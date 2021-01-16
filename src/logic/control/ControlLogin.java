package logic.control;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.bean.UserBean;
import logic.dao.UserDAO;
import logic.interfaces.IUser;
import logic.patterns.FactoryUser;
import logic.utils.WindowManagerGUI;

public class ControlLogin {

	public void sendUsernameAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: You didn't insert Username. Retry!");

		alert.showAndWait();
	}

	public void sendPasswordAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: You didn't insert Password. Retry!");

		alert.showAndWait();
	}

	public void sendDataNotFoundAlert() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Social Music");
		alert.setHeaderText("Login Error");
		alert.setContentText("Error: Data not found. Retry!");

		alert.showAndWait();
	}

	public void checkIfRegistered(UserBean usBean) {
		
		int type;
		FactoryUser factory = new FactoryUser();
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		type = UserDAO.checkIfRegistered(usBean);
		IUser user = factory.createUser(type);
		
		if(type == -1) {
			sendDataNotFoundAlert();
			
		} else {
			
			user.setUsername(usBean.getUsername());
			win.setUser(user);
			System.out.println(Thread.activeCount());
			win.loadHomePage();

		}
	}
}
