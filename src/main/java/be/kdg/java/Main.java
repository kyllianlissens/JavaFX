package be.kdg.java;

import be.kdg.java.model.Game;
import be.kdg.java.view.login.LoginPresenter;
import be.kdg.java.view.login.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game model = new Game();
        LoginView loginView = new LoginView();
        new LoginPresenter(model, loginView);
        Scene scene = new Scene(loginView);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        scene.getStylesheets().add(getClass().getResource("/stylesheets/stylesheet.css").toExternalForm());


    }
}
