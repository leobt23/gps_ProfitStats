package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import logic.ObservableModel;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Root root = new Root(new ObservableModel());
        primaryStage.setTitle("ProfitStats");
        primaryStage.setScene(new Scene(root, 1280, 700));
        primaryStage.getIcons().add(
                new Image( getClass().getResourceAsStream( "app-logo.png" )));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
