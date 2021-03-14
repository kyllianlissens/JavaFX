package be.kdg.java.view.settings;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SettingsView extends GridPane {

    private HBox soundSettings;
    private Text soundText;
    private CheckBox soundCheckBox;

    private HBox rowSettings;
    private Text rowText;
    private TextField rowInput;


    public SettingsView(){
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        this.soundSettings = new HBox(75);
        this.soundText = new Text("Sound");
        this.soundCheckBox = new CheckBox();

        this.rowSettings = new HBox(75);
        this.rowText = new Text("Rows");
        this.rowInput = new TextField("Rows");
    }

    private void layoutNodes() {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20, 20, 20, 20));

        this.soundText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.soundSettings.setAlignment(Pos.CENTER);
        this.soundSettings.getChildren().addAll(this.soundText, this.soundCheckBox);

        this.add(soundSettings, 1,1);

        this.rowText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.rowSettings.setAlignment(Pos.CENTER);
        this.rowSettings.getChildren().addAll(this.rowText, this.rowInput);

        this.add(rowSettings, 1,2);

    }
}
