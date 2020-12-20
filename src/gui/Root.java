package gui;


import Logic.Model;
import gui.left_panel.LeftPanel;
import javafx.scene.layout.BorderPane;

public class Root extends BorderPane {
    Model model;

    public Root(Model model)
    {
        this.model = model;
        setPrefSize(1000,600);
        LeftPanel leftPanel = new LeftPanel();
        setLeft(leftPanel);
        UIbettingHistory uIbettingHistory = new UIbettingHistory(model);
    }

}

