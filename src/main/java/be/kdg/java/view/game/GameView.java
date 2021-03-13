package be.kdg.java.view.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GameView extends GridPane {



    private Button highscoresButton;
    private Button settingsButton;


    public GameView(){
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {

        this.highscoresButton = new Button("Highscores");
        this.settingsButton = new Button("Settings");
        GridPane gameBoard = new GridPane();
        gameBoard.setPrefSize(755, 755);
        // bvb.:
        // button = new Button("...")
        // label = new Label("...")
    }

    private void layoutNodes() {

        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(100, 100, 100, 100));



        this.add(highscoresButton, 0,1);
        this.add(settingsButton, 1,1);
    }

    public Button getHighscoresButton() {
        return highscoresButton;
    }

    public Button getSettingsButton() {
        return settingsButton;
    }
}
