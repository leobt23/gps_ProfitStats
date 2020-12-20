package gui;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.ObservableModel;


public class UIbettingHistory extends BorderPane {
    ObservableModel model;

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
        for(int i = 0; i < model.getNumberOfBets(); i++){
            //borderpane para itemlist
            BorderPane itemList = new BorderPane();
            //titulo(info)
            itemList.setTop(info);
            //Label id
            Label idLabel = new Label("ID:" + model.getBetId(i));
            idLabel.setTextFill(Color.BLACK);
            idLabel.setFont( new Font( "Arial", 12 ) );
            setLeft(idLabel);
            //Label
            //Label


        }
        setCenter(scrollPane);
    }

}
