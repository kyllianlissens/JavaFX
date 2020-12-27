package com.company;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Gameboard {
    public List<Point> pointGrid;

    private final int sizeX;
    private final int sizeY;

    public Gameboard(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        pointGrid = new ArrayList<Point>();
    }

    public Gameboard(){
        this(30,30);
    }

    public boolean placeBlock(Block block, Point point){
        for (Point p : block.shape.getTiles()) {

        }


        return false;

    }

}
