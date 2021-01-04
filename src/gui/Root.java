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
        UserInterface userInterface = new UserInterface(model);
        UIbettingHistory uIbettingHistory = new UIbettingHistory(model);
        stack.getChildren().add(statistics);
        stack.getChildren().add(betRegistry);
        stack.getChildren().add(userInterface);
        stack.getChildren().add(notifications);
        stack.getChildren().add(uIbettingHistory);
        setCenter(stack);
        model.moveToBetRegistry();
    }

    public Root() {

    }
}

