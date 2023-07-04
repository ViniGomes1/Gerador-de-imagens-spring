package com.vinigomes.design;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
	
	private static Scene scene;
	
	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(App.class.getResource("MainScene.fxml"));
        scene = new Scene(root);
        //String css = App.class.getResource("application.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
		
	}

}
