package be.kdg.java.view.highscores;

import be.kdg.java.model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HighscoreView extends VBox {


    private Text title;
    private ListView<User> highscores;

    private HBox buttonHBox;

    private Button backButton;
    private Button statsButton;


    public HighscoreView() {
        this.initialiseNodes();
        this.layoutNodes();

    }
    private void initialiseNodes() {
        this.title = new Text("Highscores");
        this.highscores = new ListView<User>();
        this.backButton = new Button("Back");
        this.statsButton = new Button("Statistics");
        this.buttonHBox = new HBox(10);
    }

    private void layoutNodes() {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(25, 25, 25,25));
        this.setSpacing(20);

        this.title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        this.buttonHBox.setAlignment(Pos.CENTER);
        this.buttonHBox.getChildren().addAll(this.backButton, this.statsButton);


        this.getChildren().addAll(title, highscores, buttonHBox);

    }

    public ListView<User> getHighscores() {
        return highscores;
    }

    public Button getBackButton() {
        return backButton;
    }

    public Button getStatsButton() {
        return statsButton;
    }
}
