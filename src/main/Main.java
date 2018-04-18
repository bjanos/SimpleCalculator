package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ResourceBundle resource = ResourceBundle.getBundle("res/text");
        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"), resource);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style/calculator.css");

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
