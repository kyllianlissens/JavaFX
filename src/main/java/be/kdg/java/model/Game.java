package be.kdg.java.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Game {
    private final Gameboard gameBoard;
    static private List<Block> blocksToBeUsed;
    private final UserReaderWriter userReaderWriter;
    private User user;
    public int score;

    public Game () {
        gameBoard = new Gameboard();
        blocksToBeUsed = new ArrayList<>();
        generateNewBlocks();
        userReaderWriter = new UserReaderWriter();
        score = 0;
    }


    public void placeBlock(Block block, int x, int y) throws Exception {
        if (gameBoard.placeBlock(block, new Point(x, y))){
            System.out.println(blocksToBeUsed.remove(block));
            if (blocksToBeUsed.size() == 0){
                generateNewBlocks();
            }
        }else{
            throw new Exception("Can't place block here");
        }
        /*
        0   1   2   3   4   5
        1   1   2   3   4   5
        2   1   2   3   4   5
        3   1   2   3   4   5
        4   1   2   3   4   5
        5   1   2   3   4   5
        */
        //horizontaal
        for(int i = 0; i < gameBoard.getPointGrid().size();i++){
            if(gameBoard.getPointGrid().get(i).stream().allMatch(e->e.getColor().equals(Color.BLACK))){

                int finalI = i;
                gameBoard.getPointGrid().get(i).forEach(withCounter((index, e) -> {
                    Block b = Gameboard.getPlacedBlocks().stream().filter(element -> element.getLocation().y == finalI  && element.getLocation().x == index).findAny().orElse(null);
                    if (b != null){
                        System.out.println("Score to be added: " + b.getShape().getDifficulty());
                        score += b.getShape().getDifficulty();

                    }
                    e.setColor(Color.white);
                }));


            }

        }/*
        //verticaal
        for (int i = 0; i < gameBoard.getPointGrid().size(); i++) {
            if(gameBoard.getPointGrid().get(i).stream().allMatch(e->e.getColor().equals(Color.white))){
                score += 10;
                gameBoard.getPointGrid().get(i).forEach(e->e.setColor(Color.black));
            }

            //verticaal check?
            for (int j = 0; j < gameBoard.getPointGrid().get(i).size(); j++) {
                int finalJ = j;
                if(gameBoard.getPointGrid().stream().allMatch(e-> e.get(finalJ).getColor().equals(Color.white))){
                    score += 10;
                    gameBoard.getPointGrid().get(i).forEach(e->e.setColor(Color.black));
                    gameBoard.getPointGrid().stream().forEach(e-> e.get(finalJ).setColor(Color.black));
                }

            }
        }*/


    }



    public void generateNewBlocks(){
        //This feels off to init the array and then fill it?
        blocksToBeUsed.clear();
        for (int i = 0; i < 3; i++) {
            blocksToBeUsed.add(new Block(BlockShape.randomEnum()));
        }
    }

    public void login(String username, String password) throws Exception {
        this.user = userReaderWriter.login(username, password);
    }

    public void register(String username, String password) throws Exception{
        this.user = userReaderWriter.register(username, password);
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


    public static <T> Consumer<T> withCounter(BiConsumer<Integer, T> consumer) {
        AtomicInteger counter = new AtomicInteger(0);
        return item -> consumer.accept(counter.getAndIncrement(), item);
    }
}
