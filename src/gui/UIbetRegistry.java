package gui;

import gui.resources.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.EnumBetStatus;
import logic.EnumWrongInputBetRegistry;
import logic.ObservableModel;
import logic.data.PropertyChanges;
import logic.states.EnumStates;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class UIbetRegistry extends BorderPane {
    private ObservableModel obsModel;
    String possibleWinningsValue;
    String numOfGamesBettedValue;
    String betNameValue;
    String totalValueBettedValue;
    String numberOfBetsValue;
    LocalDate registDateValue;
    LocalDate closeDateValue;
    EnumBetStatus enumBetStatus;

    public UIbetRegistry(ObservableModel obsModel) {
        this.obsModel=obsModel;
        createView();
        propsListener();
    }

    private void createView() {
        //TITLE
        Label betRegistryTitle = new Label("BET REGISTRY");
        betRegistryTitle.setTextFill(Color.BLACK);
        betRegistryTitle.setFont(new Font( "Arial",30) );

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        //FORM

        Label numberOfGamesBetted = new Label("Number of games betted:");
        gridPane.add(numberOfGamesBetted, 0, 1);

        TextField numberOfGamesBettedField= new TextField();
        gridPane.add(numberOfGamesBettedField, 1, 1);

        Label registDate = new Label("Bet regist date:");
        gridPane.add(registDate, 0, 2);

        DatePicker registDatePicker = new DatePicker(LocalDate.now());
        registDatePicker.setOnAction(event -> {
            // LocalDate date = registDatePicker.getValue();
        });
        gridPane.add(registDatePicker,1,2);

        Label closeDate = new Label("Bet close date:");
        gridPane.add(closeDate, 0, 3);

        DatePicker closeDatePicker = new DatePicker(LocalDate.now());
        closeDatePicker.setOnAction(event -> {
            LocalDate date = closeDatePicker.getValue();
        });
        gridPane.add(closeDatePicker,1,3);

        Label totalValueBetted = new Label("Total value betted:");
        gridPane.add(totalValueBetted, 0, 4);

        TextField totalValueBettedField= new TextField();
        gridPane.add(totalValueBettedField, 1, 4);

        Label possibleWinnings = new Label("Possible winnings:");
        gridPane.add(possibleWinnings, 0, 5);

        TextField possibleWinningsField= new TextField();
        gridPane.add(possibleWinningsField, 1, 5);

        Label numberOfBets = new Label("Number of bets:");
        gridPane.add(numberOfBets, 0, 6);

        TextField numberOfBetsField= new TextField();
        gridPane.add(numberOfBetsField, 1, 6);

        Label betName = new Label("Bet name:");
        gridPane.add(betName, 0, 7);

        TextField betNameField= new TextField();
        gridPane.add(betNameField, 1, 7);

        Label Result = new Label("Result:");
        gridPane.add(Result, 0, 8);

        CheckBox checkBoxWin = new CheckBox("Won");
        checkBoxWin.setAllowIndeterminate(false);
        CheckBox checkBoxLost = new CheckBox("Lost");
        checkBoxLost.setAllowIndeterminate(false);
        CheckBox checkBoxPendent = new CheckBox("Pendent");
        checkBoxPendent.setAllowIndeterminate(false);

        EventHandler<ActionEvent> eventWin = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                if (checkBoxWin.isSelected()) {
                    checkBoxLost.setSelected(false);
                    checkBoxPendent.setSelected(false);
                }


            }

        };
        EventHandler<ActionEvent> eventLost = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                if (checkBoxLost.isSelected()) {
                    checkBoxWin.setSelected(false);
                    checkBoxPendent.setSelected(false);
                }


            }

        };
        EventHandler<ActionEvent> eventPendent = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                if (checkBoxPendent.isSelected()) {
                    checkBoxWin.setSelected(false);
                    checkBoxLost.setSelected(false);
                }


            }

        };

        checkBoxWin.setOnAction(eventWin);
        checkBoxLost.setOnAction(eventLost);
        checkBoxPendent.setOnAction(eventPendent);

        HBox containerCheckBoxes = new HBox();

        containerCheckBoxes.getChildren().addAll(checkBoxWin,checkBoxLost,checkBoxPendent);
        containerCheckBoxes.setPadding(new Insets(5, 5, 5, 5));

        gridPane.add(containerCheckBoxes,1,8);

        Button btnCancel = new Button("Cancel");
        Button btnSave = new Button("Save");

        HBox containerButtons = new HBox();
        containerButtons.setSpacing(20);
        btnCancel.setMinSize(100,20);
        btnCancel.setPadding(new Insets(5,5,5,5));
        btnSave.setMinSize(100,20);
        btnSave.setPadding(new Insets(5,5,5,5));
        containerButtons.getChildren().addAll(btnCancel,btnSave);

        HBox titleBox = new HBox();
        titleBox.getChildren().add(betRegistryTitle);
        titleBox.setAlignment(Pos.BOTTOM_CENTER);
        titleBox.setPadding(new Insets(20,0,0,0));

//        setTop(titleBox);

        Label lTitle = new Label("Bet Registry");
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
        containerButtons.setAlignment(Pos.CENTER);
        containerButtons.setPadding(new Insets(20,20,20,20));

        btnSave.setOnMouseClicked(event -> {

            if (event.getButton() == MouseButton.PRIMARY) {

                possibleWinningsValue = possibleWinningsField.getText();
                numOfGamesBettedValue = numberOfGamesBettedField.getText();
                betNameValue = betNameField.getText();
                totalValueBettedValue = totalValueBettedField.getText();
                numberOfBetsValue = numberOfBetsField.getText();
                registDateValue = registDatePicker.getValue();
                closeDateValue = closeDatePicker.getValue();

                if (checkBoxLost.isSelected()) {
                    enumBetStatus = EnumBetStatus.LOST;
                } else {
                    if (checkBoxWin.isSelected()) {
                        enumBetStatus = EnumBetStatus.WON;
                    } else {
                        if (checkBoxPendent.isSelected()) {
                            enumBetStatus = EnumBetStatus.PENDENT;
                        } else {
                            enumBetStatus = null;
                        }
                    }

                }
                boolean input_result = obsModel.verifyInputBetRegistry(numOfGamesBettedValue, registDateValue, closeDateValue, totalValueBettedValue, possibleWinningsValue, numberOfBetsValue
                        , betNameValue, enumBetStatus);
                if(input_result) {
                    obsModel.addNewBet(numOfGamesBettedValue, registDateValue, closeDateValue, totalValueBettedValue, possibleWinningsValue, numberOfBetsValue
                            , betNameValue, enumBetStatus);
                    Alert a1 = new Alert(Alert.AlertType.NONE,
                            "Bet successfuly registered!", ButtonType.OK);
                    // show the dialog
                    a1.showAndWait();
                }
                else{
                    Alert a1 = new Alert(Alert.AlertType.NONE,
                            "Input error(s)!", ButtonType.OK);
                    // show the dialog
                    a1.showAndWait();
                    ViewWithWrongInputs(obsModel.getWrongInputBetRegistry());
                }

            }
        });

        btnCancel.setOnMouseClicked(event->{
            if(event.getButton() == MouseButton.PRIMARY){
                createView();
            }
        });
    }

    private void ViewWithWrongInputs(ArrayList<EnumWrongInputBetRegistry> wrong_input){
        this.obsModel=obsModel;

        //TITLE
        Label betRegistryTitle = new Label("BET REGISTRY");
        betRegistryTitle.setTextFill(Color.BLACK);
        betRegistryTitle.setFont(new Font( "Arial",30) );

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        //FORM

        Label numberOfGamesBetted = new Label("Number of games betted:");
        gridPane.add(numberOfGamesBetted, 0, 1);

        TextField numberOfGamesBettedField= new TextField();
        if(wrong_input.contains(EnumWrongInputBetRegistry.NUMBER_OF_GAMES_BETTED))
            numberOfGamesBettedField.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-focus-color: red ;");
        numberOfGamesBettedField.setText(numOfGamesBettedValue);
        gridPane.add(numberOfGamesBettedField, 1, 1);

        Label registDate = new Label("Bet regist date:");
        gridPane.add(registDate, 0, 2);

        DatePicker registDatePicker = new DatePicker(registDateValue);
        registDatePicker.setOnAction(event -> {
            // LocalDate date = registDatePicker.getValue();
        });
        gridPane.add(registDatePicker,1,2);

        Label closeDate = new Label("Bet close date:");
        gridPane.add(closeDate, 0, 3);

        DatePicker closeDatePicker = new DatePicker(closeDateValue);
        closeDatePicker.setOnAction(event -> {
            LocalDate date = closeDatePicker.getValue();
        });
        if(wrong_input.contains(EnumWrongInputBetRegistry.BET_CLOSE_DATE))
            closeDatePicker.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-focus-color: red ;");
        gridPane.add(closeDatePicker,1,3);

        Label totalValueBetted = new Label("Total value betted:");
        gridPane.add(totalValueBetted, 0, 4);

        TextField totalValueBettedField= new TextField();
        if(wrong_input.contains(EnumWrongInputBetRegistry.TOTAL_VALUE_BETTED))
            totalValueBettedField.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-focus-color: red ;");
        totalValueBettedField.setText(totalValueBettedValue);
        gridPane.add(totalValueBettedField, 1, 4);

        Label possibleWinnings = new Label("Possible winnings:");
        gridPane.add(possibleWinnings, 0, 5);

        TextField possibleWinningsField= new TextField();
        if(wrong_input.contains(EnumWrongInputBetRegistry.POSSIBLE_WINNINGS))
            possibleWinningsField.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-focus-color: red ;");
        possibleWinningsField.setText(possibleWinningsValue);
        gridPane.add(possibleWinningsField, 1, 5);

        Label numberOfBets = new Label("Number of bets:");
        gridPane.add(numberOfBets, 0, 6);

        TextField numberOfBetsField= new TextField();
        if(wrong_input.contains(EnumWrongInputBetRegistry.NUMBER_OF_BETS))
            numberOfBetsField.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-focus-color: red ;");
        numberOfBetsField.setText(numberOfBetsValue);

        gridPane.add(numberOfBetsField, 1, 6);

        Label betName = new Label("Bet name:");
        gridPane.add(betName, 0, 7);

        TextField betNameField= new TextField();
        if(wrong_input.contains(EnumWrongInputBetRegistry.BET_NAME))
            betNameField.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-focus-color: red ;");
        gridPane.add(betNameField, 1, 7);
        betNameField.setText(betNameValue);

        Label Result = new Label("Result:");
        gridPane.add(Result, 0, 8);

        CheckBox checkBoxWin = new CheckBox("Won");
        checkBoxWin.setAllowIndeterminate(false);
        CheckBox checkBoxLost = new CheckBox("Lost");
        checkBoxLost.setAllowIndeterminate(false);
        CheckBox checkBoxPendent = new CheckBox("Pendent");
        checkBoxPendent.setAllowIndeterminate(false);
        if(enumBetStatus==EnumBetStatus.LOST)
            checkBoxLost.setSelected(true);
        if(enumBetStatus==EnumBetStatus.WON)
            checkBoxWin.setSelected(true);
        if(enumBetStatus==EnumBetStatus.PENDENT)
            checkBoxPendent.setSelected(true);

        EventHandler<ActionEvent> eventWin = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                if (checkBoxWin.isSelected()) {
                    checkBoxLost.setSelected(false);
                    checkBoxPendent.setSelected(false);
                }


            }

        };
        EventHandler<ActionEvent> eventLost = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                if (checkBoxLost.isSelected()) {
                    checkBoxWin.setSelected(false);
                    checkBoxPendent.setSelected(false);
                }


            }

        };
        EventHandler<ActionEvent> eventPendent = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                if (checkBoxPendent.isSelected()) {
                    checkBoxWin.setSelected(false);
                    checkBoxLost.setSelected(false);
                }


            }

        };

        checkBoxWin.setOnAction(eventWin);
        checkBoxLost.setOnAction(eventLost);
        checkBoxPendent.setOnAction(eventPendent);

        HBox containerCheckBoxes = new HBox();

        containerCheckBoxes.getChildren().addAll(checkBoxWin,checkBoxLost,checkBoxPendent);
        containerCheckBoxes.setPadding(new Insets(5, 5, 5, 5));

        gridPane.add(containerCheckBoxes,1,8);

        Button btnCancel = new Button("Cancel");
        Button btnSave = new Button("Save");

        HBox containerButtons = new HBox();

        containerButtons.getChildren().addAll(btnCancel,btnSave);

        HBox boxTitle = new HBox();
        boxTitle.getChildren().add(betRegistryTitle);
        boxTitle.setAlignment(Pos.TOP_CENTER);
        boxTitle.setPadding(new Insets(20,0,0,0));
        setTop(boxTitle);
        setCenter(gridPane);
        setBottom(containerButtons);
        containerButtons.setAlignment(Pos.CENTER);
        btnCancel.setMinSize(100,20);
        btnCancel.setPadding(new Insets(5,5,5,5));
        btnSave.setMinSize(100,20);
        btnSave.setPadding(new Insets(5,5,5,5));
        containerButtons.setPadding(new Insets(20,20,20,20));

        btnSave.setOnMouseClicked(event -> {

            if (event.getButton() == MouseButton.PRIMARY) {

                possibleWinningsValue = possibleWinningsField.getText();
                numOfGamesBettedValue = numberOfGamesBettedField.getText();
                betNameValue = betNameField.getText();
                totalValueBettedValue = totalValueBettedField.getText();
                numberOfBetsValue = numberOfBetsField.getText();
                registDateValue = registDatePicker.getValue();
                closeDateValue = closeDatePicker.getValue();

                EnumBetStatus enumBetStatus;
                if (checkBoxLost.isSelected()) {
                    enumBetStatus = EnumBetStatus.LOST;
                } else {
                    if (checkBoxWin.isSelected()) {
                        enumBetStatus = EnumBetStatus.WON;
                    } else {
                        if (checkBoxPendent.isSelected()) {
                            enumBetStatus = EnumBetStatus.PENDENT;
                        } else {
                            enumBetStatus = null;
                        }
                    }

                }
                boolean input_result = obsModel.verifyInputBetRegistry(numOfGamesBettedValue, registDateValue, closeDateValue, totalValueBettedValue, possibleWinningsValue, numberOfBetsValue
                        , betNameValue, enumBetStatus);
                if(input_result) {
                    obsModel.addNewBet(numOfGamesBettedValue, registDateValue, closeDateValue, totalValueBettedValue, possibleWinningsValue, numberOfBetsValue
                            , betNameValue, enumBetStatus);
                    Alert a1 = new Alert(Alert.AlertType.NONE,
                            "Bet successfuly registered!", ButtonType.OK);
                    // show the dialog
                    a1.showAndWait();
                }
                else{
                    Alert a1 = new Alert(Alert.AlertType.NONE,
                            "Input error(s)!", ButtonType.OK);
                    // show the dialog
                    a1.showAndWait();
                    ViewWithWrongInputs(obsModel.getWrongInputBetRegistry());
                }


            }
        });

        btnCancel.setOnMouseClicked(event->{
            if(event.getButton() == MouseButton.PRIMARY){
                createView();
            }
        });

    }
    private void propsListener() {
        obsModel.addPropertyChangeListener(PropertyChanges.STATE_CHANGE,
                evt -> {
                    setVisible(obsModel.getState() == EnumStates.BET_REGISTRY);
                    System.out.println("propertyChange");
                }
        );
        obsModel.addPropertyChangeListener(Constants.WRONG_INPUT_BET_REGISTRY,
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        ArrayList<EnumWrongInputBetRegistry> wrong_input = obsModel.getWrongInputBetRegistry();
                        ViewWithWrongInputs(wrong_input);
                        System.out.println("propertyChange");
                    }
                }
        );
    }
}
