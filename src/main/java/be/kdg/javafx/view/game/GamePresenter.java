package be.kdg.javafx.view.game;


import be.kdg.javafx.model.Game;
import be.kdg.javafx.view.JavaFXView;
import be.kdg.javafx.view.highscores.HighscorePresenter;
import be.kdg.javafx.view.highscores.HighscoreView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class GamePresenter {
    private Game model;
    private GameView view;

    public GamePresenter(Game model, GameView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getHighscoresButton().setOnAction(
                actionEvent -> {
                    HighscoreView highscoresView = new HighscoreView();
                    HighscorePresenter highscoresPresenter = new HighscorePresenter(model, highscoresView);
                    view.getScene().setRoot(highscoresView);
                    highscoresView.getScene().getWindow().sizeToScene();
                }
        );
    }

    private void updateView() {
        // Vult de view met data uit model
    }
}
