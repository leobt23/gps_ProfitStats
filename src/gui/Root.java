package gui;

import gui.left_panel.LeftPanel;
import gui.money_stats.MoneyStats;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
        if(model.getNotificationRemindMinBetDay()){
            Alert a1bet = new Alert(Alert.AlertType.NONE,
                    "Don't forget to bet " +model.getReminderToBetDay() + "€! Good luck!", ButtonType.OK);
            a1bet.setTitle("Welcome to a new day!");
            // show the dialog
            a1bet.showAndWait();
            model.saveModel();
        }
    }

    public Root() {

    }
}

