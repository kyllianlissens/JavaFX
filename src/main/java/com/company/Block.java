package com.company;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Block {

    private BlockShape shape;

    private Point location; //Location of the block, unneeded?

    public Block(BlockShape Shape){
            this.shape = Shape;
    }

    public BlockShape getShape() {
        return shape;
    }

    public void setShape(BlockShape shape) {
        this.shape = shape;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
