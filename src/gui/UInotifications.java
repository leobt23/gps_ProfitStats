package gui;

import gui.resources.Constants;
import gui.resources.Images;
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
        BackgroundSize b1Size = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
        this.setBackground(new Background(new BackgroundImage(Images.getImage(Constants.NOTIFICATIONS_BACKGROUND),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                b1Size)));

        /*Label betRegistryTitle = new Label("NOTIFICATIONS");
        betRegistryTitle.setTextFill(Color.BLACK);
        betRegistryTitle.setFont(new Font( "Arial",30) );
        setTop(betRegistryTitle);*/

        Label lTitle = new Label("Notifications");
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
        gridPane.setBackground(new Background(new BackgroundFill(
                Color.rgb(255,255,255,0.55), new CornerRadii(5), Insets.EMPTY)
        ));
        gridPane.setMaxHeight(500);
        gridPane.setMaxWidth(700);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(50);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        //FORM
        ToggleSwitch button = new ToggleSwitch();
        ToggleSwitch button1 = new ToggleSwitch();
        ToggleSwitch button2 = new ToggleSwitch();
        ToggleSwitch button3 = new ToggleSwitch();

        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        Label titulo = new Label("Limit monet betted / day:");
        TextField asasas= new TextField();
        vBox1.getChildren().addAll(titulo,asasas, button);
        gridPane.add(vBox1, 0, 0);

        VBox vBox2 = new VBox();
        vBox2.setSpacing(10);
        Label titulo1 = new Label("Limit loss / week:");
        TextField asasas1 = new TextField();
        vBox2.getChildren().addAll(titulo1,asasas1, button1);
        gridPane.add(vBox2, 1, 0);

        VBox vBox3 = new VBox();
        vBox3.setSpacing(10);
        Label titulo2 = new Label("Min. betted money / week:");
        TextField asasas2 = new TextField();
        vBox3.getChildren().addAll(titulo2,asasas2, button2);
        gridPane.add(vBox3, 2, 0);



        VBox vBox4 = new VBox();
        vBox4.setSpacing(22);
        Label titulo3 = new Label("Reminder to bet €/day:");
        TextField asasas3 = new TextField();
        vBox4.getChildren().addAll(titulo3,asasas3, button3);
        gridPane.add(vBox4, 0, 1);



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
