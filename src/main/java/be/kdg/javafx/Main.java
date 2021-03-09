package be.kdg.javafx;

import be.kdg.javafx.model.JavaFXModel;
import be.kdg.javafx.view.login.LoginPresenter;
import be.kdg.javafx.view.login.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        JavaFXModel model = new JavaFXModel();
        LoginView loginView = new LoginView();
        new LoginPresenter(model, loginView);
        primaryStage.setScene(new Scene(loginView));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
