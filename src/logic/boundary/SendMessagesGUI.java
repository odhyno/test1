package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.utils.WindowManagerGUI;

public class SendMessagesGUI {

	public static VBox getMessagesScene() {
		VBox root= new VBox();
		Text title=new Text();
		title.setText("messaggi");
		
		Button sendMessageBTN=new Button("invia messaggio");
		Button homePageBTN=new Button("home");
		Button logOutBTN=new Button("logout");
		Button profileBTN=new Button("prfile");
		Button backBTN=new Button("indietro");
		
		WindowManagerGUI win = new WindowManagerGUI();
		
		sendMessageBTN.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
				//TODO Not implemented yet.
				
			}
		});
		
		homePageBTN.setOnAction(new EventHandler<ActionEvent>(){
				
			public void handle(ActionEvent event) {
				
				//win.loadHomePage();
				
			}
		});
		
		logOutBTN.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
				win.loadLoginPage();
			}
		});
		
		profileBTN.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
					
				win.loadProfilePage();
				
			}
			
		});
		
		backBTN.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
				//win.loadHomePage();
			
			}
		
		});
		
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title,sendMessageBTN, homePageBTN, logOutBTN,backBTN);
		
		return root;
		
		
		
		
		
		
		
		
		
	}

}
