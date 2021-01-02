package gui.left_panel;

import gui.resources.Images;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import logic.ObservableModel;
import logic.data.PropertyChanges;
import logic.states.EnumStates;

import java.beans.PropertyChangeEvent;

public class LeftPanel extends Pane {

    private static final int ROW_HEIGHT = 100;

    private final ObservableModel obsModel;
    private VBox panelContainer;

    public LeftPanel(ObservableModel obsModel) {
        this.obsModel = obsModel;
        registerPropertyObservers();
        draw();
    }

    private void addPanelElement(String designation)
    {
        HBox hBox = new HBox();
        hBox.setPrefSize(panelContainer.getWidth(), ROW_HEIGHT);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setSpacing(20);
        hBox.setPadding(new Insets(0, 0, 0, 20));

        //TODO: Adicionar restantes
        hBox.setOnMouseClicked( e -> {
            switch (designation){
                case PanelElements.STATISTICS:
                    obsModel.moveToStatistics();
                    break;
                case PanelElements.BET_REGISTRY:
                    obsModel.moveToBetRegistry();
                    break;
                case PanelElements.NOTIFICATIONS:
                    obsModel.moveToNotifications();
                    break;
                case PanelElements.USER_PROFILE:
                    obsModel.moveToUserProfile();
                    break;
                case PanelElements.BETS_HISTORY:
                    obsModel.moveToBetsHistory();
                    break;
            }
        });

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
        getChildren().clear();
        panelContainer = new VBox();
        panelContainer.setPrefWidth(Constants.PANEL_WIDTH);
        panelContainer.setBackground(
                new Background(
                        new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)
                ));
        panelContainer.setBorder(
                new Border(
                        new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY, new BorderWidths(2))
                )
        );
        getChildren().add(panelContainer);

        addPanelElement(PanelElements.USER_PROFILE);
        addPanelElement(PanelElements.STATISTICS);
        addPanelElement(PanelElements.BETS_HISTORY);
        addPanelElement(PanelElements.BET_REGISTRY);
        addPanelElement(PanelElements.NOTIFICATIONS);

        switch (obsModel.getState()) {
            case USER_PROFILE -> setActiveElement( (HBox) panelContainer.getChildren().get(0));
            case STATISTICS -> setActiveElement( (HBox) panelContainer.getChildren().get(1));
            case BETS_HISTORY -> setActiveElement( (HBox) panelContainer.getChildren().get(2));
            case BET_REGISTRY -> setActiveElement( (HBox) panelContainer.getChildren().get(3));
            case NOTIFICATIONS -> setActiveElement( (HBox) panelContainer.getChildren().get(4));
        }

    }

    private void setActiveElement(HBox element) {
        element.setBackground(new Background(
                new BackgroundFill(
                        Color.LIGHTSKYBLUE,
                        CornerRadii.EMPTY,
                        Insets.EMPTY)
        ));
        element.setBorder(
                new Border(
                        new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK,Color.BLACK,
                                BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE,
                                BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE,
                                CornerRadii.EMPTY, new BorderWidths(1.5), Insets.EMPTY)
                )
        );
    }

    private void registerPropertyObservers() {
        obsModel.addPropertyChangeListener(PropertyChanges.STATE_CHANGE, (PropertyChangeEvent evt) -> {
            draw();
        });
    }

}
