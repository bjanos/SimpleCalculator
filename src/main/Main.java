package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ResourceBundle;

/**
 * Starts the application.
 *
 * @author Janos Benyovszki
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ResourceBundle resource = ResourceBundle.getBundle("res/text");
        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"), resource);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style/calculator.css");

        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/res/icon/icon.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
