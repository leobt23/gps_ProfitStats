package gui;

import logic.ObservableModel;
import logic.data.PropertyChanges;
import logic.states.EnumStates;
import logic.EnumBetStatus;
import gui.resources.Constants;
import gui.resources.Images;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class UIbettingHistory extends BorderPane {
    ObservableModel model;
    private int idx;
    public UIbettingHistory(ObservableModel model) {
        this.model = model;
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
        for(int i = 0; i < model.getNumberOfBets(); i++){
            //idx
            idx = i;
            //borderpane itemlist
            BorderPane itemList = new BorderPane();
            //title(info)
            itemList.setTop(info);
            //Label id
            Label idLabel = new Label("ID: " + model.getBetId(i));
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
           //         model.editBetButton(idx);
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
            Label betNameLabel = new Label("Bet name: " + model.getBetName(i));
            betNameLabel.setTextFill(Color.BLACK);
            betNameLabel.setFont( new Font( "Arial", 10 ) );
            //Label betRegistryDate
            Label betRegistryDateLabel = new Label("Registry date: " + model.getBetRegistryDate(i));
            betRegistryDateLabel.setTextFill(Color.BLACK);
            betRegistryDateLabel.setFont( new Font( "Arial", 10 ) );
            //Label betRegistryDate
            Label betCloseDateLabel = new Label("Close date: " + model.getBetCloseDate(i));
            betCloseDateLabel.setTextFill(Color.BLACK);
            betCloseDateLabel.setFont( new Font( "Arial", 10 ) );
            //Label numberOfGames
            Label betNumberOfGamesLable = new Label("Number of games: " + model.getBetNumberOfGames(i));
            betNumberOfGamesLable.setTextFill(Color.BLACK);
            betNumberOfGamesLable.setFont( new Font( "Arial", 10 ) );
            //Label numberOfBets
            Label betNumberOfBets = new Label("Number of bets(qty): " + model.getBetNumberOfBets(i));
            betNumberOfBets.setTextFill(Color.BLACK);
            betNumberOfBets.setFont( new Font( "Arial", 10 ) );
            //Label ValueBetted
            Label betValueBetted = new Label("Value betted: " + model.getBetValueBetted(i));
            betValueBetted.setTextFill(Color.BLACK);
            betValueBetted.setFont( new Font( "Arial", 10 ) );
            //Label possibleWinnings
            Label betPossibleWinnings = new Label("Possible winnings: " + model.getBetPossibleWinnings(i));
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
            if(model.getBetStatus(i) == EnumBetStatus.PENDENT){
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
                        model.setBetStatus(model.getBetId(idx), EnumBetStatus.WON);
                    } else
                    {

                    }
                });
                crossIV.setOnMouseClicked(event ->
                {
                    if (event.getButton() == MouseButton.PRIMARY)
                    {
                        model.setBetStatus(model.getBetId(idx), EnumBetStatus.LOST);
                    } else
                    {

                    }
                });

            }
            else{
                if(model.getBetStatus(i) == EnumBetStatus.WON){
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
                    if(model.getBetStatus(i) == EnumBetStatus.LOST){
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

        propsListener();
    }

    private void propsListener() {
        model.addPropertyChangeListener(PropertyChanges.STATE_CHANGE,
                evt -> {
                    setVisible(model.getState() == EnumStates.BETS_HISTORY);
                    System.out.println("propertyChange");
                }
        );
        model.addPropertyChangeListener(Constants.UPDATE_BETS_HISTORY,
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
