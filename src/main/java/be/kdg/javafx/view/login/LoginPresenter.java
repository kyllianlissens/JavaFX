package be.kdg.javafx.view.login;

import be.kdg.javafx.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

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
                        } catch (Exception exception) {
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
