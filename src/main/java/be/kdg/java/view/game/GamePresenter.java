package be.kdg.java.view.game;


import be.kdg.java.model.Block;
import be.kdg.java.model.BlockShape;
import be.kdg.java.model.Game;
import be.kdg.java.view.highscores.HighscorePresenter;
import be.kdg.java.view.highscores.HighscoreView;
import be.kdg.java.view.settings.SettingsPresenter;
import be.kdg.java.view.settings.SettingsView;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;


public class GamePresenter {
    private Game model;
    private GameView view;

    private BlockShape selectedBlock;

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
                    HighscorePresenter highscoresPresenter = new HighscorePresenter(model, highscoresView);
                    view.getScene().setRoot(highscoresView);
                    highscoresView.getScene().getWindow().sizeToScene();
                }
        );

        view.getSettingsButton().setOnAction(
                actionEvent -> {
                    SettingsView settingsView = new SettingsView();
                    SettingsPresenter settingsPresenter = new SettingsPresenter(model, settingsView);
                    view.getScene().setRoot(settingsView);
                    settingsView.getScene().getWindow().sizeToScene();
                }
        );

        EventHandler<MouseEvent> dragDetected = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("In drag detect event");
                GridPane source = (GridPane) event.getSource();
                selectedBlock = BlockShape.valueOf(source.getId());
                //Het image wordt in het DragBoard gestopt tijdens de transfer
                Dragboard dragboard = source.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(source.snapshot(new SnapshotParameters(), null));
                dragboard.setContent(content);
                event.consume();
            }
        };




        for (Node n: view.getBlocksHBox().getChildren()){
            n.setOnDragDetected(dragDetected);
        }


        for (int i = 0; i < view.getGamePane().getChildren().size(); i++) {
            Node r = view.getGamePane().getChildren().get(i);



            double point1 = (i/12.0)+1.0;
            double point2 = Math.round((point1 - Math.floor(point1)) * 12 + 1);


            r.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != r && event.getDragboard().hasImage()) {
                        event.acceptTransferModes(TransferMode.MOVE);
                    }
                    event.consume();
                }
            });
            int finalI = i;
            r.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasImage()) {

                        System.out.println("Index " + finalI);

                        System.out.println("Setting Point1 (Before transfer):"+  point1);
                        System.out.println("Setting Point2 (Before transfer):"+  point2);

                        System.out.println("Setting Point1:"+  (int)point1);
                        System.out.println("Setting Point2:"+  (int)point2);

                        System.out.println("Block: " + selectedBlock.name());
                        for (Point p : selectedBlock.getTiles()){
                            System.out.println("Point Y " + p.getY());
                            System.out.println("Point X " + p.getX());
                            int newY = (int) (point1 + p.getY()) ;
                            int newX = (int) (point2 + p.getX()) ;

                            System.out.println("New Y: " + newY);
                            System.out.println("New X: " + newX);
                            model.getGameBoard().getPointGrid().get(newY-1).get(newX-1).setColor(java.awt.Color.WHITE);
                        }

                        updateView();
                        addEventHandlers();
                    }
                    event.setDropCompleted(success);
                    event.consume();
                }
            });

        }

        EventHandler<DragEvent> dragDone = new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
      ;

                event.consume();
            }
        };

        for (Node n: view.getBlocksHBox().getChildren()){
            n.setOnDragDone(dragDone);
        }


    }




    private void updateView() {
        //GridPane.setRowIndex(tile, i);
        //GridPane.setColumnIndex(tile, j);
        //gameBoard.getChildren().addAll(tile, text);
        //tile.setOnMouseClicked(event -> drawMove(text));

        view.getGamePane().getChildren().clear();

        for (int i = 0; i < model.getGameBoard().getSizeY(); i++) {
            for (int j = 0; j < model.getGameBoard().getSizeX(); j++) {


                Color c = Color.WHITE;

                if (model.getGameBoard().getPointGrid().get(i).get(j).getColor().equals(java.awt.Color.white)) c = Color.BLACK;

                Rectangle tile = new Rectangle(35, 35);
                tile.setFill(c);
                tile.setStroke(Color.BLACK);
                GridPane.setMargin(tile, new Insets(1.0));
                view.getGamePane().add(tile, j, i);
                //GridPane.setRowIndex(tile, i);
                //GridPane.setColumnIndex(tile, j);
                //gameBoard.getChildren().addAll(tile, text);
            }
        }

        for (int i = 0; i < model.getBlocksToBeUsed().size(); i++) {


            GridPane pane = (GridPane) view.getBlocksHBox().getChildren().get(i);

            pane.getChildren().clear();
            pane.setId(model.getBlocksToBeUsed().get(i).getShape().name());
            for (Point p : model.getBlocksToBeUsed().get(i).getShape().getTiles()){
                Rectangle tile = new Rectangle(20, 20);
                tile.setFill(Color.BLACK);
                tile.setStroke(Color.BLACK);
                GridPane.setMargin(tile, new Insets(1.0));
                pane.add(tile, Math.abs(p.x), Math.abs(p.y));
            }



        }





    }
}
