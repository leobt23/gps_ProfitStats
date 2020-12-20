package gui;

import gui.left_panel.LeftPanel;
import javafx.scene.layout.BorderPane;

public class Root extends BorderPane {

    public Root()
    {
        setPrefSize(1000,600);
        LeftPanel leftPanel = new LeftPanel();
        setLeft(leftPanel);
    }

}

