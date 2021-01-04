package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final Gameboard gameBoard;
    private List<Block> blocksToBeUsed;
    private final UserReaderWriter userReaderWriter;
    private User user;

    public Game () {
        gameBoard = new Gameboard();
        blocksToBeUsed = new ArrayList<>();
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
        return user = userReaderWriter.login(username, wachtwoord);
    }

    public User register(String username, String wachtwoord) throws Exception{
        return user = userReaderWriter.register(username, wachtwoord);
    }

    public void save(){
        userReaderWriter.save();
    }

    public Gameboard getGameBoard() {
        return gameBoard;
    }

    public List<Block> getBlocksToBeUsed() {
        return blocksToBeUsed;
    }

    public List<User> getUserSortedByHighscore(){
        return userReaderWriter.getUsers().stream().sorted(Comparator.comparing(User::getHighscore).reversed()).collect(Collectors.toList());
    }

    public User getUser() {
        return user;
    }
}
