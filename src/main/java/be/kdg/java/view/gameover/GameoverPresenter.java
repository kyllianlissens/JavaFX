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

import java.io.File;

public class GameoverPresenter {
    private final Game model;
    private final GameoverView view;
    private Media pick;
    private MediaPlayer player;
    private boolean firstPlaced;



    public GameoverPresenter(Game model, GameoverView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
        firstPlaced = false;
        File f = new File("resources/music/gameover.mp3");
        pick = new Media(f.toURI().toString());
        player = new MediaPlayer(pick);
        player.play();

    }
    private void updateView()
    {

    }

    private void addEventHandlers ()
    {
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
        view.getCurrentScore().setText("Score: " + model.score);
        //Clear Game Pane


    }

}