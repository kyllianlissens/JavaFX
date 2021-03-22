package be.kdg.java.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Gameboard {

    /*
        Nothing needs setters here since the values are only declared on initialization


     */
    private ArrayList<ArrayList<Rectangle>> pointGrid;
    static private List<Block> placedBlocks;
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

    public boolean placeBlock(Block block, Point point) {

        if (canPlaceBlock(block, point)) {
            for (Point p : block.getShape().getTiles()) {

                Point calcPoint = new Point(point.x + p.x, point.y + p.y);
                Rectangle gridPoint = pointGrid.get(calcPoint.y - 2).get(calcPoint.x - 2);

                gridPoint.setColor(Color.BLACK);


            }
            placedBlocks.add(block);
            return true;
        } else return false;


    }


    public ArrayList<ArrayList<Rectangle>> getPointGrid() {
        return pointGrid;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
        makeGrid(sizeX, sizeY);
    }

    private void makeGrid(int sizeX, int sizeY) {
        placedBlocks = new ArrayList<>();
        pointGrid = new ArrayList<>();
        for (int y = 0; y < sizeY; y++) { //2D Array creation & initialization
            pointGrid.add(new ArrayList<>());//e
            for (int x = 0; x < sizeX; x++) {
                pointGrid.get(y).add(new Rectangle(Color.WHITE));
            }
        }
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
        makeGrid(sizeX, sizeY);
    }

    public static List<Block> getPlacedBlocks() {
        return placedBlocks;
    }
}
