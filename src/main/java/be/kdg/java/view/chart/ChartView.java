package be.kdg.java.view.chart;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ChartView extends BorderPane {

    private BarChart barChart;
    private Button backButton;
    private HBox buttonHBox;

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

        this.buttonHBox = new HBox(10);
        this.backButton = new Button("Back");

    }

    private void layoutNodes() {
        this.setPadding(new Insets(25, 25, 25, 25));
        this.setCenter(barChart);
        this.barChart.setLegendVisible(false);
        this.buttonHBox.setAlignment(Pos.CENTER);
        this.buttonHBox.getChildren().addAll(this.backButton);
        this.setBottom(buttonHBox);
        setStyle("-fx-background-image: url(images/wood.jpg);-fx-background-size: cover;");
        this.backButton.getStyleClass().add("backButton");
        this.barChart.getStyleClass().add("barChart");
    }

    public Button getBackButton() {
        return backButton;
    }

    public BarChart getBarChart() {
        return barChart;
    }

}
