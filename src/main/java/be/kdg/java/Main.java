package be.kdg.java;

import be.kdg.java.model.Game;
import be.kdg.java.view.login.LoginPresenter;
import be.kdg.java.view.login.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Game model = new Game();
        LoginView loginView = new LoginView();
        new LoginPresenter(model, loginView);
        primaryStage.setScene(new Scene(loginView));
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
