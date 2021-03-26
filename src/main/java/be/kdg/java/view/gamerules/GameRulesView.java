package be.kdg.java.view.gamerules;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GameRulesView extends GridPane {
    private Button backButton;
    private HBox buttonHBox;
    private ImageView image;

    public GameRulesView() {
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
        this.setPadding(new Insets(10, 10, 10, 10));
        this.buttonHBox.getChildren().addAll(this.backButton);
        this.add(buttonHBox, 0, 2);
        this.add(image, 0, 1);

        setStyle("-fx-background-image: url(images/wood.jpg); -fx-background-size: cover;");
        this.backButton.getStyleClass().add("backButton");
    }

    public Button getBackButton() {
        return backButton;
    }

}
