package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Sistema de Gestion de Informacion CELUSOFT");

        GridPane gridPane = new GridPane();

        primaryStage.setScene(new Scene(gridPane, 600, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
