package be.kdg.java.model;

import java.awt.*;
import java.util.ArrayList;


public class Gameboard {

    private ArrayList<ArrayList<Rectangle>> pointGrid;
    private int sizeX;
    private int sizeY;

    public Gameboard(int sizeX, int sizeY) {


        this.sizeX = sizeX;
        this.sizeY = sizeY;

        makeGrid(sizeX, sizeY);
    }

    public Gameboard() {
        this(12, 12); //default size
    }


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
                return false; //WHITE = Block already has been placed there.
            }


        }

        return true;
    }

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
