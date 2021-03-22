package be.kdg.java.view.settings;

import be.kdg.java.model.Game;
import be.kdg.java.view.chart.ChartPresenter;
import be.kdg.java.view.chart.ChartView;
import be.kdg.java.view.game.GamePresenter;
import be.kdg.java.view.game.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.media.MediaPlayer;


public class SettingsPresenter {
    private Game model;
    private final SettingsView view;

    public SettingsPresenter(Game model, SettingsView view) {
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

        view.getMusicButton().setOnAction(event -> {
            if (model.getMediaPlayer().getStatus().equals(MediaPlayer.Status.PLAYING)) {
                model.getMediaPlayer().pause();
            }else {
                model.getMediaPlayer().play();
                model.getMediaPlayer().setVolume(0.05);
            }
        });

        view.getRowInput().setOnKeyPressed(event ->{
            if( event.getCode() == KeyCode.ENTER ) {
                model.getGameBoard().setSizeY(Integer.parseInt(view.getRowInput().getText()));

            }
        });
        view.getColumnInput().setOnKeyPressed(event ->{
            if( event.getCode() == KeyCode.ENTER ) {
                model.getGameBoard().setSizeX(Integer.parseInt(view.getColumnInput().getText()));

            }
        });


    }

    private void updateView() {
        view.getMusicButton().setSelected(model.getMediaPlayer().getStatus().equals(MediaPlayer.Status.PLAYING));
        view.getColumnInput().setText(String.valueOf(model.getGameBoard().getSizeX()));
        view.getRowInput().setText(String.valueOf(model.getGameBoard().getSizeY()));
    }
}
