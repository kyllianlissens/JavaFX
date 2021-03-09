package be.kdg.javafx.view.highscores;

import be.kdg.javafx.model.Game;
import be.kdg.javafx.model.User;
import be.kdg.javafx.view.game.GamePresenter;
import be.kdg.javafx.view.game.GameView;
import be.kdg.javafx.view.login.LoginView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class HighscorePresenter {
    private Game model;
    private HighscoreView view;

    public HighscorePresenter(Game model, HighscoreView view) {
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


    }

    private void updateView() {

        view.getHighscores().setItems(FXCollections.observableArrayList(model.getUserSortedByHighscore()));
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
