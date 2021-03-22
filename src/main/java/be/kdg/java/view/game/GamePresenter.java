package be.kdg.java.view.game;


import be.kdg.java.model.Block;
import be.kdg.java.model.Game;
import be.kdg.java.view.gameover.GameoverPresenter;
import be.kdg.java.view.gameover.GameoverView;
import be.kdg.java.view.highscores.HighscorePresenter;
import be.kdg.java.view.highscores.HighscoreView;
import be.kdg.java.view.settings.SettingsPresenter;
import be.kdg.java.view.settings.SettingsView;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Arrays;


public class GamePresenter {
    private Game model;
    private final GameView view;

    private Block selectedBlock;


    public GamePresenter(Game model, GameView view) {
        this.model = model;
        this.view = view;
        updateView();
        addEventHandlers();

    }

    private void addEventHandlers() {
        view.getHighscoresButton().setOnAction(
                actionEvent -> {
                    HighscoreView highscoresView = new HighscoreView();
                    new HighscorePresenter(model, highscoresView);
                    view.getScene().setRoot(highscoresView);
                    highscoresView.getScene().getWindow().sizeToScene();
                }
        );

        view.getSettingsButton().setOnAction(
                actionEvent -> {
                    SettingsView settingsView = new SettingsView();
                    new SettingsPresenter(model, settingsView);
                    view.getScene().setRoot(settingsView);
                    settingsView.getScene().getWindow().sizeToScene();
                }
        );

        EventHandler<MouseEvent> dragDetected = event -> {

            if (model.isPlayMusic()) {
                model.getMediaPlayer().play();
            }

            GridPane source = (GridPane) event.getSource();
            selectedBlock = model.getBlocksToBeUsed().get(Integer.parseInt(source.getId()));
            Dragboard dragboard = source.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putImage(source.snapshot(new SnapshotParameters(), null));
            dragboard.setContent(content);
            event.consume();
        };


        for (Node n : view.getBlocksHBox().getChildren()) {
            n.setOnDragDetected(dragDetected);
        }


        for (int i = 0; i < view.getGamePane().getChildren().size(); i++) {
            Node r = view.getGamePane().getChildren().get(i);


            double point1 = (i / (double) model.getGameBoard().getSizeY()) + 1.0;
            double point2 = Math.round((point1 - Math.floor(point1)) * model.getGameBoard().getSizeX() + 1);


            r.setOnDragOver(event -> {
                if (event.getGestureSource() != r && event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                event.consume();
            });
            r.setOnDragDropped(event -> {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasImage()) {
                    try {
                        model.placeBlock(selectedBlock, (int) point2, (int) point1);
                        success = true;
                    } catch (Exception exception) {

                        exception.printStackTrace();


                        if (exception.getMessage().equals("Game over")) {
                            GameoverView gameoverView = new GameoverView();
                            new GameoverPresenter(model,gameoverView);
                            Stage aboutStage= new Stage();
                            aboutStage.initOwner(view.getScene().getWindow());
                            aboutStage.initModality(Modality.APPLICATION_MODAL);
                            aboutStage.setScene(new Scene(gameoverView));
                            aboutStage.setX(view.getScene().getWindow().getX() + 100);
                            aboutStage.setY(view.getScene().getWindow().getY() + 100);
                            aboutStage.showAndWait();

                            model.getMediaPlayer().stop();
                            model = null;
                            model = new Game();


                        }else{
                            showAlert(Alert.AlertType.ERROR, exception.getMessage(), exception.getMessage());
                        }
                    }

                }
                event.setDropCompleted(success);
                event.consume();
            });

        }

        EventHandler<DragEvent> dragDone = event -> {
            updateView();
            addEventHandlers();
            event.consume();
        };

        for (Node n : view.getBlocksHBox().getChildren()) {
            n.setOnDragDone(dragDone);
        }


    }


    private void updateView() {


        view.getCurrentScore().setText("Score: " + model.score);
        //Clear Game Pane
        view.getGamePane().getChildren().clear();
        //Fuel game pane with tiles.
        for (int i = 0; i < model.getGameBoard().getSizeY(); i++) {
            for (int j = 0; j < model.getGameBoard().getSizeX(); j++) {
                Color c = Color.WHITE;
                if (model.getGameBoard().getPointGrid().get(i).get(j).getColor().equals(java.awt.Color.BLACK))
                    c = Color.BLACK;
                Rectangle tile = new Rectangle(35, 35);
                tile.setFill(c);
                tile.setStroke(Color.BLACK);
                GridPane.setMargin(tile, new Insets(1.0));
                view.getGamePane().add(tile, j, i);
            }
        }
        //Clear all Blocks
        view.getBlocksHBox().getChildren().clear();
        //For each block that can be used make our pane
        for (int i = 0; i < model.getBlocksToBeUsed().size(); i++) {
            GridPane pane = new GridPane();
            //We set the index Id as the Pane Id so we know which block is being placed
            pane.setId(String.valueOf(i));

            pane.setPrefSize(100, 100);

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int finalJ = j;
                    int finalK = k;
                    Rectangle tile = new Rectangle(35, 35);

                    GridPane.setMargin(tile, new Insets(1.0));
                    if (Arrays.stream(model.getBlocksToBeUsed().get(i).getShape().getTiles()).anyMatch(e -> e.y == finalJ && e.x == finalK)) {
                        tile.setFill(Color.BLACK);
                        tile.setStroke(Color.BLACK);
                    } else {
                        tile.setFill(new Color(0, 0, 0, 0));

                    }
                    pane.add(tile, k, j);
                }

            }

            view.getBlocksHBox().getChildren().add(pane);
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

}
