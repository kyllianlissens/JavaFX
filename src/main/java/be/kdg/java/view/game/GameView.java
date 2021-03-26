package be.kdg.java.view.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class GameView extends GridPane {


    private GridPane gamePane;


    private GridPane block1, block2, block3;

    private HBox buttonHBox;
    private Button highscoresButton;
    private Button settingsButton;
    private Button rulesButton;
    private Text currentScore;

    private HBox blocksHBox;


    public GameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {

        this.highscoresButton = new Button("Highscores");
        this.settingsButton = new Button("Settings");
        this.rulesButton = new Button("Rules");
        this.buttonHBox = new HBox(10);
        this.blocksHBox = new HBox(30);
        this.currentScore = new Text("Score: 0");
        this.gamePane = new GridPane();
        this.block1 = new GridPane();
        this.block2 = new GridPane();
        this.block3 = new GridPane();
    }

    private void layoutNodes() {

        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(50, 50, 50, 50));


        this.buttonHBox.setAlignment(Pos.CENTER);
        this.buttonHBox.getChildren().addAll(highscoresButton, settingsButton, rulesButton);

        this.blocksHBox.setAlignment(Pos.CENTER);
        this.blocksHBox.getChildren().addAll(block1, block2, block3);
        this.add(gamePane, 0, 0);
        this.add(blocksHBox, 0, 1);
        this.add(buttonHBox, 0, 2);
        this.add(currentScore, 0, 3);


        setStyle("-fx-background-image: url(images/wood.jpg);-fx-background-size: cover;");
        this.highscoresButton.getStyleClass().add("highscoresButton");
        this.settingsButton.getStyleClass().add("settingsButton");
        this.rulesButton.getStyleClass().add("rulesButton");
        this.currentScore.getStyleClass().add("currentScore");
        this.buttonHBox.setSpacing(30);

    }

    public Button getHighscoresButton() {
        return highscoresButton;
    }

    public Button getSettingsButton() {
        return settingsButton;
    }

    public GridPane getGamePane() {
        return gamePane;
    }

    public HBox getBlocksHBox() {
        return blocksHBox;
    }

    public Text getCurrentScore() {
        return currentScore;
    }

    public Button getRulesButton() {
        return rulesButton;
    }

}
