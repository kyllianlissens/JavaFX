package be.kdg.java.model;

import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.util.*;
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
    private MediaPlayer mediaPlayer;

    public Game() {
        gameBoard = new Gameboard();
        blocksToBeUsed = new ArrayList<>();
        generateNewBlocks();
        userReaderWriter = new UserReaderWriter();
        score = 0;
    }


    public void placeBlock(Block block, int x, int y) throws Exception {
        if (gameBoard.placeBlock(block, new Point(x, y))) {

            score += 5;

            blocksToBeUsed.remove(block);
            if (blocksToBeUsed.size() == 0) {
                generateNewBlocks();
            }

        } else {
            throw new Exception("Can't place block here");
        }



        for (int i = 0; i < gameBoard.getPointGrid().size(); i++) {
            if (gameBoard.getPointGrid().get(i).stream().allMatch(e -> e.getColor().equals(Color.BLACK))) {
                score += 10;
                gameBoard.getPointGrid().get(i).forEach(horizontalBlock -> {
                    horizontalBlock.setColor(Color.white);
                });
            }

            for (int j = 0; j < gameBoard.getPointGrid().get(i).size(); j++) {
                int finalYValue = j;
                if(gameBoard.getPointGrid().stream().allMatch(e-> e.get(finalYValue).getColor().equals(Color.black))){
                    score += 10;
                    gameBoard.getPointGrid().forEach(e-> e.get(finalYValue).setColor(Color.white));
                }
            }
        }


        boolean canBlocksStillBePlaced = false;
        for (Block b : blocksToBeUsed) {
            for (int i = 0; i < gameBoard.getPointGrid().size(); i++) {
                for (int j = 0; j < gameBoard.getPointGrid().get(i).size(); j++) {
                    if (gameBoard.canPlaceBlock(b, new Point(j, i))) {
                        canBlocksStillBePlaced = true;
                    }
                }
            }
        }

        if (!canBlocksStillBePlaced) {
            if (score > user.getHighscore()){
                User userToSave = userReaderWriter.getUsers().stream().filter(e -> e.getUsername().equals(user.getUsername())).findAny().get();
                userToSave.setHighscore(score);
                save();
            }

            throw new Exception("Game over");
        };

    }



    public void generateNewBlocks() {
        //This feels off to init the array and then fill it?
        blocksToBeUsed.clear();
        for (int i = 0; i < 3; i++) {
            blocksToBeUsed.add(new Block(BlockShape.randomEnum()));
        }
    }

    public void login(String username, String password) throws Exception {
        this.user = userReaderWriter.login(username, password);
    }

    public void register(String username, String password) throws Exception {
        this.user = userReaderWriter.register(username, password);
    }

    public void save() {
        userReaderWriter.save();
    }

    public Gameboard getGameBoard() {
        return gameBoard;
    }

    public List<Block> getBlocksToBeUsed() {
        return blocksToBeUsed;
    }

    public List<User> getUserSortedByHighscore() {
        return userReaderWriter.getUsers().stream().sorted(Comparator.comparing(User::getHighscore).reversed()).collect(Collectors.toList());
    }

    public User getUser() {
        return user;
    }


    public static <T> Consumer<T> withCounter(BiConsumer<Integer, T> consumer) {
        AtomicInteger counter = new AtomicInteger(0);
        return item -> consumer.accept(counter.getAndIncrement(), item);
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
}
