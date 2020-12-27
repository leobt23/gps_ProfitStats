package gui;

import gui.left_panel.LeftPanel;
import gui.money_stats.MoneyStats;
import javafx.scene.layout.BorderPane;
import logic.ObservableModel;

public class Root extends BorderPane {
    ObservableModel model;

    public Root(ObservableModel model)
    {
        this.model = model;
        setPrefSize(1000,600);
        LeftPanel leftPanel = new LeftPanel();
        setLeft(leftPanel);

        MoneyStats statistics = new MoneyStats(model);
        setCenter(statistics);
//        UIbettingHistory uIbettingHistory = new UIbettingHistory(model);
        setCenter(new UIbetRegistry(model));
    }

    public Root() {

    }
}

