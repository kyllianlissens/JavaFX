package be.kdg.javafx.view.login;

import be.kdg.javafx.model.JavaFXModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class LoginPresenter {
    private JavaFXModel model;
    private LoginView view;

    public LoginPresenter(JavaFXModel model, LoginView view) {
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
                        showAlert(Alert.AlertType.INFORMATION, "Login!", "Yes very epic");
                    }
                }
        );

        view.getRegisterButton().setOnAction(
                new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent actionEvent) {

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
