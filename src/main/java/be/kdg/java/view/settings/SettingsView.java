package be.kdg.java.view.settings;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
   private Button musicButton;

    private HBox rowSettings;
    private Text rowText;
    private TextField rowInput;

    private HBox collumnSettings;
    private Text collumnText;
    private TextField collumnInput;

    private Button backButton;
    private HBox buttonHBox;

    public SettingsView(){
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        this.soundSettings = new HBox(10);
        this.musicButton = new Button("Music on/off");



        this.rowSettings = new HBox(75);
        this.rowText = new Text("Rows");
        this.rowInput = new TextField("Rows");

        this.collumnSettings = new HBox(48);
        this.collumnText = new Text("Columns");
        this.collumnInput = new TextField("Columns");


        this.buttonHBox = new HBox(75);
        this.backButton = new Button("Back");


    }

    private void layoutNodes() {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20, 20, 20, 20));


        this.soundSettings.setAlignment(Pos.CENTER);
        this.soundSettings.getChildren().addAll(this.musicButton);

        this.add(soundSettings, 1,1);

        this.rowText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.rowSettings.setAlignment(Pos.CENTER);
        this.rowSettings.getChildren().addAll(this.rowText, this.rowInput);


        this.collumnText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        this.collumnSettings.getChildren().addAll( this.collumnText,this.collumnInput);



        this.add(rowSettings, 1,2);

        this.add(collumnSettings,1,3);

        this.buttonHBox.setAlignment(Pos.CENTER);
        this.buttonHBox.getChildren().addAll(this.backButton);
        this.add(buttonHBox, 3, 3);
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



    }
    public Button getBackButton() {
        return backButton;
    }
    public Button getMusicButton() {return musicButton;}
}
