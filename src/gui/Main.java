package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.ObservableModel;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ObservableModel observableModel = new ObservableModel();
        observableModel.setBetStaticId();
        Root root = new Root(observableModel);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1280, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
