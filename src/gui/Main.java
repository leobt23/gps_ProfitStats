package gui;

import gui.resources.Constants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import logic.ObservableModel;

public class Main extends Application {

    private static final String APP_NAME = "ProfitStats";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Root root = new Root(new ObservableModel());
        primaryStage.setTitle(APP_NAME);
        primaryStage.setScene(new Scene(root, 1280, 700));
        primaryStage.getIcons().add(
                new Image( getClass().getResourceAsStream(Constants.APP_LOGO_PATH)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
