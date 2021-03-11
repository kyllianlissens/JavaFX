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
        for (int i = 0; i < BOARD_SIZE; i++) {
              for (int j = 0; j < BOARD_SIZE; j++)
                  Rectangle tile = new Rectangle(50, 50);
                   tile.setFill(Color.BURLYWOOD);
                   tile.setStroke(Color.BLACK);
                  Text text = new Text();
                  text.setFont(Font.font(40));
                  gameBoard.add(new StackPane(tile, text), j, i);

                   GridPane.setRowIndex(tile, i);
                   GridPane.setColumnIndex(tile, j);
                   gameBoard.getChildren().addAll(tile, text);
                   tile.setOnMouseClicked(event -> drawMove(text));
               }
            }
    }
}
