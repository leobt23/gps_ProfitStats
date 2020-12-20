package gui.left_panel;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import gui.resources.Images;

public class LeftPanel extends Pane {

    private static final int ROW_HEIGHT = 100;

    private final VBox panelContainer;

    public LeftPanel() {
        panelContainer = new VBox();
        panelContainer.setPrefWidth(Constants.PANEL_WIDTH);
        panelContainer.setBackground(
                new Background(
                        new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)
                ));

        getChildren().add(panelContainer);
        //TODO: registar observers

        draw();
    }

    private void addPanelElement(String designation)
    {
        HBox hBox = new HBox();
        hBox.setPrefSize(panelContainer.getWidth(), ROW_HEIGHT);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setSpacing(20);
        hBox.setPadding(new Insets(0, 0, 0, 20));
        hBox.setBorder(
                new Border(
                    new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                            CornerRadii.EMPTY, BorderWidths.DEFAULT)
                )
        );

        //TODO: Adicionar onClickListeners e ter map de Boxes (talvez)
//        hBox.setOnMouseClicked();

        ImageView imgView = new ImageView(Images.getImage(designation));
        imgView.setFitWidth(Constants.IMG_VIEW_WIDTH);
        imgView.setFitHeight(Constants.IMG_VIEW_HEIGHT);
        hBox.getChildren().add(imgView);

        Text tDesignation = new Text(designation);
        tDesignation.setFont(Font.font ("Verdana", FontWeight.BOLD,18));
        tDesignation.setFill(Color.BLACK);

        hBox.getChildren().add(tDesignation);
        panelContainer.getChildren().add(hBox);
    }

    private void draw()
    {
        addPanelElement(PanelElements.USER_PROFILE);
        addPanelElement(PanelElements.STATISTICS);
        addPanelElement(PanelElements.BETS_HISTORY);
        addPanelElement(PanelElements.BET_REGISTRY);
        addPanelElement(PanelElements.NOTIFICATIONS);
    }

}
