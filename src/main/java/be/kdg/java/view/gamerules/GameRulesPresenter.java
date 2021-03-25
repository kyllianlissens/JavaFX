package be.kdg.java.view.gamerules;

import be.kdg.java.model.Game;
import be.kdg.java.view.game.GamePresenter;
import be.kdg.java.view.game.GameView;

public class GameRulesPresenter {
    private final Game model;
    private final GameRulesView view;
    public GameRulesPresenter(Game model, GameRulesView view) {
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

    }

    private void updateView() {


    }
}
