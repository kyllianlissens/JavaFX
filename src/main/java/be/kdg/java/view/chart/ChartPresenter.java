package be.kdg.java.view.chart;

import be.kdg.java.model.Game;
import be.kdg.java.model.User;
import javafx.scene.chart.XYChart;

public class ChartPresenter {
    private Game model;
    private ChartView view;

    public ChartPresenter(Game model, ChartView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {

    }

    private void updateView() {
        XYChart.Series dataSeries1 = new XYChart.Series();
        for (User user : model.getUserSortedByHighscore()){
            dataSeries1.getData().add(new XYChart.Data(user.getUsername(), user.getHighscore()));
        }
        this.view.getBarChart().getData().add(dataSeries1);
    }
}
