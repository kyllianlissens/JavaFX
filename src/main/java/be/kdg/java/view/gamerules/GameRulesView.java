package be.kdg.java.view.gamerules;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GameRulesView extends GridPane{
    private Button backButton;
    private HBox buttonHBox;
    private ImageView image;
    public GameRulesView(){
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        this.buttonHBox = new HBox(10);
        this.backButton = new Button("Back");
        this.image = new ImageView("images/regels.png");

    }

    private void layoutNodes() {
        this.buttonHBox.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10,10,10,10));
        this.buttonHBox.getChildren().addAll(this.backButton);
        this.add(buttonHBox, 0,2);
        this.add(image, 0, 1);

        setStyle("-fx-background-image: url(images/wood.jpg); -fx-background-size: cover;");
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


    }
    public Button getBackButton() {
        return backButton;
    }

}
