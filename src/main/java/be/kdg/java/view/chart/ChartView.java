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
        this.backButton.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),\n" +
                "        #9d4024,\n" +
                "        #d86e3a,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        this.barChart.setStyle("-fx-fill: black;\n" + "  -fx-font-weight: bold;\n" + "  -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 ); -fx-font-size:22px;");

    }

    public Button getBackButton() {
        return backButton;
    }

    public BarChart getBarChart() {
        return barChart;
    }

}
