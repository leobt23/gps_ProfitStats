package gui;

import gui.left_panel.LeftPanel;
import gui.money_stats.MoneyStats;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import logic.ObservableModel;

public class Root extends BorderPane {
    ObservableModel model;

    public Root(ObservableModel model)
    {
        this.model = model;
        setPrefSize(1280,800);
        LeftPanel leftPanel = new LeftPanel(model);
        setLeft(leftPanel);

        StackPane stack = new StackPane();
        MoneyStats statistics = new MoneyStats(model);
        UIbetRegistry betRegistry =  new UIbetRegistry(model);
        UInotifications notifications = new UInotifications(model);
        betRegistry.setVisible(true);
        statistics.setVisible(false);
        notifications.setVisible(false);
        stack.getChildren().add(statistics);
        stack.getChildren().add(betRegistry);
        stack.getChildren().add(notifications);
//        UIbettingHistory uIbettingHistory = new UIbettingHistory(model);
//        setCenter(new UIbetRegistry(model));
        setCenter(stack);
    }

    public Root() {

    }
}

