package be.kdg.java.view.game;


import be.kdg.java.model.Game;
import be.kdg.java.view.highscores.HighscorePresenter;
import be.kdg.java.view.highscores.HighscoreView;
import be.kdg.java.view.settings.SettingsPresenter;
import be.kdg.java.view.settings.SettingsView;


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

        view.getSettingsButton().setOnAction(
                actionEvent -> {
                    SettingsView settingsView = new SettingsView();
                    SettingsPresenter settingsPresenter = new SettingsPresenter(model, settingsView);
                    view.getScene().setRoot(settingsView);
                    settingsView.getScene().getWindow().sizeToScene();
                }
        );
    }

    private void updateView() {
        //GridPane.setRowIndex(tile, i);
        //GridPane.setColumnIndex(tile, j);
        //gameBoard.getChildren().addAll(tile, text);
        //tile.setOnMouseClicked(event -> drawMove(text));

    }
}
