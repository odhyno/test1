package logic.utils;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import logic.bean.PostBean;
import logic.control.ControlSamplePost;

public class InsertPostGUI {

	static Media media;
	static MediaPlayer mediaPlayer;
	static File fl;

	public static VBox getInsertPostScene() {
		
		WindowManagerGUI win = WindowManagerGUI.getWindowManagerGUIInstance();

		ControlSamplePost ctrlSamplePost = new ControlSamplePost();

		VBox root = new VBox();
		HBox box = new HBox();
		Text title = new Text();
		title.setText("Inserting New Post");
		
		TextField titlePostField = new TextField();
		
		titlePostField.setMaxWidth(350);
		titlePostField.setAlignment(Pos.CENTER);
		titlePostField.setPromptText("Title of the post");
		
		TextField fileNameField = new TextField();

		fileNameField.setMaxWidth(350);
		fileNameField.setAlignment(Pos.CENTER_LEFT);
		fileNameField.setPromptText("Name of the Song");
		fileNameField.setEditable(false);

		TextArea descriptionField = new TextArea();
		
		descriptionField.setMaxWidth(350);
		descriptionField.setPromptText("Description");
		
		
		Button playBTN = new Button("Play");
		Button pauseBTN = new Button("Pause");
		Button uploadBTN = new Button("Upload");
		Button backBTN = new Button("Back");
		Button insertPostBTN = new Button("Insert Post");

		playBTN.setVisible(false);
		pauseBTN.setVisible(false);

		uploadBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				FileChooser f = new FileChooser();

				fl = f.showOpenDialog(root.getScene().getWindow());

				fileNameField.setText(fl.getName());
				media = new Media(fl.toURI().toString());
				mediaPlayer = new MediaPlayer(media);

				playBTN.setVisible(true);
				pauseBTN.setVisible(true);

			}
		});

		playBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				mediaPlayer.play();
			}
		});

		pauseBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				mediaPlayer.pause();
			}
		});

		backBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				media = null;
				fl = null;
				fileNameField.setText(null);
				playBTN.setVisible(false);
				pauseBTN.setVisible(false);
				win.loadSamplePostPage();
			}
		});

		insertPostBTN.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				if (fl == null) {
					ctrlSamplePost.insertSamplePostErrorAlert();

				} else {
					
					PostBean postBean = new PostBean();
					
					postBean.setNomeSample(fl.getName());
					postBean.setTitolo(titlePostField.getText());
					postBean.setDescrizione(descriptionField.getText());
					
					media = null;
					fl = null;
					playBTN.setVisible(false);
					pauseBTN.setVisible(false);
					
					ctrlSamplePost.insertSamplePost(postBean);
		
					
					
				}

			}
		});

		box.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		box.getChildren().addAll(playBTN, pauseBTN);
		root.getChildren().addAll(titlePostField, uploadBTN, fileNameField, box, descriptionField, insertPostBTN, backBTN);

		return root;
	}

}
