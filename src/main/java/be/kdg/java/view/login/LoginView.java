package be.kdg.java.view.login;

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

public class LoginView extends GridPane {

    private GridPane grid;
    private Label usernameLabel;
    private TextField usernameTextField;

    private Label passwordLabel;
    private PasswordField passwordTextField;

    private HBox buttonHBox;

    private Button loginButton;
    private Button registerButton;

    private Text welcomeTitle;




    public LoginView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    private void initialiseNodes() {
        this.usernameLabel = new Label("Username: ");
        this.usernameTextField = new TextField();

        this.passwordLabel = new Label("Password: ");
        this.passwordTextField = new PasswordField();

        this.buttonHBox = new HBox(10);

        this.loginButton = new Button("Sign in");

        this.registerButton = new Button("Register");

        this.welcomeTitle = new Text("Welcome!");
    }

    private void layoutNodes() {

        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(50, 50, 50, 50));


        this.add(welcomeTitle, 0,0,2,1);

        this.add(usernameLabel, 0, 1);
        this.add(usernameTextField, 1,1);

        this.add(passwordLabel, 0,2);
        this.add(passwordTextField, 1,2);


        this.buttonHBox.setAlignment(Pos.CENTER_RIGHT);
        this.buttonHBox.getChildren().addAll(this.registerButton, this.loginButton);

        this.add(buttonHBox, 1,4);
        //hier komt alle styling
        setStyle("-fx-background-image: url(images/wood.jpg);-fx-background-size: cover;");
        this.welcomeTitle.setStyle(" -fx-font-size: 32px;\n" + "-fx-font-family: \"Arial Black\";\n" + "   -fx-fill: #818181;\n" + "   -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        this.usernameLabel.setStyle("-fx-fill: FIREBRICK;\n" + "  -fx-font-weight: bold;\n" + "  -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 ); -fx-font-size:18px;");
        this.passwordLabel.setStyle("-fx-fill: FIREBRICK;\n" + "  -fx-font-weight: bold;\n" + "  -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 ); -fx-font-size:18px;");
        this.loginButton.setStyle("-fx-color: gray;-fx-font-size: 14px;");
        this.registerButton.setStyle("-fx-color: black;-fx-font-size: 14px;");




    }

    Button getLoginButton() {
        return loginButton;
    }

    Button getRegisterButton() {
        return registerButton;
    }

    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public PasswordField getPasswordTextField() {
        return passwordTextField;
    }
}
