package gui;

import gui.resources.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.ObservableModel;
import logic.data.PropertyChanges;
import logic.states.EnumStates;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UInotifications extends BorderPane {
    private ObservableModel obsModel;

    public UInotifications(ObservableModel obsModel) {
        this.obsModel=obsModel;

        propsListener();

        funToShowInCOnstructor();
}

    private void funToShowInCOnstructor(){
        Label betRegistryTitle = new Label("NOTIFICATIONS");
        betRegistryTitle.setTextFill(Color.BLACK);
        betRegistryTitle.setFont(new Font( "Arial",30) );
        setTop(betRegistryTitle);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        //FORM

        Label titulo = new Label("Notifications:");
        gridPane.add(titulo, 0, 1);

        TextField asasas= new TextField();
        gridPane.add(asasas, 1, 1);
        setCenter(asasas);
    }
    private void propsListener() {
        obsModel.addPropertyChangeListener(PropertyChanges.STATE_CHANGE,
                evt -> {
                    setVisible(obsModel.getState() == EnumStates.NOTIFICATIONS);
                }
        );

    }
}
