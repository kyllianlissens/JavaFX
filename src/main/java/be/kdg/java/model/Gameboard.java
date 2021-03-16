package be.kdg.java.model;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Gameboard {

    /*
        Nothing needs setters here since the values are only declared on initialization


     */
    private final ArrayList<ArrayList<Rectangle>> pointGrid;
    static private List<Block> placedBlocks;
    private final int sizeX;
    private final int sizeY;

    public Gameboard(int sizeX, int sizeY){

        placedBlocks = new ArrayList<>();

        this.sizeX = sizeX;
        this.sizeY = sizeY;

        pointGrid = new ArrayList<>();
        for (int y = 0; y < sizeY; y++) { //2D Array creation & initialization
            pointGrid.add(new ArrayList<>());//e
            for (int x = 0; x < sizeX; x++) {
                pointGrid.get(y).add(new be.kdg.java.model.Rectangle(Color.WHITE));
            }
        }
    }

    public Gameboard(){
        this(12,12); //default size
    }

    public boolean placeBlock(Block block, Point point){
        System.out.println("Test= " + point);


        //We check all the points first
        for (Point p : block.getShape().getTiles()) {

            Point calcPoint = new Point(point.x + p.x, point.y + p.y);
            Rectangle gridPoint;
            try{
                gridPoint = pointGrid.get(calcPoint.y-2).get(calcPoint.x-2);
            }catch (IndexOutOfBoundsException exception){
                System.out.println("Out of index: " + point);
                return false;
            }

            if (gridPoint.getColor() == Color.BLACK){
                System.out.println("Block placed: " + point);
                return false; //WHITE = Block already has been placed there.
            }


        }


        for (Point p : block.getShape().getTiles()) {



            Point calcPoint = new Point(point.x + p.x, point.y + p.y);
            System.out.println("Shape Point: " + p.toString());
            System.out.println("Point location: " + point.toString());
            System.out.println("Calculated location: " + calcPoint.toString());
            Rectangle gridPoint =  pointGrid.get(calcPoint.y-2).get(calcPoint.x-2);

            gridPoint.setColor(Color.BLACK);


        }


        block.setLocation(point);
        placedBlocks.add(block);
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

    public static List<Block> getPlacedBlocks() {
        return placedBlocks;
    }
}
