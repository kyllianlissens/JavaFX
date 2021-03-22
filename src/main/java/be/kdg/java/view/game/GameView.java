package be.kdg.java.view.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.scene.media.MediaView;


public class GameView extends GridPane {



    private GridPane gamePane;


    private GridPane block1, block2, block3;

    private HBox buttonHBox;
    private Button highscoresButton;
    private Button settingsButton;
    private Text currentScore;

    private HBox blocksHBox;


    public GameView(){
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {

        this.highscoresButton = new Button("Highscores");
        this.settingsButton = new Button("Settings");
        this.buttonHBox = new HBox(10);
        this.blocksHBox = new HBox(30);
        this.currentScore = new Text("Score: 0");
        gamePane = new GridPane();
        block1 = new GridPane();
        block2 = new GridPane();
        block3 = new GridPane();



        // bvb.:
        // button = new Button("...")
        // label = new Label("...")
    }

    private void layoutNodes() {

        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(50, 50, 50, 50));

        this.buttonHBox.setAlignment(Pos.CENTER);
        this.buttonHBox.getChildren().addAll(highscoresButton,settingsButton);

        this.blocksHBox.setAlignment(Pos.CENTER);
        this.blocksHBox.getChildren().addAll(block1, block2, block3);
        this.add(gamePane, 0,0);
        this.add(blocksHBox, 0,1);
        this.add(buttonHBox, 0,2);
        this.add(currentScore, 0,3);




        setStyle("-fx-background-image: url(images/wood.jpg);-fx-background-size: cover;");
        this.settingsButton.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),\n" +
                "        #9d4024,\n" +
                "        #d86e3a,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        this.highscoresButton.setStyle("-fx-padding: 8 15 15 15;\n" + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" + "    -fx-background-radius: 8;\n" + "    -fx-background-color: \n" + "        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),\n" + "        #9d4024,\n" + "        #d86e3a,\n" + "        radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);\n" + "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" + "    -fx-font-weight: bold;\n" + "    -fx-font-size: 1.1em;");
        this.currentScore.setStyle("-fx-font-size: 32px;\n" + "-fx-font-family: \"Arial Black\";\n" + "   -fx-fill: #818181;\n" + "   -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");

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

}
