package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public Gameboard gameBoard;
    public List<Block> blocksToBeUsed;
    private UserReaderWriter userReaderWriter;


    public Game () throws IOException {
        gameBoard = new Gameboard();
        blocksToBeUsed = new ArrayList<Block>();
        generateNewBlocks();
        userReaderWriter = new UserReaderWriter();
    }

    public void generateNewBlocks(){
        //This feels off to init the array and then fill it?
        blocksToBeUsed.clear();
        for (int i = 0; i < 3; i++) {
            blocksToBeUsed.add(new Block(BlockShape.randomEnum()));
        }
    }
    public User login(String username, String wachtwoord) throws Exception {
        return userReaderWriter.login(username, wachtwoord);
    }
    public User register(String username, String wachtwoord) throws Exception{
        return userReaderWriter.register(username, wachtwoord);
    }
    public void save(){
        userReaderWriter.save();
    }
    public List<User> getUserSortedByHighscore(){
        return userReaderWriter.users.stream().sorted(Comparator.comparing(User::getHighscore).reversed()).collect(Collectors.toList());
    }


}
