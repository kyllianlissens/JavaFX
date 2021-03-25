package be.kdg.java.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    static private List<Block> blocksToBeUsed;
    private final Gameboard gameBoard;
    private final UserReaderWriter userReaderWriter;
    private final MediaPlayer mediaPlayer;
    public int score;
    private User user;
    private boolean playMusic;

    public Game() {


        File f = new File("resources/music/gamesong.mp3");
        Media pick = new Media(f.toURI().toString());

        score = 0;
        playMusic = true;

        gameBoard = new Gameboard();
        blocksToBeUsed = new ArrayList<>();
        userReaderWriter = new UserReaderWriter();

        mediaPlayer = new MediaPlayer(pick);
        mediaPlayer.play();
        mediaPlayer.setVolume(0.02);


        generateNewBlocks();


    }


    public void placeBlock(Block block, int x, int y) throws Exception {
        if (gameBoard.canPlaceBlock(block, new Point(x, y))){
            gameBoard.placeBlock(block, new Point(x, y));
            score += 5;
            blocksToBeUsed.remove(block);
            if (blocksToBeUsed.size() == 0) {
                generateNewBlocks();
            }
        }
        else{
            throw new Exception("You can't place a block here!");
        }


        for (int i = 0; i < gameBoard.getPointGrid().size(); i++) {
            if (gameBoard.getPointGrid().get(i).stream().allMatch(e -> e.getColor().equals(Color.BLACK))) {
                score += 10;
                gameBoard.getPointGrid().get(i).forEach(horizontalBlock -> horizontalBlock.setColor(Color.white));
            }

            for (int j = 0; j < gameBoard.getPointGrid().get(i).size(); j++) {
                int finalYValue = j;
                if (gameBoard.getPointGrid().stream().allMatch(e -> e.get(finalYValue).getColor().equals(Color.black))) {
                    score += 10;
                    gameBoard.getPointGrid().forEach(e -> e.get(finalYValue).setColor(Color.white));
                }
            }
        }



    }

    public boolean checkGameOver(){
        if (!canStillPlaceBlocks()) {
            if (score > user.getHighscore()) {
                User userToSave = userReaderWriter.getUsers().stream().filter(e -> e.getUsername().equals(user.getUsername())).findAny().get();
                userToSave.setHighscore(score);
                save();
            }
            return true;
        }
        return false;
    }

    public boolean canStillPlaceBlocks(){
        for (Block b : blocksToBeUsed) {
            for (int i = 0; i < gameBoard.getPointGrid().size(); i++) {
                for (int j = 0; j < gameBoard.getPointGrid().get(i).size(); j++) {
                    if (gameBoard.canPlaceBlock(b, new Point(j, i))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public void generateNewBlocks() {
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

    public boolean isPlayMusic() {
        return playMusic;
    }

    public void setPlayMusic(boolean playMusic) {
        this.playMusic = playMusic;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }



}
