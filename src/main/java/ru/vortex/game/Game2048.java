package main.java.ru.vortex.game;

import main.java.ru.vortex.board.Board;
import main.java.ru.vortex.assistants.Direction;
import main.java.ru.vortex.assistants.GameHelper;

import java.util.Random;

public class Game2048 implements Game {
    private GameHelper helper = new GameHelper();
    private Board board;
    private Random random = new Random();
    public Game2048(Board board) {
        this.board = board;
    }

    @Override
    public void init() {
        //this.board.fillBoard();
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public boolean move(Direction direction) {
        return false;
    }

    @Override
    public void addItem() {

    }

    @Override
    public Board getGameBoard() {
        return null;
    }

    @Override
    public boolean hasWin() {
        return false;
    }
}
