package gui;

import gui.resources.Constants;
import gui.resources.Images;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.ObservableModel;
import logic.data.PropertyChanges;
import logic.states.EnumStates;

public class UInotifications extends BorderPane {
    private ObservableModel obsModel;
    String limitMoneyDay;
    boolean flagLimitMoneyDay;
    String limitLossWeek;
    Boolean flagLimitLossWeek;
    String minimumMoneyMonth;
    Boolean flagMinimumMoneyMonth;
    String reminderBetDay;
    Boolean flagReminderBetDay;
    Boolean flagResultsReminder;


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
        ToggleSwitch flagLimitMoneyDaySwitch = new ToggleSwitch();
        ToggleSwitch flagLimitLossWeekSwitch = new ToggleSwitch();
        ToggleSwitch flagMinimumMoneyMonthSwitch = new ToggleSwitch();
        ToggleSwitch flagReminderBetDaySwitch = new ToggleSwitch();
        ToggleSwitch flagResultsReminderSwitch = new ToggleSwitch();

        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        Label titulo = new Label("Limit monet betted / day:");
        TextField limitMoneyDayField= new TextField();
        vBox1.getChildren().addAll(titulo,limitMoneyDayField, flagLimitMoneyDaySwitch);
        limitMoneyDayField.setText(String.valueOf(obsModel.getLimitMoneyBettedToday()));
        flagLimitMoneyDaySwitch.setOnOrOff(obsModel.getLimitMoneyBettedTodayFlag());
        gridPane.add(vBox1, 0, 0);

        VBox vBox2 = new VBox();
        vBox2.setSpacing(10);
        Label titulo1 = new Label("Limit loss / week:");
        TextField limitLossWeekField = new TextField();
        vBox2.getChildren().addAll(titulo1,limitLossWeekField, flagLimitLossWeekSwitch);
        limitLossWeekField.setText(String.valueOf(obsModel.getLimitLossWeek()));
        flagLimitLossWeekSwitch.setOnOrOff(obsModel.getLimitLossWeekFlag());
        gridPane.add(vBox2, 1, 0);

        VBox vBox3 = new VBox();
        vBox3.setSpacing(10);
        Label titulo2 = new Label("Min. betted money / week:");
        TextField minimumMoneyMonthField = new TextField();
        vBox3.getChildren().addAll(titulo2,minimumMoneyMonthField, flagMinimumMoneyMonthSwitch);
        minimumMoneyMonthField.setText(String.valueOf(obsModel.getMinBettedMoneyWeek()));
        flagMinimumMoneyMonthSwitch.setOnOrOff(obsModel.getMinBettedMoneyWeekFlag());
        gridPane.add(vBox3, 2, 0);



        VBox vBox4 = new VBox();
        vBox4.setSpacing(22);
        Label titulo3 = new Label("Reminder to bet €/day:");
        TextField reminderBetDayField = new TextField();
        vBox4.getChildren().addAll(titulo3,reminderBetDayField, flagReminderBetDaySwitch);
        reminderBetDayField.setText(String.valueOf(obsModel.getReminderToBetDay()));
        flagReminderBetDaySwitch.setOnOrOff(obsModel.getReminderToBetDayFlag());
        gridPane.add(vBox4, 0, 1);

        VBox vBox5 = new VBox();
        vBox5.setSpacing(22);
        Label titulo4 = new Label("Results update reminder:");
        vBox5.getChildren().addAll(titulo4, flagResultsReminderSwitch);
        flagResultsReminderSwitch.setOnOrOff(obsModel.getResultsNotificationReminder());
        gridPane.add(vBox5, 1, 1);



        /*Label titulo2 = new Label("Notifications:");
        gridPane.add(titulo2, 0, 1);
        TextField asasas2= new TextField();

        gridPane.add(asasas, 1, 1);
        gridPane.add(asasas2, 2, 1);*/
        setCenter(gridPane);


        //botão reset

        Button btnReset = new Button("Reset");
        Button btnSave = new Button("Save");

        HBox containerButtons = new HBox();

        containerButtons.getChildren().addAll(btnReset,btnSave);

        setBottom(containerButtons);
        containerButtons.setAlignment(Pos.CENTER);
        btnReset.setMinSize(100,20);
        btnReset.setPadding(new Insets(5,5,5,5));
        btnSave.setMinSize(100,20);
        btnSave.setPadding(new Insets(5,5,5,5));
        containerButtons.setPadding(new Insets(20,20,20,20));

        btnReset.setOnMouseClicked(event->{
            if(event.getButton() == MouseButton.PRIMARY){
                funToShowInCOnstructor();
            }
        });

        btnSave.setOnMouseClicked(event -> {

            if (event.getButton() == MouseButton.PRIMARY) {

                limitMoneyDay = limitMoneyDayField.getText();
                flagLimitMoneyDay = flagLimitMoneyDaySwitch.isOnOrOff();
                limitLossWeek = limitLossWeekField.getText();
                flagLimitLossWeek = flagLimitLossWeekSwitch.isOnOrOff();
                minimumMoneyMonth = minimumMoneyMonthField.getText();
                flagMinimumMoneyMonth = flagMinimumMoneyMonthSwitch.isOnOrOff();
                reminderBetDay = reminderBetDayField.getText();
                flagReminderBetDay = flagReminderBetDaySwitch.isOnOrOff();
                flagResultsReminder = flagResultsReminderSwitch.isOnOrOff();

                if(obsModel.verifyInputNotifications(limitMoneyDay,limitLossWeek,minimumMoneyMonth,reminderBetDay)) {
                    obsModel.setFlagLimitLossWeek(flagLimitLossWeek);
                    obsModel.setLimitLossWeek(Float.parseFloat(limitLossWeek));
                    obsModel.setLimitMoneyDay(Float.parseFloat(limitMoneyDay));
                    obsModel.setFlagLimitMoneyDay(flagLimitMoneyDay);
                    obsModel.setMinimumMoneyMonth(Float.parseFloat(minimumMoneyMonth));
                    obsModel.setFlagMinimumMoneyMonth(flagMinimumMoneyMonth);
                    obsModel.setFlagReminderBetDay(flagReminderBetDay);
                    obsModel.setReminderBetDay(Float.parseFloat(reminderBetDay));
                    obsModel.setFlagResultsReminder(flagResultsReminder);
                }
                else{
                    Alert a1 = new Alert(Alert.AlertType.NONE,
                            "Input error(s)!", ButtonType.OK);
                    // show the dialog
                    a1.showAndWait();
                    //TODO: CHAMAR FUNÇAO WRONG INPUT
                }



            }
        });
    }
    private void propsListener() {
        obsModel.addPropertyChangeListener(PropertyChanges.STATE_CHANGE,
                evt -> {
                    setVisible(obsModel.getState() == EnumStates.NOTIFICATIONS);
                }
        );

    }
}
