package com.company;

import java.awt.*;
import java.util.Scanner;


public class Main {

    private static Game game;

    public static void main(String[] args){


        game = new Game(); //init game

        Scanner scanner = new Scanner(System.in);

        System.out.println("|-----------------------------------|");
        System.out.println("| 1. Login                          |");
        System.out.println("| 2. Register                       |");
        System.out.println("| 3. View scoreboard                |");
        System.out.println("|-----------------------------------|");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                System.out.print("Username: ");
                String loginUsername = scanner.next();
                System.out.print("Password: ");
                String loginPassword = scanner.next();

                try {
                    game.login(loginUsername, loginPassword);
                    System.out.println("Successful login!");
                    playGame();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case 2:
                System.out.print("Username: ");
                String registerUsername = scanner.next();
                System.out.print("Password: ");
                String registerPassword = scanner.next();

                try {
                    game.register(registerUsername, registerPassword);
                    System.out.println("Successful register!");
                    playGame();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            case 3:
                for (User user : game.getUserSortedByHighscore()){
                    System.out.println(user.toString());
                }

                break;

        }




    }
    public static void playGame(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("|-------------------------------------------|");
        System.out.println(" Welcome, " + game.getUser().getUsername() + "! ");
        System.out.println(" Current highscore: " + game.getUser().getHighscore());
        System.out.println("|-------------------------------------------|");
        Scanner scanner = new Scanner(System.in);
        boolean alive = true;
        while (alive){



        }


        System.out.println(game.getGameBoard().placeBlock(game.getBlocksToBeUsed().get(0), new Point(2,2)));//ugly 2 block placement
        System.out.println(game.getGameBoard().placeBlock(game.getBlocksToBeUsed().get(1), new Point(2,2)));//this one should fail

        //Simple 2D iteration to view which tiles have a white rectangle or not
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                System.out.print(game.getGameBoard().getPointGrid().get(y).get(x).getColor().equals(Color.white) ? 1 + " ": 0 + " ");
            }
            System.out.println();
        }
    }

}
