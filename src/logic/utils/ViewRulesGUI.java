package logic.utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ViewRulesGUI {

	public static VBox getViewRulesScene() {
		
		VBox root = new VBox();
		WindowManagerGUI win = new WindowManagerGUI();
	    Text title = new Text("Rules");
		Button homeBTN = new Button("Social Music");
	    Button messagesBTN = new Button("Messages");
	    Button profileBTN = new Button("Profile");
	    Button logoutBTN = new Button("Logout");
	    Button backBTN = new Button("Back");
	    
	    homeBTN.setOnAction(new EventHandler<ActionEvent>() {
	    	
	    	public void handle(ActionEvent event) {
	    	
	    		//win.loadHomePage();
	    	}
	    });
		
		messagesBTN.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
				win.loadMessagesPage();
				
			}
		});
		
profileBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
					
				win.loadProfilePage();
			}
		});
		
		logoutBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
					
				win.loadLoginPage();			
			}
		});
		
		
		
		backBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
				
				//win.loadHomePage(); 
			}
			
		});
		
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title,homeBTN,messagesBTN,profileBTN,logoutBTN,backBTN);
		
		return root;
	}

}
