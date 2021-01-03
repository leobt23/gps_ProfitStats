package gui;

import gui.resources.Images;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.ObservableModel;
import logic.data.PropertyChanges;
import logic.states.EnumStates;

import static gui.resources.Constants.USER_PHOTO;

public class UserInterface extends BorderPane {
    private ObservableModel obsModel;

    public UserInterface(ObservableModel obsModel) {
        this.obsModel = obsModel;

        propsListener();
        functionToShow();
    }


    private void functionToShow() {

        GridPane gridPane = new GridPane();

        Background background = new Background(new BackgroundFill(
                Color.LIGHTGREEN, new CornerRadii(5), Insets.EMPTY));


        gridPane.setMaxWidth(350);
        gridPane.setMaxHeight(380);

        Border border =  new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY, new BorderWidths(2))
        );

     //   gridPane.setBorder(border);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        ImageView foto = new ImageView(Images.getImage(USER_PHOTO));
        foto.setFitHeight(150);
        foto.setFitWidth(230);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(foto, gridPane);
        vBox.setAlignment(Pos.CENTER);
        vBox.setBorder(border);
        vBox.setMaxWidth(350);
        vBox.setMaxHeight(500);
        vBox.setBackground(background);

        Label name = new Label("Name: ");
        gridPane.add(name,0,1);

        TextField nameBox = new TextField();
        gridPane.add(nameBox, 1, 1);

        Label email = new Label("Email: ");
        gridPane.add(email,0,2);

        TextField  emailBox = new TextField();
        gridPane.add(emailBox, 1, 2);

        Label age = new Label("Age: ");
        gridPane.add(age, 0, 3);

        TextField  ageBox = new TextField();
        gridPane.add(ageBox, 1, 3);

        Label totalBets = new Label("Total Bets: ");
        gridPane.add(totalBets, 0, 4);

        TextField totalBetsBox = new TextField();
        gridPane.add(totalBetsBox, 1,4);

        Label spinnerGeneroBox = new Label("Gender: ");
        gridPane.add(spinnerGeneroBox, 0, 5);

        final ComboBox spinnerGenero = new ComboBox();

        spinnerGenero.getItems().addAll(
                "Male",
                "Female",
                "Other" );
        gridPane.add(spinnerGenero,1, 5);

        Label totalProfit = new Label("Total Profit: ");
        gridPane.add(totalProfit, 0, 6);

        TextField totalProfitBox = new TextField();
        gridPane.add(totalProfitBox,1,6 );

        Label highestWinValue = new Label("Highest Win: ");
        gridPane.add(highestWinValue, 0, 7);

        TextField highestWinValueBox = new TextField();
        gridPane.add(highestWinValueBox,1,7);

        Button btnCancel = new Button("Cancel");
        Button btnSave = new Button("Save");

        HBox containerButtons = new HBox();

        containerButtons.getChildren().addAll(btnCancel,btnSave);

        Label lTitle = new Label("User Profile");
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

//        setTop(userTitle);
        setCenter(vBox);
        setBottom(containerButtons);
    }

        private void propsListener () {
            obsModel.addPropertyChangeListener(PropertyChanges.STATE_CHANGE,
                    evt -> {
                        setVisible(obsModel.getState() == EnumStates.USER_PROFILE);
                    }
            );
        }
    }
