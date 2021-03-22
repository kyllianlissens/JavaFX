package be.kdg.java.view.highscores;

import be.kdg.java.model.Game;
import be.kdg.java.view.chart.ChartPresenter;
import be.kdg.java.view.chart.ChartView;
import be.kdg.java.view.game.GamePresenter;
import be.kdg.java.view.game.GameView;
import javafx.collections.FXCollections;

public class HighscorePresenter {
    private final Game model;
    private final HighscoreView view;

    public HighscorePresenter(Game model, HighscoreView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getBackButton().setOnAction(
                actionEvent -> {
                    GameView gameView = new GameView();
                    new GamePresenter(model, gameView);
                    view.getScene().setRoot(gameView);
                    gameView.getScene().getWindow().sizeToScene();
                }
        );

        view.getStatsButton().setOnAction(
                actionEvent -> {
                    ChartView chartView = new ChartView();
                    new ChartPresenter(model, chartView);
                    view.getScene().setRoot(chartView);
                    chartView.getScene().getWindow().sizeToScene();
                }
        );


    }

    private void updateView() {

        view.getHighscores().setItems(FXCollections.observableArrayList(model.getUserSortedByHighscore()));
    }

}
