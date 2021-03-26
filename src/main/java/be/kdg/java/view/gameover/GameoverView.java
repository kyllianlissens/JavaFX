package be.kdg.java.view.gameover;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class GameoverView extends GridPane {

    private Label gameOver;
    private HBox buttonHBox;
    private Button backButton;
    private Text currentScore;
    private Text highScore;

    public GameoverView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {

        this.gameOver = new Label("Game over");
        this.buttonHBox = new HBox(10);
        this.backButton = new Button("Back");
        this.currentScore = new Text("Score: 0");
        this.highScore = new Text("Highscore: 0");

    }

    private void layoutNodes() {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(50, 50, 50, 50));

        this.buttonHBox.setAlignment(Pos.CENTER_RIGHT);
        this.buttonHBox.getChildren().addAll(this.backButton);

        this.add(gameOver, 0, 0, 2, 1);
        this.add(currentScore, 0, 1);
        this.add(highScore, 0, 2);
        this.add(buttonHBox, 1, 4);

        setStyle("-fx-background-image: url(images/wood.jpg);-fx-background-size: cover;\n");

        this.backButton.getStyleClass().add("backButton");
        this.gameOver.getStyleClass().add("gameOver");
        this.currentScore.getStyleClass().add("currentScore");
        this.highScore.getStyleClass().add("highScore");

    }


    public Button getBackButton() {
        return backButton;
    }

    public Text getCurrentScore() {
        return currentScore;
    }

    public Text getHighScore() {
        return highScore;
    }


}
