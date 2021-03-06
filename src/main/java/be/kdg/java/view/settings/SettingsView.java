package be.kdg.java.view.settings;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SettingsView extends GridPane {

    private HBox soundSettings;
    private CheckBox musicButton;

    private HBox rowSettings;
    private Text rowText;
    private TextField rowInput;

    private HBox columnSettings;
    private Text columnText;
    private TextField columnInput;

    private Button backButton;
    private Button saveButton;
    private HBox buttonHBox;

    public SettingsView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.soundSettings = new HBox(10);
        this.musicButton = new CheckBox("Music on/off");


        this.rowSettings = new HBox(75);
        this.rowText = new Text("Rows");
        this.rowInput = new TextField("Rows");

        this.columnSettings = new HBox(48);
        this.columnText = new Text("Columns");
        this.columnInput = new TextField("Columns");


        this.buttonHBox = new HBox(75);
        this.backButton = new Button("Back");
        this.saveButton = new Button("Save");


    }

    private void layoutNodes() {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20, 20, 20, 20));


        this.soundSettings.setAlignment(Pos.CENTER_RIGHT);
        this.soundSettings.getChildren().addAll(this.musicButton);

        this.add(soundSettings, 1, 1);

        this.rowText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.rowSettings.setAlignment(Pos.CENTER);
        this.rowSettings.getChildren().addAll(this.rowText, this.rowInput);


        this.columnText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.columnSettings.getChildren().addAll(this.columnText, this.columnInput);


        this.add(rowSettings, 1, 2);

        this.add(columnSettings, 1, 3);

        this.buttonHBox.setAlignment(Pos.CENTER);
        this.buttonHBox.getChildren().addAll(this.backButton, this.saveButton);
        this.add(buttonHBox, 1, 4);
        setStyle("-fx-background-image: url(images/wood.jpg);-fx-background-size: cover;");
        this.backButton.getStyleClass().add("backButton");
        this.saveButton.getStyleClass().add("saveButton");
        this.musicButton.getStyleClass().add("musicButton");


    }

    public TextField getRowInput() {
        return rowInput;
    }

    public TextField getColumnInput() {
        return columnInput;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getBackButton() {
        return backButton;
    }

    public CheckBox getMusicButton() {
        return musicButton;
    }
}
