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
        clearConsole();
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
                break;

            case 3:
                for (User user : game.getUserSortedByHighscore()){
                    System.out.println(user.toString());
                }
                break;

        }




    }
    public static void playGame(){
        clearConsole();

        System.out.println("|-------------------------------------------|");
        System.out.println(" Welcome, " + game.getUser().getUsername() + "! ");
        System.out.println(" Current highscore: " + game.getUser().getHighscore());
        System.out.println("|-------------------------------------------|");
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("|-------------------------------------------|");
            displayGrid();
            System.out.println("|-------------------------------------------|");
            System.out.println("Choose block to place! or type -1 to stop playing");
            for (int i = 0; i < game.getBlocksToBeUsed().size(); i++) {
                System.out.println( i + ". " + game.getBlocksToBeUsed().get(i).getShape().name());
            }

            int input = scanner.nextInt();

            if(input == -1){
                break;
            }else{
                Block blockToBePlaced = game.getBlocksToBeUsed().get(input);

                System.out.print("Y coordinate: ");
                int y = scanner.nextInt();

                System.out.print("X coordinate: ");
                int x = scanner.nextInt();

                try {
                    game.placeBlock(blockToBePlaced, x, y);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }



        }
        clearConsole();

    }


    public static void clearConsole(){
        //Tried 10 different methods, nothing worked :(
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void displayGrid(){
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                System.out.print(game.getGameBoard().getPointGrid().get(y).get(x).getColor().equals(Color.white) ? 1 + " ": 0 + " ");
            }
            System.out.println();
        }
    }

}
