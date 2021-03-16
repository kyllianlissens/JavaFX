package be.kdg.java.view.chart;

import be.kdg.java.model.Game;
import be.kdg.java.model.User;
import be.kdg.java.view.game.GamePresenter;
import be.kdg.java.view.game.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.XYChart;

public class ChartPresenter {
    private final Game model;
    private final ChartView view;

    public ChartPresenter(Game model, ChartView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getBackButton().setOnAction(
                new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent actionEvent) {
                        GameView gameView = new GameView();
                        GamePresenter gamePresenter = new GamePresenter(model, gameView);
                        view.getScene().setRoot(gameView);
                        gameView.getScene().getWindow().sizeToScene();
                    }
                }
        );
    }

    private void updateView() {
        XYChart.Series dataSeries1 = new XYChart.Series();
        for (User user : model.getUserSortedByHighscore()){
            dataSeries1.getData().add(new XYChart.Data(user.getUsername(), user.getHighscore()));
        }
        this.view.getBarChart().getData().add(dataSeries1);
    }
}
