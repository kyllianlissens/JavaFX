package be.kdg.java.view.chart;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.BorderPane;

public class ChartView extends BorderPane {

    private BarChart barChart;
    public ChartView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    private void initialiseNodes() {


        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Players");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Highscore");

        this.barChart = new BarChart(xAxis, yAxis);
    }

    private void layoutNodes() {
        this.setCenter(barChart);

    }

    public BarChart getBarChart() {
        return barChart;
    }
}
