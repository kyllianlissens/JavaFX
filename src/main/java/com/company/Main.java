package com.company;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws Exception {




        Game g = new Game(); //init game







        g.save();

        System.out.println(g.gameBoard.placeBlock(g.blocksToBeUsed.get(0), new Point(2,2)));//ugly 2 block placement
        System.out.println(g.gameBoard.placeBlock(g.blocksToBeUsed.get(1), new Point(2,2)));//this one should fail




        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                System.out.print(g.gameBoard.pointGrid.get(y).get(x).getColor().equals(Color.white) ? 1 + " ": 0 + " ");
            }
            System.out.println();
        }
    }
}
