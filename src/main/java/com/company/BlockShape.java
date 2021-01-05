package com.company;

import java.awt.*;

public enum BlockShape {

    BIG_L (new Point[]{new Point(0,0), new Point(0,-1), new Point(0,-2), new Point(1,-2) }, 3),
    SMALL_L (new Point[] {new Point(0,0), new Point(0,-1), new Point(1,1)}, 1),
    LINEH (new Point[] {new Point(0,0), new Point(1,0), new Point(2,0)}, 1),
    LINENV (new Point[] {new Point(0,0), new Point(0,-1),  new Point(0,1)}, 1),
    RB_L (new Point[] {new Point(0,0), new Point(-1,0), new Point(-2,0), new Point(-2,-1)}, 1),
    RS_L (new Point[] {new Point(0,0), new Point(-1,0), new Point(1,-1)}, 1),
    TONT (new Point[] {new Point(0,0), new Point(-1,0), new Point(0,-1), new Point(-1,-1)}, 1),
    DOND (new Point[] {new Point(0,0), new Point(-1,0), new Point(0,-1), new Point(-1,-1),new Point(-2,0),new Point(0,-2), new Point(-2,-1),new Point(-1,-2),new Point(-2,-2)}, 1);


    private final Point[] tiles;
    private final int difficulty;

    BlockShape(Point[] tiles, int difficulty){
        this.tiles = tiles;
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public Point[] getTiles() { return tiles; }

    public static BlockShape randomEnum(){
        return values()[(int) (Math.random() * values().length)];
    }

}
