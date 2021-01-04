package gui;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class ToggleSwitch extends HBox {
    boolean onOrOff;

    private final Label label = new Label();
    private final Button button = new Button();

    private SimpleBooleanProperty switchedOn = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty switchOnProperty() { return switchedOn; }

    private void init() {

        label.setText("OFF");

        getChildren().addAll(label, button);
        button.setOnAction((e) -> {
            switchedOn.set(!switchedOn.get());
        });
        label.setOnMouseClicked((e) -> {
            switchedOn.set(!switchedOn.get());

        });
        setStyle();
        bindProperties();
    }

    private void setStyle() {
        //Default Width
        setWidth(80);
        label.setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: grey; -fx-text-fill:black; -fx-background-radius: 4;");
        setAlignment(Pos.CENTER_LEFT);
    }

    private void bindProperties() {
        label.prefWidthProperty().bind(widthProperty().divide(2));
        label.prefHeightProperty().bind(heightProperty());
        button.prefWidthProperty().bind(widthProperty().divide(2));
        button.prefHeightProperty().bind(heightProperty());
    }

    public ToggleSwitch() {
        init();
        switchedOn.addListener((a,b,c) -> {
            if (c) {
                label.setText("ON");
                setStyle("-fx-background-color: green;");
                label.toFront();
                onOrOff = true;
            }
            else {
                label.setText("OFF");
                setStyle("-fx-background-color: grey;");
                button.toFront();
                onOrOff = false;
            }
        });
    }

    public boolean isOnOrOff() {
        return onOrOff;
    }

    public void setOnOrOff(boolean onOrOff) {
        if(onOrOff) {
            label.setText("ON");
            setStyle("-fx-background-color: green;");
            label.toFront();
        }
        else {
            label.setText("OFF");
            label.setText("OFF");
            setStyle("-fx-background-color: grey;");
            button.toFront();
        }
        this.onOrOff = onOrOff;
    }
}