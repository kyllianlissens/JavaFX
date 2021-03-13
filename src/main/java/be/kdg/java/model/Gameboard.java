package be.kdg.java.model;
import java.awt.*;
import java.util.ArrayList;


public class Gameboard {

    /*
        Nothing needs setters here since the values are only declared on initialization


     */
    private ArrayList<ArrayList<Rectangle>> pointGrid;

    private final int sizeX;
    private final int sizeY;

    public Gameboard(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        pointGrid = new ArrayList<>();
        for (int y = 0; y < sizeY; y++) { //2D Array creation & initialization
            pointGrid.add(new ArrayList<>());//e
            for (int x = 0; x < sizeX; x++) {
                pointGrid.get(y).add(new be.kdg.java.model.Rectangle(Color.BLACK,10,10));
            }
        }
    }

    public Gameboard(){
        this(5,5); //default size
    }

    public boolean placeBlock(Block block, Point point){
        for (Point p : block.getShape().getTiles()) {
            Point calcPoint = new Point(point.x + p.x, point.y + p.y);
            System.out.println("Shape Point: " + p.toString());
            System.out.println("Point location: " + point.toString());
            System.out.println("Calculated location: " + calcPoint.toString());
            Rectangle gridPoint = null;
            try{
                gridPoint = pointGrid.get(calcPoint.y).get(calcPoint.x);
            }catch (IndexOutOfBoundsException exception){
                return false;
            }


            if (gridPoint.getColor() == Color.WHITE){
                return false; //WHITE = Block already has been placed there.
            }
            gridPoint.setColor(Color.WHITE);
        }

        return true;

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
}
