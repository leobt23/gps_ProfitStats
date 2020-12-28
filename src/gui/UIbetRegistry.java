package gui;

import gui.resources.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.EnumBetStatus;
import logic.EnumWrongInputBetRegistry;
import logic.ObservableModel;
import logic.states.EnumStates;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class UIbetRegistry extends BorderPane {
    private ObservableModel obsModel;

    public UIbetRegistry(ObservableModel obsModel) {
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
                    checkBoxPendent.setSelected(false);
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

        setTop(betRegistryTitle);
        setCenter(gridPane);
        setBottom(containerButtons);

        btnSave.setOnMouseClicked(event -> {

            if (event.getButton() == MouseButton.PRIMARY) {

                String possibleWinningsValue = possibleWinningsField.getText();
                String numOfGamesBettedValue = numberOfGamesBettedField.getText();
                String betNameValue = betNameField.getText();
                String totalValueBettedValue = totalValueBettedField.getText();
                String numberOfBetsValue = numberOfBetsField.getText();
                LocalDate registDateValue = registDatePicker.getValue();
                LocalDate closeDateValue = closeDatePicker.getValue();

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
              //      obsModel.addNewBet(numOfGamesBettedValue, registDateValue, closeDateValue, totalValueBettedValue, possibleWinningsValue, numberOfBetsValue
              //              , betNameValue, enumBetStatus);
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
                }

            }
        });

        btnCancel.setOnMouseClicked(event->{
           if(event.getButton() == MouseButton.PRIMARY){
       //        obsModel.cancelBetRegistry();
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
            numberOfGamesBettedField.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
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
        if(wrong_input.contains(EnumWrongInputBetRegistry.TOTAL_VALUE_BETTED))
            totalValueBettedField.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        gridPane.add(totalValueBettedField, 1, 4);

        Label possibleWinnings = new Label("Possible winnings:");
        gridPane.add(possibleWinnings, 0, 5);

        TextField possibleWinningsField= new TextField();
        if(wrong_input.contains(EnumWrongInputBetRegistry.POSSIBLE_WINNINGS))
            possibleWinningsField.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        gridPane.add(possibleWinningsField, 1, 5);

        Label numberOfBets = new Label("Number of bets:");
        gridPane.add(numberOfBets, 0, 6);

        TextField numberOfBetsField= new TextField();
        if(wrong_input.contains(EnumWrongInputBetRegistry.NUMBER_OF_BETS))
            numberOfBetsField.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        gridPane.add(numberOfBetsField, 1, 6);

        Label betName = new Label("Bet name:");
        gridPane.add(betName, 0, 7);

        TextField betNameField= new TextField();
        if(wrong_input.contains(EnumWrongInputBetRegistry.BET_NAME))
            betNameField.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
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
                    checkBoxPendent.setSelected(false);
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

        setTop(betRegistryTitle);
        setCenter(gridPane);
        setBottom(containerButtons);

        btnSave.setOnMouseClicked(event -> {

            if (event.getButton() == MouseButton.PRIMARY) {

                String possibleWinningsValue = possibleWinningsField.getText();
                String numOfGamesBettedValue = numberOfGamesBettedField.getText();
                String betNameValue = betNameField.getText();
                String totalValueBettedValue = totalValueBettedField.getText();
                String numberOfBetsValue = numberOfBetsField.getText();
                LocalDate registDateValue = registDatePicker.getValue();
                LocalDate closeDateValue = closeDatePicker.getValue();

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
      //              obsModel.addNewBet(numOfGamesBettedValue, registDateValue, closeDateValue, totalValueBettedValue, possibleWinningsValue, numberOfBetsValue
      //                      , betNameValue, enumBetStatus);
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
                }


            }
        });

        btnCancel.setOnMouseClicked(event->{
            if(event.getButton() == MouseButton.PRIMARY){
       //         obsModel.cancelBetRegistry();
            }
        });

    }
    private void propsListener() {
        obsModel.addPropertyChangeListener(Constants.STATE_PROP,
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        setVisible(obsModel.getState() == EnumStates.BET_REGISTRY);
                        System.out.println("propertyChange");
                    }
                }
        );
        obsModel.addPropertyChangeListener(Constants.WRONG_INPUT_BET_REGISTRY,
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
         //               ArrayList<EnumWrongInputBetRegistry> wrong_input = obsModel.getBetRegistryWrongInput();
          //              ViewWithWrongInputs(wrong_input);
                        System.out.println("propertyChange");
                    }
                }
        );
    }
}
