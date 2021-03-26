package be.kdg.java.model;

import java.awt.*;

public enum BlockShape {

    BIG_L(new Point[]{new Point(1, 1), new Point(1, 0), new Point(1, 2), new Point(2, 2)}),

    LINE_HORIZONTAL(new Point[]{new Point(0, 1), new Point(1, 1), new Point(2, 1)}),

    LINE_VERTICAL(new Point[]{new Point(1, 0), new Point(1, 2), new Point(1, 1)}),

    REVERSED_BIG_L(new Point[]{new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2)}),

    REVERSED_SMALL_L(new Point[]{new Point(0, 0), new Point(1, 0), new Point(1, 1)}),

    SMALL_L(new Point[]{new Point(1, 0), new Point(1, 1), new Point(2, 1)}),

    THREE_ON_THREE(new Point[]{new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 0), new Point(0, 2), new Point(2, 1), new Point(1, 2), new Point(2, 2)}),

    TWO_ON_TWO(new Point[]{new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1)});

    private final Point[] tiles;

    BlockShape(Point[] tiles) {
        this.tiles = tiles;
    }

    public static BlockShape randomEnum() {
        return values()[(int) (Math.random() * values().length)];
    }

    public Point[] getTiles() {
        return tiles;
    }

}
