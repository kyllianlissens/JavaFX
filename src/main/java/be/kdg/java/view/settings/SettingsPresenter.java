package be.kdg.java.view.settings;

import be.kdg.java.model.Game;
import be.kdg.java.view.game.GamePresenter;
import be.kdg.java.view.game.GameView;
import javafx.scene.input.KeyCode;


public class SettingsPresenter {
    private final Game model;
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
            if (model.isPlayMusic()) {
                model.setPlayMusic(false);
                model.getMediaPlayer().pause();
            } else {
                model.setPlayMusic(true);
                model.getMediaPlayer().play();
            }
        });

        view.getSaveButton().setOnAction(event -> {
            model.getGameBoard().setSizeY(Integer.parseInt(view.getRowInput().getText()));
            model.getGameBoard().setSizeX(Integer.parseInt(view.getColumnInput().getText()));
        });

        view.getRowInput().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                model.getGameBoard().setSizeY(Integer.parseInt(view.getRowInput().getText()));
            }
        });
        view.getColumnInput().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                model.getGameBoard().setSizeX(Integer.parseInt(view.getColumnInput().getText()));
            }
        });


    }

    private void updateView() {
        view.getMusicButton().setSelected(model.isPlayMusic());
        view.getColumnInput().setText(String.valueOf(model.getGameBoard().getSizeX()));
        view.getRowInput().setText(String.valueOf(model.getGameBoard().getSizeY()));
    }
}
