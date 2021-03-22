package be.kdg.java.view.settings;

import be.kdg.java.model.Game;
import be.kdg.java.view.chart.ChartPresenter;
import be.kdg.java.view.chart.ChartView;
import be.kdg.java.view.game.GamePresenter;
import be.kdg.java.view.game.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class SettingsPresenter {
    private final Game model;
    private final SettingsView view;
    private GameView game;

    public SettingsPresenter(Game model, SettingsView view) {
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
        view.getMusicButton().setOnAction(event -> {
            if (musicButton.isSelected()) {
                menuPlayer.pause();
            }else {
                menuPlayer.play();
            }
        });
    }

    private void updateView() {
        // Vult de view met data uit model
    }
}
