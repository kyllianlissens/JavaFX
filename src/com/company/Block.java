package com.company;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Block {

    public BlockShape shape;

    public Point location; //Location of the block, unneeded?

    public Block(BlockShape Shape){
            shape = Shape;
    }
}
