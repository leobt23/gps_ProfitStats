package gui.money_stats;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.ObservableModel;
import logic.states.EnumStates;

import java.beans.PropertyChangeEvent;

public class MoneyStats extends BorderPane {
    private final ObservableModel obsModel;

    public MoneyStats (ObservableModel obsModel) {
        this.obsModel = obsModel;

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


        profitGraphic();
//        registerPropertyObservers();
    }

    private void profitGraphic() {
        getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);

        bc.setTitle("Profit");
        xAxis.setLabel("Month");
        yAxis.setLabel("Profit (€)");

        bc.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Income");
        series1.getData().add(new XYChart.Data("abril", 25.34));
        series1.getData().add(new XYChart.Data("maio", 201.82));
        series1.getData().add(new XYChart.Data("junho", 100));
        series1.getData().add(new XYChart.Data("julho", 13));
        series1.getData().add(new XYChart.Data("agosto", 0));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Outcome");
        series2.getData().add(new XYChart.Data("abril", 30));
        series2.getData().add(new XYChart.Data("maio", 50));
        series2.getData().add(new XYChart.Data("junho", 10));
        series2.getData().add(new XYChart.Data("julho", 50));
        series2.getData().add(new XYChart.Data("agosto", 12));

        bc.getData().addAll(series1, series2);
        
        HBox hbGraphs = new HBox();
        hbGraphs.setPadding(new Insets(30));
        hbGraphs.getChildren().add(bc);

        setCenter(hbGraphs);
    }

    //TODO
    /*private void registerPropertyObservers() {
        obsModel.addPropertyChangeListener(PROP_STATE, (PropertyChangeEvent evt) -> {
            setVisible(obsModel.getState() == EnumStates.STATISTICS);
        });
    }*/
}
