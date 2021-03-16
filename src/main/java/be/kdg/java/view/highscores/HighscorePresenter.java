package be.kdg.java.view.highscores;

import be.kdg.java.model.Game;
import be.kdg.java.view.chart.ChartPresenter;
import be.kdg.java.view.chart.ChartView;
import be.kdg.java.view.game.GamePresenter;
import be.kdg.java.view.game.GameView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

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

        view.getStatsButton().setOnAction(
                new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent actionEvent) {
                        ChartView chartView = new ChartView();
                        ChartPresenter chartPresenter = new ChartPresenter(model, chartView);
                        view.getScene().setRoot(chartView);
                        chartView.getScene().getWindow().sizeToScene();
                    }
                }
        );


    }

    private void updateView() {

        view.getHighscores().setItems(FXCollections.observableArrayList(model.getUserSortedByHighscore()));
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
