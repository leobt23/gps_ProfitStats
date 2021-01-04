package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import logic.EnumWrongInputUserProfile;
import logic.ObservableModel;
import logic.data.BettingHistory;
import logic.data.EnumGenders;
import logic.data.Notifications;
import logic.data.PropertyChanges;
import logic.states.EnumStates;
import logic.EnumBetStatus;
import gui.resources.Constants;
import gui.resources.Images;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import static com.sun.glass.ui.Cursor.setVisible;

public class UserInterface extends BorderPane{
    private ObservableModel obsModel;

    private String userName, userEmail, userAge;
    private EnumGenders userGender;

    private TextField nameBoxEdit, emailBoxEdit, ageBoxEdit;

    public UserInterface(ObservableModel obsModel) {
        this.obsModel = obsModel;

        propsListener();
        profile();
    }

    private void profile() {
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
        this.setBackground(new Background(new BackgroundImage(Images.getImage(Constants.USER_PROFILE_BACKGROUND),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));

        GridPane gridPane = new GridPane();
        gridPane.setMaxHeight(500);
        gridPane.setMaxWidth(400);
        gridPane.setBackground(new Background(new BackgroundFill(
                Color.rgb(255,255,255,0.7), new CornerRadii(5), Insets.EMPTY)
        ));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Label nome = new Label("Name: ");
        gridPane.add(nome,0,1);

        Label nameBox = new Label(obsModel.getUserName());
        gridPane.add(nameBox, 1, 1);

        Label email = new Label("Email: ");
        gridPane.add(email,0,2);

        Label  emailBox = new Label(obsModel.getUserEmail());
        gridPane.add(emailBox, 1, 2);

        Label age = new Label("Age: ");
        gridPane.add(age, 0, 3);

        Label ageBox = new Label(obsModel.getUserAge());
        gridPane.add(ageBox, 1, 3);

        Label totalBets = new Label("Total Bets: ");
        gridPane.add(totalBets, 0, 4);

        Label totalBetsBox = new Label(obsModel.getUserTotalBets());
        gridPane.add(totalBetsBox, 1,4);

        Label spinnerGenero = new Label("Gender: ");
        gridPane.add(spinnerGenero, 0, 5);

        Label spinnerGeneroBox = new Label (obsModel.getUserGender());
        gridPane.add(spinnerGeneroBox,1, 5);

        Label totalProfit = new Label("Total Profit: ");
        gridPane.add(totalProfit, 0, 6);

        Label totalProfitBox = new Label(obsModel.getUserTotalProfit() + "€");
        gridPane.add(totalProfitBox,1,6 );

        Label highestWinValue = new Label("Highest Win: ");
        gridPane.add(highestWinValue, 0, 7);

        Label highestWinValueBox = new Label(obsModel.getUserHightestWin() + "€");
        gridPane.add(highestWinValueBox,1,7);

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

        setCenter(gridPane);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setSpacing(20);
        hBox.setPadding(new Insets(0, 0, 0, 20));

        hBox.setOnMouseClicked( e -> editProfile());

        ImageView imgView = new ImageView(Images.getImage(Constants.EDIT_ICON));
        imgView.setFitWidth(gui.left_panel.Constants.IMG_VIEW_WIDTH);
        imgView.setFitHeight(gui.left_panel.Constants.IMG_VIEW_HEIGHT);
        hBox.getChildren().add(imgView);

        gridPane.add(hBox, 1, 15);

        setBottom(null);

    }

    private void editProfile() {

        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
        this.setBackground(new Background(new BackgroundImage(Images.getImage(Constants.USER_PROFILE_BACKGROUND),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));

        GridPane gridPane = new GridPane();
        gridPane.setMaxHeight(500);
        gridPane.setMaxWidth(400);
        gridPane.setBackground(new Background(new BackgroundFill(
                Color.rgb(255,255,255,0.7), new CornerRadii(5), Insets.EMPTY)
        ));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Label name = new Label("Name: ");
        gridPane.add(name,0,1);

        nameBoxEdit = new TextField(obsModel.getUserName());
        gridPane.add(nameBoxEdit, 1, 1);

        Label email = new Label("Email: ");
        gridPane.add(email,0,2);

        emailBoxEdit = new TextField(obsModel.getUserEmail());
        gridPane.add(emailBoxEdit, 1, 2);

        Label age = new Label("Age: ");
        gridPane.add(age, 0, 3);

        ageBoxEdit = new TextField(obsModel.getUserAge());
        gridPane.add(ageBoxEdit, 1, 3);

        Label spinnerGeneroBox = new Label("Gender: ");
        gridPane.add(spinnerGeneroBox, 0, 5);

        final ComboBox spinnerGenero = new ComboBox();

        spinnerGenero.getItems().addAll(
                "Male",
                "Female",
                "Other" );
        spinnerGenero.setValue(obsModel.getUserGender());
        gridPane.add(spinnerGenero,1, 5);

        Button btnCancel = new Button("Cancel");
        Button btnSave = new Button("Save");

        btnCancel.setOnMouseClicked(e -> profile());

        btnSave.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                nameBoxEdit.setStyle("");
                emailBoxEdit.setStyle("");
                ageBoxEdit.setStyle("");

                userName = nameBoxEdit.getText();
                userEmail = emailBoxEdit.getText();
                userAge = ageBoxEdit.getText();

                switch ((String) spinnerGenero.getValue()) {
                    case "Male" -> userGender = EnumGenders.MALE;
                    case "Female" -> userGender = EnumGenders.FEMALE;
                    default -> userGender = EnumGenders.OTHER;
                }

                List<EnumWrongInputUserProfile> wrongInputs = obsModel.editProfile(userName, userEmail
                        , userAge, userGender);
                if (wrongInputs.isEmpty()) {
                    profile();
                }
                else {
                    showWrongInputs(wrongInputs);
                }
            }
        });

        HBox containerButtons = new HBox();

        containerButtons.getChildren().addAll(btnCancel,btnSave);

        containerButtons.setAlignment(Pos.CENTER);
        btnCancel.setMinSize(100,20);
        btnCancel.setPadding(new Insets(5,5,5,5));
        btnSave.setMinSize(100,20);
        btnSave.setPadding(new Insets(5,5,5,5));
        containerButtons.setPadding(new Insets(20,20,20,20));
        containerButtons.setSpacing(20);

        containerButtons.setAlignment(Pos.CENTER);
        btnCancel.setMinSize(100,20);
        btnCancel.setPadding(new Insets(5,5,5,5));
        btnSave.setMinSize(100,20);
        btnSave.setPadding(new Insets(5,5,5,5));
        containerButtons.setPadding(new Insets(20,20,20,20));

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

        setCenter(gridPane);
        setBottom(containerButtons);
    }

    private void showWrongInputs(List<EnumWrongInputUserProfile> wrongInputs) {
        for (EnumWrongInputUserProfile wrongInput : wrongInputs) {
           switch (wrongInput) {
               case USER_NAME -> nameBoxEdit.setStyle("-fx-border-color: red ; -fx-border-width: 2px " +
                       ";-fx-focus-color: red ;");
               case EMAIL -> emailBoxEdit.setStyle("-fx-border-color: red ; -fx-border-width: 2px " +
                       ";-fx-focus-color: red ;");
               case AGE -> ageBoxEdit.setStyle("-fx-border-color: red ; -fx-border-width: 2px " +
                       ";-fx-focus-color: red ;");
           }
        }
    }

    private void propsListener() {
        obsModel.addPropertyChangeListener(PropertyChanges.STATE_CHANGE,
                evt -> {
                    setVisible(obsModel.getState() == EnumStates.USER_PROFILE);
                    profile();
                }
        );
    }
}
