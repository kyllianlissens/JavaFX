package be.kdg.java.view.gameover;

import be.kdg.java.model.Game;
import be.kdg.java.view.game.GamePresenter;
import be.kdg.java.view.game.GameView;
import be.kdg.java.view.settings.SettingsView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameoverPresenter {
    private final Game model;
    private final GameoverView view;


    public GameoverPresenter(Game model, GameoverView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
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