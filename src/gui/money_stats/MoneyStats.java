package gui.money_stats;

import gui.resources.Constants;
import gui.resources.Images;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.ObservableModel;
import logic.data.PropertyChanges;
import logic.states.EnumStates;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class MoneyStats extends BorderPane {
    private final ObservableModel obsModel;
    private HBox hbGraphs;

    public MoneyStats (ObservableModel obsModel) {
        this.obsModel = obsModel;
        registerPropertyObservers();
        draw();
    }

    private void draw() {
        BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
        this.setBackground(new Background(new BackgroundImage(Images.getImage(Constants.STATISTICS_BACKGROUND),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize)));

        Label lTitle = new Label("Statistics");
        lTitle.setTextFill(Color.BLACK);
        lTitle.setFont(new Font( "Arial",24) );
        lTitle.setAlignment(Pos.CENTER);

        VBox hbTitleContainer = new VBox();
        hbTitleContainer.setAlignment(Pos.CENTER);
        hbTitleContainer.setPadding(new Insets(15));
        hbTitleContainer.setMaxWidth(250);
        hbTitleContainer.setBackground(new Background( new BackgroundFill(
                Color.LIGHTGRAY, new CornerRadii(5), Insets.EMPTY
        )));
        hbTitleContainer.setBorder(
                new Border(
                        new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                                new CornerRadii(5), new BorderWidths(2))
                )
        );
        hbTitleContainer.getChildren().add(lTitle);

        setTop(hbTitleContainer);
        BorderPane.setAlignment(hbTitleContainer, Pos.CENTER);
        BorderPane.setMargin(hbTitleContainer, new Insets(20,0,0,0));

        hbGraphs = new HBox();
        hbGraphs.setBackground(new Background(new BackgroundFill(
                Color.rgb(255,255,255,0.7), new CornerRadii(5), Insets.EMPTY)
        ));
        hbGraphs.setPadding(new Insets(30));
        profitGraphic();
        betsGraphic();
        textStatistics();
    }

    private void profitGraphic() {
        getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String,Number> bcProfit =
                new BarChart<String,Number>(xAxis,yAxis);

        bcProfit.setTitle("Income/Loss (Actual month)");
        xAxis.setLabel("Weeks");
        yAxis.setLabel("Value (€)");

        ObservableList<String> catList = FXCollections.observableArrayList();
        catList.addAll("Week 1", "Week 2", "Week 3", "Week 4");
        xAxis.setCategories(catList);

        bcProfit.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        XYChart.Series incomeSeries = new XYChart.Series();
        incomeSeries.setName("Income");

        ArrayList<Float> incomePerWeek = obsModel.getWonMoneyCurrentMonth();
        for (int idx = 0; idx < incomePerWeek.size(); idx++) {
            incomeSeries.getData().add(new XYChart.Data(xAxis.getCategories().get(idx), incomePerWeek.get(idx)));
        }

        XYChart.Series outcomeSeries = new XYChart.Series();
        outcomeSeries.setName("Loss");

        ArrayList<Float> outcomePerWeek = obsModel.getLostMoneyCurrentMonth();
        for (int idx = 0; idx < outcomePerWeek.size(); idx++) {
            outcomeSeries.getData().add(new XYChart.Data(xAxis.getCategories().get(idx), -outcomePerWeek.get(idx)));
        }

        bcProfit.getData().addAll(incomeSeries, outcomeSeries);

        hbGraphs.getChildren().add(bcProfit);
    }

    private void betsGraphic() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number of bets");
        yAxis.setTickUnit(1);
        xAxis.setLabel("Months");

        final LineChart<String,Number> lineChart =
                new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Number of bets (per year)");

        XYChart.Series series = new XYChart.Series();
        series.setName("Bets");

        ArrayList<Integer> betPerMonths = obsModel.numberOfBetsMonth();
        ObservableList<String> catList = FXCollections.observableArrayList();
        catList.addAll("Jan", "Feb","Mar","Apr","May",
                "Jun","Jul","Aug","Sep","Oct","Nov","Dec");
        xAxis.setCategories(catList);
        for (int idx = 0; idx < betPerMonths.size(); idx++) {
            series.getData().add(new XYChart.Data(xAxis.getCategories().get(idx), betPerMonths.get(idx)));
        }

        lineChart.getData().add(series);

        hbGraphs.getChildren().add(lineChart);
        StackPane pane = new StackPane();
        pane.setPadding(new Insets(20));
        pane.getChildren().add(hbGraphs);

        setCenter(pane);
    }

    private void textStatistics() {
        Font lFont = Font.font("Arial", FontWeight.BOLD, 16);

        HBox hbWinPercentage = new HBox();
        hbWinPercentage.setSpacing(5);
        Label lWinPercentageTitle = new Label(String.format("Winning percentage: %.2f", obsModel.getWinningPercentage()) + "%");
        lWinPercentageTitle.setFont(lFont);
        lWinPercentageTitle.setTextFill(Color.WHITE);
        hbWinPercentage.getChildren().addAll(lWinPercentageTitle);

        HBox hbBestMonth = new HBox();
        Label lBestMonthTitle = new Label("Best month: " + (obsModel.getBestMonth() != null? obsModel.getBestMonth() : "None"));
        lBestMonthTitle.setFont(lFont);
        lBestMonthTitle.setTextFill(Color.WHITE);
        hbBestMonth.getChildren().addAll(lBestMonthTitle);

        VBox vbLeftContainer = new VBox();
        vbLeftContainer.getChildren().addAll(hbWinPercentage, hbBestMonth);

        HBox hbTotalProfit = new HBox();
        hbTotalProfit.setSpacing(5);
        Label lTotalProfitTitle = new Label("Total profit: " + obsModel.getTotalProfit() + "€");
        lTotalProfitTitle.setFont(lFont);
        lTotalProfitTitle.setTextFill(Color.WHITE);
        hbTotalProfit.getChildren().addAll(lTotalProfitTitle);

        HBox hbHighestWin = new HBox();
        hbHighestWin.setSpacing(5);
        Label lHighestWin = new Label("Highest win value: " + obsModel.getHighestWin() + "€");
        lHighestWin.setFont(lFont);
        lHighestWin.setTextFill(Color.WHITE);
        hbHighestWin.getChildren().addAll(lHighestWin);

        VBox vbRightContainer = new VBox();
        vbRightContainer.getChildren().addAll(hbTotalProfit, hbHighestWin);

        HBox hbBottomContainer = new HBox();
        hbBottomContainer.setPadding(new Insets(0, 0, 20, 0));
        hbBottomContainer.setAlignment(Pos.CENTER);
        hbBottomContainer.setSpacing(300);
        hbBottomContainer.getChildren().addAll(vbLeftContainer, vbRightContainer);
        setBottom(hbBottomContainer);
    }

    private void registerPropertyObservers() {
        obsModel.addPropertyChangeListener(PropertyChanges.STATE_CHANGE, (PropertyChangeEvent evt) -> {
            setVisible(obsModel.getState() == EnumStates.STATISTICS);
            if (isVisible()) {
                draw();
            }
        });
    }
}
