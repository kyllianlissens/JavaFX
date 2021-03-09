package be.kdg.javafx.view.settings;

import be.kdg.javafx.model.JavaFXModel;
import be.kdg.javafx.view.JavaFXView;


public class SettingsPresenter {
    private JavaFXModel model;
    private JavaFXView view;

    public SettingsPresenter(JavaFXModel model, JavaFXView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        // Koppelt event handlers(anon. innerklassen)
        // aan de controlsuit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.
    }

    private void updateView() {
        // Vult de view met data uit model
    }
}
