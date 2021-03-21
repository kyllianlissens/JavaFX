package be.kdg.java.view.gameover;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GameoverView  extends GridPane {

    private GridPane grid;

    private Label gameOver;


    private HBox buttonHBox;

    private Button backButton;

    private Text currentScore;
    private Text highScore;




    public GameoverView(){
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

    private void layoutNodes()
    {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(50, 50, 50, 50));


        this.add(gameOver, 0,0,2,1);

        this.add(currentScore, 0, 1);
        this.add(highScore, 0,2);


        this.buttonHBox.setAlignment(Pos.CENTER_RIGHT);
        this.buttonHBox.getChildren().addAll(this.backButton);

        this.add(buttonHBox, 1,4);

        setStyle("-fx-background-image: url(images/wood.jpg);-fx-background-size: cover;\n");

        this.backButton.setStyle("-fx-padding: 8 15 15 15;\n" + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" + "    -fx-background-radius: 8;\n" + "    -fx-background-color: \n" + "        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),\n" + "        #9d4024,\n" + "        #d86e3a,\n" + "        radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);\n" + "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" + "    -fx-font-weight: bold;\n" + "    -fx-font-size: 1.1em;");
        this.gameOver.setStyle(" -fx-font-size: 32px;\n" + "-fx-font-family: \"Arial Black\";\n" + "   -fx-fill: #818181;\n" + "   -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        this.currentScore.setStyle("-fx-font-size: 22px;\n" + "-fx-font-family: \"Arial Black\";\n" + "   -fx-fill: #818181;\n" + "   -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        this.highScore.setStyle("-fx-font-size: 22px;\n" + "-fx-font-family: \"Arial Black\";\n" + "   -fx-fill: #818181;\n" + "   -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");

    }



    public Button getBackButton() {
        return backButton;
    }
    public Text getCurrentScore() {
        return currentScore;
    }
    public Text getHighScore(){return highScore;}


}
