package logic.utils;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.bean.PostBean;
import logic.control.ControlSamplePost;

public class FindPostGUI {
	
	public static VBox getFindPostScene() {
		
		ControlSamplePost ctrlPost = new ControlSamplePost();
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();
		
		VBox root = new VBox();
		
		Text title = new Text();
		title.setText("Finding Post By...");
		
		Button usernameBTN = new Button("Username");
		Button searchBTN = new Button("Search");
		Button backBTN = new Button("Back");
		
		searchBTN.setVisible(false);
		
		TextField usernameField = new TextField();
		
		usernameField.setMaxWidth(350);
		usernameField.setAlignment(Pos.CENTER);
		usernameField.setPromptText("Username");
		
		usernameField.setVisible(false);
		
		TextArea results = new TextArea();
		
		results.setMaxWidth(400);
		results.setEditable(false);
		results.setVisible(false);
		
		usernameBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				usernameField.setVisible(true);
				searchBTN.setVisible(true);
				
				
			}
		});
		
		searchBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				List<PostBean> postList = ctrlPost.filterSamplePostByUsername(usernameField.getText());
				
				results.setVisible(true);
				
				
				
				int i;
				
				for(i=0; i<postList.size(); i++) {
										
					results.setText(results.getText() + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
							"\nAutore: " + postList.get(i).getAutore() + "\n\nDescrizione: " + postList.get(i).getDescrizione() +
							"\n\nNome Sample: " + postList.get(i).getNomeSample() + "\n\n");
				}
				
				
				
			}
		});
		
		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				results.clear();
				win.loadSamplePostPage();
			}
		});
		
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title, usernameBTN, usernameField, searchBTN, results, backBTN);

		return root;
	}

}
