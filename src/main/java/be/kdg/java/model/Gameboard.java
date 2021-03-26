package be.kdg.java.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * De klasse voor het bord van het spel
 *
 *  @author Kyllian Lissens
 *  @version 1.0
 */
public class Gameboard {

    private ArrayList<ArrayList<Rectangle>> pointGrid;
    private int sizeX;
    private int sizeY;

    public Gameboard(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        makeGrid(sizeX, sizeY);
    }

    /**
     * Default constructor
     */
    public Gameboard() {
        this(12, 12);
    }

    /**
     * Checkt of een block op deze locatie geplaatst kan worden
     * @param block de blok
     * @param point de locatie
     * @return true = kan geplaatst worden op deze locatie
     */
    public boolean canPlaceBlock(Block block, Point point) {

        for (Point p : block.getShape().getTiles()) {

            Point calcPoint = new Point(point.x + p.x, point.y + p.y);
            Rectangle gridPoint;
            try {
                gridPoint = pointGrid.get(calcPoint.y - 2).get(calcPoint.x - 2);
            } catch (IndexOutOfBoundsException exception) {
                return false;
            }

            if (gridPoint.getColor() == Color.BLACK) {
                return false;
            }


        }

        return true;
    }

    /**
     * Plaatst een blok op deze locatie
     * @param block het blokje
     * @param point de locatie
     */
    public void placeBlock(Block block, Point point) {

        for (Point p : block.getShape().getTiles()) {

            Point calcPoint = new Point(point.x + p.x, point.y + p.y);
            Rectangle gridPoint = pointGrid.get(calcPoint.y - 2).get(calcPoint.x - 2);

            gridPoint.setColor(Color.BLACK);


        }


    }

    public ArrayList<ArrayList<Rectangle>> getPointGrid() {
        return pointGrid;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
        makeGrid(sizeX, sizeY);
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
        makeGrid(sizeX, sizeY);
    }

    private void makeGrid(int sizeX, int sizeY) {
        pointGrid = new ArrayList<>();
        for (int y = 0; y < sizeY; y++) { //2D Array creation & initialization
            pointGrid.add(new ArrayList<>());//e
            for (int x = 0; x < sizeX; x++) {
                pointGrid.get(y).add(new Rectangle(Color.WHITE));
            }
        }
    }
}
