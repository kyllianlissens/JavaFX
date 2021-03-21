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
        this.setPadding(new Insets(40, 40, 40,40));
        this.setSpacing(20);

        this.title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        this.buttonHBox.setAlignment(Pos.CENTER);
        this.buttonHBox.getChildren().addAll(this.backButton, this.statsButton);


        this.getChildren().addAll(title, highscores, buttonHBox);
        setStyle("-fx-background-image: url(images/wood.jpg);-fx-background-size: cover;");
        this.backButton.setStyle("-fx-padding: 8 15 15 15;\n" +
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
        this.statsButton.setStyle("-fx-padding: 8 15 15 15;\n" +
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
        this.title.setStyle(" -fx-font-size: 32px;\n" + "-fx-font-family: \"Arial Black\";\n" + "   -fx-fill: #818181;\n" + "   -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        this.highscores.setStyle("-fx-color: #903b12;-fx-background-color: #903b12;-fx-text-fill: white;-fx-font:13px serif;-fx-padding:10; ");




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
