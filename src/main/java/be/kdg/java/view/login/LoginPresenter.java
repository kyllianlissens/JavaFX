package be.kdg.java.view.login;

import be.kdg.java.model.Game;
import be.kdg.java.view.game.GamePresenter;
import be.kdg.java.view.game.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;

public class LoginPresenter {
    private Game model;
    private LoginView view;

    public LoginPresenter(Game model, LoginView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getLoginButton().setOnAction(
                new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent actionEvent) {
                        try {
                            model.login(view.getUsernameTextField().getText(), view.getPasswordTextField().getText());

                            GameView gameView = new GameView();
                            GamePresenter gamePresenter = new GamePresenter(model, gameView);
                            view.getScene().setRoot(gameView);
                            gameView.getScene().getWindow().sizeToScene();


                        } catch (Exception exception) {
                            exception.printStackTrace();
                            showAlert(Alert.AlertType.ERROR, exception.getMessage(), exception.getMessage());
                        }
                    }
                }
        );

        view.getRegisterButton().setOnAction(
                new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent actionEvent) {
                        try {
                            model.register(view.getUsernameTextField().getText(), view.getPasswordTextField().getText());
                        } catch (Exception exception) {
                            showAlert(Alert.AlertType.ERROR, exception.getMessage(), exception.getMessage());
                        }
                    }
                }
        );
    }

    private void updateView() {
        // Vult de view met data uit model
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
