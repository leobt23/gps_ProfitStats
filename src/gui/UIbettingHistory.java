package gui;

import gui.resources.Constants;
import gui.resources.Images;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.EnumBetStatus;
import logic.EnumWrongInputBetRegistry;
import logic.ObservableModel;
import logic.data.PropertyChanges;
import logic.data.Time;
import logic.states.EnumStates;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.ArrayList;


public class UIbettingHistory extends BorderPane {
    ObservableModel obsModel;
    private int idx;
    String possibleWinningsValue;
    String numOfGamesBettedValue;
    String betNameValue;
    String totalValueBettedValue;
    String numberOfBetsValue;
    LocalDate registDateValue;
    LocalDate closeDateValue;
    EnumBetStatus enumBetStatus;

    public UIbettingHistory(ObservableModel model) {
        this.obsModel = model;
        propsListener();
        drawView();

    }

    private void drawView(){
        //lABEL DO TITULO
        Label title = new Label("BETS HISTORY");
        title.setTextFill(Color.BLACK);
        title.setFont( new Font( "Arial", 30 ) );
        setTop(title);
        //Label info
        Label info = new Label("Info");
        info.setTextFill(Color.BLACK);
        info.setFont( new Font( "Arial", 12 ) );


        //SCROLL PANE
        ScrollPane scrollPane = new ScrollPane();
        //SCROLL PANE VBOX
        VBox scrollPaneVBox = new VBox();
        idx = 0;
        for(int i = 0; i < obsModel.getNumberOfBets(); i++){
            //idx
            idx = i;
            //borderpane itemlist
            BorderPane itemList = new BorderPane();
            //title(info)
            itemList.setTop(info);
            //Label id
            Label idLabel = new Label("ID: " + obsModel.getBetId(i));
            idLabel.setTextFill(Color.BLACK);
            idLabel.setFont( new Font( "Arial", 12 ) );
            //Image buttons panes creation
            Pane trash_bin = new Pane();
            trash_bin.setPrefSize(30,30);

            Pane edit_button = new Pane();
            edit_button.setPrefSize(30,30);

            //Image trashbin
            Image imageTrashBin = Images.getImage(Constants.TRASH_BIN_ICON);
            ImageView trashBinImageView = new ImageView(imageTrashBin);
            trashBinImageView.setFitHeight(30);
            trashBinImageView.setFitWidth(30);
            trash_bin.getChildren().add(trashBinImageView);
            //Image editButton
            Image imageEdit = Images.getImage(Constants.EDIT_ICON);
            ImageView editImageView = new ImageView(imageEdit);
            editImageView.setFitHeight(30);
            editImageView.setFitWidth(30);
            edit_button.getChildren().add(editImageView);

            editImageView.setOnMouseClicked(event ->
            {
                if (event.getButton() == MouseButton.PRIMARY)
                {
                    createView(idx);
                } else
                {

                }
            });
            trashBinImageView.setOnMouseClicked(event ->
            {
                if (event.getButton() == MouseButton.PRIMARY)
                {
                    //         model.deleteBet(idx);
                } else
                {

                }
            });

            //Add to vbox
            VBox vBoxLeftId = new VBox();
            vBoxLeftId.getChildren().addAll(edit_button,idLabel,trash_bin);

            //Set left
            itemList.setLeft(vBoxLeftId);


            //Label betname
            Label betNameLabel = new Label("Bet name: " + obsModel.getBetName(i));
            betNameLabel.setTextFill(Color.BLACK);
            betNameLabel.setFont( new Font( "Arial", 10 ) );
            //Label betRegistryDate
            Label betRegistryDateLabel = new Label("Registry date: " + obsModel.getBetRegistryDate(i));
            betRegistryDateLabel.setTextFill(Color.BLACK);
            betRegistryDateLabel.setFont( new Font( "Arial", 10 ) );
            //Label betRegistryDate
            Label betCloseDateLabel = new Label("Close date: " + obsModel.getBetCloseDate(i));
            betCloseDateLabel.setTextFill(Color.BLACK);
            betCloseDateLabel.setFont( new Font( "Arial", 10 ) );
            //Label numberOfGames
            Label betNumberOfGamesLable = new Label("Number of games: " + obsModel.getBetNumberOfGames(i));
            betNumberOfGamesLable.setTextFill(Color.BLACK);
            betNumberOfGamesLable.setFont( new Font( "Arial", 10 ) );
            //Label numberOfBets
            Label betNumberOfBets = new Label("Number of bets(qty): " + obsModel.getBetNumberOfBets(i));
            betNumberOfBets.setTextFill(Color.BLACK);
            betNumberOfBets.setFont( new Font( "Arial", 10 ) );
            //Label ValueBetted
            Label betValueBetted = new Label("Value betted: " + obsModel.getBetValueBetted(i));
            betValueBetted.setTextFill(Color.BLACK);
            betValueBetted.setFont( new Font( "Arial", 10 ) );
            //Label possibleWinnings
            Label betPossibleWinnings = new Label("Possible winnings: " + obsModel.getBetPossibleWinnings(i));
            betPossibleWinnings.setTextFill(Color.BLACK);
            betPossibleWinnings.setFont( new Font( "Arial", 10 ) );
            //Container Center
            HBox hBox = new HBox();
            //Containers left and right sides
            VBox vBoxRight = new VBox();
            VBox vBoxLeft = new VBox();
            vBoxLeft.getChildren().addAll(betNameLabel,betRegistryDateLabel,betCloseDateLabel,betNumberOfGamesLable);
            vBoxRight.getChildren().addAll(betNumberOfBets,betValueBetted,betPossibleWinnings);


            //Set center using hbox with the vbox
            hBox.getChildren().addAll(vBoxLeft,vBoxRight);
            itemList.setCenter(hBox);
            //Vbox to status
            VBox statusVbox = new VBox();
            if(obsModel.getBetStatus(i) == EnumBetStatus.PENDENT){
                Label statusTitleLabel = new Label("Status");
                statusTitleLabel.setTextFill(Color.BLACK);
                statusTitleLabel.setFont( new Font( "Arial", 12 ) );

                //Create Panes
                Pane markPane = new Pane();
                markPane.setPrefSize(50,50);
                Pane crossPane = new Pane();
                crossPane.setPrefSize(50,50);
                //Create images
                Image markImage = Images.getImage(Constants.MARK_ICON);
                Image crossImage = Images.getImage(Constants.CROSS_ICON);
                //Create imagesViews
                ImageView markIV = new ImageView(markImage);
                markIV.setFitWidth(50);
                markIV.setFitHeight(50);

                ImageView crossIV = new ImageView(crossImage);
                crossIV.setFitHeight(50);
                crossIV.setFitWidth(50);

                //add IVs to panes
                markPane.getChildren().add(markIV);
                crossPane.getChildren().add(crossIV);

                //Label pendent
                Label statusLabel = new Label("Pendent");
                statusLabel.setTextFill(Color.BLACK);
                statusLabel.setFont( new Font( "Arial", 12 ) );

                //Hbox to contain panes
                HBox hBoxStatus = new HBox();
                hBoxStatus.getChildren().addAll(markPane,crossPane);

                statusVbox.getChildren().addAll(statusTitleLabel,hBoxStatus,statusLabel);
                //Clicks imagesViews
                markIV.setOnMouseClicked(event ->
                {
                    if (event.getButton() == MouseButton.PRIMARY)
                    {
                        obsModel.setBetStatus(obsModel.getBetId(idx), EnumBetStatus.WON);
                        drawView();
                    } else
                    {

                    }
                });
                crossIV.setOnMouseClicked(event ->
                {
                    if (event.getButton() == MouseButton.PRIMARY)
                    {
                        obsModel.setBetStatus(obsModel.getBetId(idx), EnumBetStatus.LOST);
                        drawView();
                    } else
                    {

                    }
                });

            }
            else{
                if(obsModel.getBetStatus(i) == EnumBetStatus.WON){
                    Label statusTitleLabel = new Label("Status");
                    statusTitleLabel.setTextFill(Color.BLACK);
                    statusTitleLabel.setFont( new Font( "Arial", 12 ) );

                    //Create Panes
                    Pane markPane = new Pane();
                    markPane.setPrefSize(50,50);
                    //Create images
                    Image markImage = Images.getImage(Constants.MARK_ICON);
                    //Create imagesViews
                    ImageView markIV = new ImageView(markImage);
                    markIV.setFitWidth(50);
                    markIV.setFitHeight(50);

                    //add IVs to panes
                    markPane.getChildren().add(markIV);

                    //Label pendent
                    Label statusLabel = new Label("Won");
                    statusLabel.setTextFill(Color.BLACK);
                    statusLabel.setFont( new Font( "Arial", 12 ) );


                    statusVbox.getChildren().addAll(statusTitleLabel,markPane,statusLabel);
                }
                else{
                    if(obsModel.getBetStatus(i) == EnumBetStatus.LOST){
                        Label statusTitleLabel = new Label("Status");
                        statusTitleLabel.setTextFill(Color.BLACK);
                        statusTitleLabel.setFont( new Font( "Arial", 12 ) );

                        //Create Panes
                        Pane crossPane = new Pane();
                        crossPane.setPrefSize(50,50);
                        //Create images
                        Image crossImage = Images.getImage(Constants.CROSS_ICON);
                        //Create imagesViews
                        ImageView crossIV = new ImageView(crossImage);
                        crossIV.setFitWidth(50);
                        crossIV.setFitHeight(50);

                        //add IVs to panes
                        crossPane.getChildren().add(crossIV);

                        //Label pendent
                        Label statusLabel = new Label("Lost");
                        statusLabel.setTextFill(Color.BLACK);
                        statusLabel.setFont( new Font( "Arial", 12 ) );


                        statusVbox.getChildren().addAll(statusTitleLabel,crossPane,statusLabel);
                    }
                }


            }
            itemList.setRight(statusVbox);







            //add borderpane to vbox

            scrollPaneVBox.getChildren().add(itemList);


        }
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setContent(scrollPaneVBox);
        scrollPane.setFitToWidth(true);
        setCenter(scrollPane);
    }

    private void createView(int idx) {
        possibleWinningsValue = String.valueOf(obsModel.getBetPossibleWinnings(idx));
        numOfGamesBettedValue = String.valueOf(obsModel.getBetNumberOfGames(idx));
        betNameValue = String.valueOf(obsModel.getBetName(idx));
        totalValueBettedValue = String.valueOf(obsModel.getBetValueBetted(idx));
        numberOfBetsValue = String.valueOf(obsModel.getBetNumberOfBets(idx));
        Time registDate = obsModel.getBetRegistryDate(idx);
        registDateValue = LocalDate.of(registDate.getYear(), registDate.getMonth(), registDate.getDay());
        Time closeDate = obsModel.getBetCloseDate(idx);
        closeDateValue = LocalDate.of(closeDate.getYear(),closeDate.getMonth(),closeDate.getDay());
        enumBetStatus = obsModel.getBetStatus(idx);

        //TITLE
        Label betRegistryTitle = new Label("BET EDIT");
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
        numberOfGamesBettedField.setText(numOfGamesBettedValue);
        gridPane.add(numberOfGamesBettedField, 1, 1);

        Label registDateLabel = new Label("Bet regist date:");
        gridPane.add(registDateLabel, 0, 2);

        DatePicker registDatePicker = new DatePicker(registDateValue);
        registDatePicker.setOnAction(event -> {
            // LocalDate date = registDatePicker.getValue();
        });
        gridPane.add(registDatePicker,1,2);

        Label closeDateLabel = new Label("Bet close date:");
        gridPane.add(closeDateLabel, 0, 3);

        DatePicker closeDatePicker = new DatePicker(closeDateValue);
        closeDatePicker.setOnAction(event -> {
            LocalDate date = closeDatePicker.getValue();
        });

        gridPane.add(closeDatePicker,1,3);

        Label totalValueBetted = new Label("Total value betted:");
        gridPane.add(totalValueBetted, 0, 4);

        TextField totalValueBettedField= new TextField();

        totalValueBettedField.setText(totalValueBettedValue);
        gridPane.add(totalValueBettedField, 1, 4);

        Label possibleWinnings = new Label("Possible winnings:");
        gridPane.add(possibleWinnings, 0, 5);

        TextField possibleWinningsField= new TextField();

        possibleWinningsField.setText(possibleWinningsValue);
        gridPane.add(possibleWinningsField, 1, 5);

        Label numberOfBets = new Label("Number of bets:");
        gridPane.add(numberOfBets, 0, 6);

        TextField numberOfBetsField= new TextField();

        numberOfBetsField.setText(numberOfBetsValue);

        gridPane.add(numberOfBetsField, 1, 6);

        Label betName = new Label("Bet name:");
        gridPane.add(betName, 0, 7);

        TextField betNameField= new TextField();

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
                            "Bet successfuly edited!", ButtonType.OK);
                    // show the dialog
                    a1.showAndWait();
                    drawView();
                }
                else{
                    Alert a1 = new Alert(Alert.AlertType.NONE,
                            "Input error(s)!", ButtonType.OK);
                    // show the dialog
                    a1.showAndWait();
                    ViewWithWrongInputs(obsModel.getWrongInputBetRegistry(),idx);
                }


            }
        });

        btnCancel.setOnMouseClicked(event->{
            if(event.getButton() == MouseButton.PRIMARY){
                drawView();
            }
        });
    }

    private void ViewWithWrongInputs(ArrayList<EnumWrongInputBetRegistry> wrong_input,int idx){

        //TITLE
        Label betRegistryTitle = new Label("BET EDIT");
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
                            "Bet successfuly edited!", ButtonType.OK);
                    // show the dialog
                    a1.showAndWait();
                }
                else{
                    Alert a1 = new Alert(Alert.AlertType.NONE,
                            "Input error(s)!", ButtonType.OK);
                    // show the dialog
                    a1.showAndWait();
                    ViewWithWrongInputs(obsModel.getWrongInputBetRegistry(),idx);
                }


            }
        });

        btnCancel.setOnMouseClicked(event->{
            if(event.getButton() == MouseButton.PRIMARY){
                drawView();
            }
        });

    }

    private void propsListener() {
        obsModel.addPropertyChangeListener(PropertyChanges.STATE_CHANGE,
                evt -> {
                    setVisible(obsModel.getState() == EnumStates.BETS_HISTORY);
                    drawView();
                    System.out.println("propertyChange");
                }
        );
        obsModel.addPropertyChangeListener(Constants.UPDATE_BETS_HISTORY,
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        //TODO: SEE IF IT UPDATES WHEN DELETES OR IF IT NEEDS A NEW METHOD
                        System.out.println("propertyChange");
                    }
                }
        );
    }

}
