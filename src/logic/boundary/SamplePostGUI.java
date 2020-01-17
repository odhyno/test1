package logic.boundary;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import logic.utils.WindowManagerGUI;

public class SamplePostGUI {

	public SamplePostGUI() {
		// TODO Auto-generated constructor stub
	}

	static Media media;
	static MediaPlayer mediaPlayer;
	static File fl;
	static MediaView mediaView;

	public static VBox getSamplePostScene() {

		VBox root = new VBox();
		WindowManagerGUI win = new WindowManagerGUI();

		TextField fileNameField = new TextField();
		Button btnUpload = new Button("Upload");
		HBox box = new HBox();
		Button btnPlay = new Button("Play");
		Button btnPause = new Button("Pause");
		Button btnBack = new Button("Back");

		fileNameField.setMaxWidth(350);
		fileNameField.setAlignment(Pos.CENTER_LEFT);
		fileNameField.setPromptText("Name of the Song");
		fileNameField.setEditable(false);

		btnPlay.setVisible(false);
		btnPause.setVisible(false);

		btnUpload.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				FileChooser f = new FileChooser();

				fl = f.showOpenDialog(root.getScene().getWindow());

				fileNameField.setText(fl.getName());
				media = new Media(fl.toURI().toString());
				mediaPlayer = new MediaPlayer(media);
				mediaView = new MediaView(mediaPlayer);

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
				//win.loadHomePage();
			}
		});

		box.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
		box.getChildren().addAll(btnPlay, btnPause);
		root.getChildren().addAll(btnUpload, fileNameField, box, btnBack);

		return root;
	}

}
