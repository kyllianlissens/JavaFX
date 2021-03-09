package be.kdg.javafx.view.login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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


        this.welcomeTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        this.add(welcomeTitle, 0,0,2,1);

        this.add(usernameLabel, 0, 1);
        this.add(usernameTextField, 1,1);

        this.add(passwordLabel, 0,2);
        this.add(passwordTextField, 1,2);


        this.buttonHBox.setAlignment(Pos.CENTER_RIGHT);
        this.buttonHBox.getChildren().addAll(this.registerButton, this.loginButton);

        this.add(buttonHBox, 1,4);


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
