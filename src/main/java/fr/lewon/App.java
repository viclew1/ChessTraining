package fr.lewon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_scene.fxml"));
		BorderPane rootElement = loader.load();
		Scene scene = new Scene(rootElement, 600, 400);
		
		primaryStage.setMinWidth(600);
		primaryStage.setMinHeight(400);
		primaryStage.setTitle("Chess game");
		primaryStage.setScene(scene);
		
		primaryStage.show();
		loader.getController();
		primaryStage.setOnCloseRequest((e) -> System.exit(0));
	}

}
