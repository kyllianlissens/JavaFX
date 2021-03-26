package be.kdg.java.view.gameover;

import be.kdg.java.model.Game;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
        view.getCurrentScore().setText("Score: " + model.getScore());
        view.getHighScore().setText("Highscore: " + model.getUser().getHighscore());

    }

}