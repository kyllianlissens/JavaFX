package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public Gameboard gameBoard;
    public List<Block> blocksToBeUsed;

    public Game (){
        gameBoard = new Gameboard();
        blocksToBeUsed = new ArrayList<Block>();
        generateNewBlocks();
    }

    public void generateNewBlocks(){
        blocksToBeUsed.clear();
        for (int i = 0; i < 3; i++) {
            blocksToBeUsed.add(new Block(BlockShape.randomEnum()));
        }
    }


}
