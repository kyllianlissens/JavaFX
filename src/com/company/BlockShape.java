package com.company;

import java.awt.*;
import java.util.Random;

public enum BlockShape {

    BIG_L (new Point[]{new Point(0,0), new Point(0,-1), new Point(0,-2)}, 3),
    SMALL_L (new Point[] {new Point(0,0), new Point(0,-1), new Point(1,-1)}, 1);

    

    private final Point[] tiles;
    private final int difficulty;

    BlockShape(Point[] tiles, int difficulty){
        this.tiles = tiles;
        this.difficulty = difficulty;
    }

    public Point[] getTiles() { return tiles; }

    public static BlockShape randomEnum(){
        return values()[(int) (Math.random() * values().length)];
    }

}
