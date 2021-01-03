package com.company;
import java.awt.*;
import java.util.ArrayList;


public class Gameboard {
    public ArrayList<ArrayList<Rectangle>> pointGrid;

    private final int sizeX;
    private final int sizeY;

    public Gameboard(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        pointGrid = new ArrayList<>();
        for (int y = 0; y < sizeY; y++) { //2D Array creation & initialization
            pointGrid.add(new ArrayList<>());
            for (int x = 0; x < sizeX; x++) {
                pointGrid.get(y).add(new Rectangle(Color.BLACK,10,10));
            }
        }
    }

    public Gameboard(){
        this(5,5); //default size
    }

    public boolean placeBlock(Block block, Point point){

        //Some stupid calculations I have to cleanup
        for (Point p : block.shape.getTiles()) {
            System.out.println("Shape Point: " + p.toString());
            System.out.println("Point location: " + point.toString());
            Point calcPoint = new Point(point.x + p.x, point.y + p.y);
            System.out.println("Calculated location: " + calcPoint.toString());
            Rectangle gridPoint = pointGrid.get(calcPoint.y).get(calcPoint.x);
            if (gridPoint.getColor() == Color.WHITE){
                return false;
            }
            gridPoint.setColor(Color.WHITE);
        }


        return true;

    }

}
