package be.kdg.java.view.login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class LoginView extends GridPane {

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


        this.add(welcomeTitle, 0, 0, 2, 1);

        this.add(usernameLabel, 0, 1);
        this.add(usernameTextField, 1, 1);

        this.add(passwordLabel, 0, 2);
        this.add(passwordTextField, 1, 2);


        this.buttonHBox.setAlignment(Pos.CENTER_RIGHT);
        this.buttonHBox.getChildren().addAll(this.registerButton, this.loginButton);

        this.add(buttonHBox, 1, 4);
        //hier komt alle styling
        setStyle("-fx-background-image: url(images/wood.jpg);-fx-background-size: cover;");
        this.welcomeTitle.setStyle(" -fx-font-size: 32px;\n" + "-fx-font-family: \"Arial Black\";\n" + "   -fx-fill: orange;\n" + "   -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
        this.usernameLabel.setStyle("-fx-fill: orange;\n" + "  -fx-font-weight: bold;\n" + "  -fx-effect: dropshadow( gaussian , orangered , 0,0,0,1 ); -fx-font-size:18px;");
        this.passwordLabel.setStyle("-fx-fill: orange;\n" + "  -fx-font-weight: bold;\n" + "  -fx-effect: dropshadow( gaussian , orangered , 0,0,0,1 ); -fx-font-size:18px;");
        this.loginButton.setStyle("-fx-padding: 8 15 15 15;\n" +
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
        this.registerButton.setStyle("-fx-padding: 8 15 15 15;\n" +
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
