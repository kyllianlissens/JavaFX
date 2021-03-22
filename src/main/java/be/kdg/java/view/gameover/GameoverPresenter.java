package be.kdg.java.view.gameover;

import be.kdg.java.model.Game;
import be.kdg.java.view.game.GamePresenter;
import be.kdg.java.view.game.GameView;
import be.kdg.java.view.settings.SettingsView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;

public class GameoverPresenter {
    private final Game model;
    private final GameoverView view;
    private final Media pick;
    private final MediaPlayer player;


    public GameoverPresenter(Game model, GameoverView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
        File f = new File("resources/music/gameover.mp3");
        pick = new Media(f.toURI().toString());
        player = new MediaPlayer(pick);
        player.play();

    }

    private void updateView() {

    }

    private void addEventHandlers() {
        view.getBackButton().setOnAction(
                actionEvent -> {
                    final Stage stage = (Stage) view.getScene().getWindow();
                    stage.close();
                }
        );
        view.getCurrentScore().setText("Score: " + model.score);
        view.getHighScore().setText("Highscore: " + model.getUser().getHighscore());

    }

}