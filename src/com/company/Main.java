package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Game g = new Game(); //init game
        System.out.println(g.gameBoard.placeBlock(g.blocksToBeUsed.get(0), new Point(2,2)));//ugly 2 block placement
        System.out.println(g.gameBoard.placeBlock(g.blocksToBeUsed.get(1), new Point(2,2)));//this one should fail

        //Simple 2D iteration to view which tiles have a white rectangle or not
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                System.out.print(g.gameBoard.pointGrid.get(y).get(x).getColor().equals(Color.white) ? 1 + " ": 0 + " ");
            }
            System.out.println();
        }
    }
}
