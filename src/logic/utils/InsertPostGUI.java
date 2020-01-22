package logic.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import logic.control.ControlSamplePost;

public class InsertPostGUI {

	static Media media;
	static MediaPlayer mediaPlayer;
	static File fl;

	public static VBox getInsertPostScene() {

		ControlSamplePost ctrlSamplePost = new ControlSamplePost();

		VBox root = new VBox();
		HBox box = new HBox();
		Text title = new Text();
		title.setText("Inserting New Post");
		TextField fileNameField = new TextField();

		fileNameField.setMaxWidth(350);
		fileNameField.setAlignment(Pos.CENTER_LEFT);
		fileNameField.setPromptText("Name of the Song");
		fileNameField.setEditable(false);

		Button btnPlay = new Button("Play");
		Button btnPause = new Button("Pause");
		Button btnUpload = new Button("Upload");
		Button btnBack = new Button("Back");
		Button btnInsertPost = new Button("Insert Post");

		btnPlay.setVisible(false);
		btnPause.setVisible(false);

		btnUpload.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				FileChooser f = new FileChooser();

				fl = f.showOpenDialog(root.getScene().getWindow());

				fileNameField.setText(fl.getName());
				media = new Media(fl.toURI().toString());
				mediaPlayer = new MediaPlayer(media);

				btnPlay.setVisible(true);
				btnPause.setVisible(true);

			}
		});

		btnPlay.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				mediaPlayer.play();
			}
		});

		btnPause.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				mediaPlayer.pause();
			}
		});

		btnBack.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				media = null;
				fl = null;
				fileNameField.setText(null);
				btnPlay.setVisible(false);
				btnPause.setVisible(false);
				WindowManagerGUI.loadSamplePostPage();
			}
		});

		btnInsertPost.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				if (fl == null) {
					ctrlSamplePost.sendPostErrorAlert();

				} else {

					try {
						Files.copy(Paths.get(fl.getCanonicalPath()), Paths.get(
								"C:\\Users\\987018\\Desktop\\ISPW\\Progetto Social-Music\\Codice\\SocialMusic\\DB - Samples\\ "
										+ fl.getName()));
					} catch (IOException e) {
						e.printStackTrace();
					}
					media = null;
					fl = null;
					fileNameField.setText(null);
					btnPlay.setVisible(false);
					btnPause.setVisible(false);
					ctrlSamplePost.sendPostAlert();
					WindowManagerGUI.loadSamplePostPage();
				}

			}
		});

		box.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		box.getChildren().addAll(btnPlay, btnPause);
		root.getChildren().addAll(btnUpload, fileNameField, box, btnInsertPost, btnBack);

		return root;
	}

}
