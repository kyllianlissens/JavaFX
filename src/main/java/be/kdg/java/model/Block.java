package be.kdg.java.model;

import java.awt.*;

public class Block {

    private final BlockShape shape;

    private Point location;

    public Block(BlockShape Shape){
            this.shape = Shape;
    }

    public BlockShape getShape() {
        return shape;
    }


    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }


}
