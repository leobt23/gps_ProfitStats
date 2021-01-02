package gui;

import gui.resources.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
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
        /*Label betRegistryTitle = new Label("NOTIFICATIONS");
        betRegistryTitle.setTextFill(Color.BLACK);
        betRegistryTitle.setFont(new Font( "Arial",30) );
        setTop(betRegistryTitle);*/

        Label lTitle = new Label("Statistics");
        lTitle.setTextFill(Color.BLACK);
        lTitle.setFont(new Font( "Arial",24) );
        lTitle.setAlignment(Pos.CENTER);

        VBox hbTitleContainer = new VBox();
        hbTitleContainer.setAlignment(Pos.CENTER);
        hbTitleContainer.setPadding(new Insets(15));
        hbTitleContainer.setMaxWidth(250);
        hbTitleContainer.setBackground(new Background( new BackgroundFill(
                Color.LIGHTGRAY, new CornerRadii(5), Insets.EMPTY
        )));
        hbTitleContainer.setBorder(
                new Border(
                        new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                                new CornerRadii(5), new BorderWidths(2))
                )
        );
        hbTitleContainer.getChildren().add(lTitle);

        setTop(hbTitleContainer);
        BorderPane.setAlignment(hbTitleContainer, Pos.CENTER);
        BorderPane.setMargin(hbTitleContainer, new Insets(20,0,0,0));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        //FORM

        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        Label titulo = new Label("Notifications:");
        TextField asasas= new TextField();
        hBox1.getChildren().addAll(titulo,asasas);
        gridPane.add(hBox1, 0, 1);

        HBox hBox2 = new HBox();
        hBox2.setSpacing(10);
        Label titulo1 = new Label("Notifications:");
        TextField asasas1 = new TextField();
        hBox2.getChildren().addAll(titulo1,asasas1);
        gridPane.add(hBox2, 1, 1);

        HBox hBox3 = new HBox();
        hBox3.setSpacing(10);
        Label titulo2 = new Label("Notifications:");
        TextField asasas2 = new TextField();
        hBox3.getChildren().addAll(titulo2,asasas2);
        gridPane.add(hBox3, 2, 1);

        /*Label titulo2 = new Label("Notifications:");
        gridPane.add(titulo2, 0, 1);
        TextField asasas2= new TextField();

        gridPane.add(asasas, 1, 1);
        gridPane.add(asasas2, 2, 1);*/
        setCenter(gridPane);
    }
    private void propsListener() {
        obsModel.addPropertyChangeListener(PropertyChanges.STATE_CHANGE,
                evt -> {
                    setVisible(obsModel.getState() == EnumStates.NOTIFICATIONS);
                }
        );

    }
}
