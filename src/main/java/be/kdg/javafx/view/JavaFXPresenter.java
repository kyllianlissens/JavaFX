package be.kdg.javafx.view;

import be.kdg.javafx.model.Game;

public class JavaFXPresenter {
    private Game model;
    private JavaFXView view;

    public JavaFXPresenter(Game model, JavaFXView view) {
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
