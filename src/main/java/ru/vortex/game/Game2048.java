package main.java.ru.vortex.game;

import main.java.ru.vortex.assistants.Key;
import main.java.ru.vortex.board.Board;
import main.java.ru.vortex.assistants.Direction;
import main.java.ru.vortex.exception.NotEnoughtSpace;
import main.java.ru.vortex.helper.GameHelper;
import main.java.ru.vortex.board.SquareBoard;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static java.util.Collections.reverse;

public class Game2048 implements Game {
    private GameHelper helper;
    private SquareBoard board;
    private Random random = new Random();

    public static final int GAME_SIZE = 4;
    public Game2048( ) {
        helper = new GameHelper();
        random = new Random();
        board = new SquareBoard<>(GAME_SIZE);
    }

    /*
     *initializes the board and the random
     */
    @Override
    public void init(){
        board.fillBoard(asList(2,2));
    }

    /*
     *Checks for the absence of empty values
     */
    @Override
    public boolean canMove() {
        return (!board.availableSpace().isEmpty());
    }

    /*
     *Moves and adds values
     */
    @Override
    public boolean move(Direction direction) {
        if(canMove()) {
            if (direction == Direction.RIGHT) {
                for (var i = 0; i < board.getHeight(); i++) {
                    List currentValues = board.getValueRow(i);
                    reverse(currentValues);
                    List newValues = helper.moveAndMergeEqual(currentValues);
                    reverse(newValues);
                    for (var j = 0; j < board.getHeight(); j++) {
                        board.setBoard(board.getKey(i, j), newValues.get(j));
                    }
                }
            }
            if (direction == Direction.LEFT) {
                for (var i = 0; i < board.getHeight(); i++) {
                    List newValues = helper.moveAndMergeEqual(board.getValueRow(i));
                    for (var j = 0; j < board.getWidth(); j++) {
                        board.setBoard(board.getKey(i, j), newValues.get(j));
                    }
                }
            }
            if (direction == Direction.UP) {
                for (var i = 0; i < board.getWidth(); i++) {
                    List newValues = helper.moveAndMergeEqual(board.getValueColumn(i));
                    for (var j = 0; j < board.getWidth(); j++) {
                        board.setBoard(board.getKey(j, i), newValues.get(j));
                    }
                }
            }
            if (direction == Direction.DOWN) for (var i = 0; i < board.getWidth(); i++) {
                List currentValues = board.getValueColumn(i);
                reverse(currentValues);
                List newValues = helper.moveAndMergeEqual(currentValues);
                reverse(newValues);
                for (var j = 0; j < board.getWidth(); j++) {
                    board.setBoard(board.getKey(j, i), newValues.get(j));
                }
            }
            try {
                this.addItem();
            } catch (NotEnoughtSpace e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    /*
     *Fills random empty values with a random number
     */
    @Override
    public void addItem() throws NotEnoughtSpace {
        List<Key> spaces = board.availableSpace();
        if (spaces.size()==0) {
            throw new NotEnoughtSpace("Нет места");
        }
        board.setBoard(spaces.get(0), (int) Math.pow(2, random.nextInt(4)));
    }

    /*
     *Returns the board
     */
    @Override
    public Board getGameBoard() {
        return board;
    }

    /*
     *Checks for the presence of 2048 in the values
     */
    @Override
    public boolean hasWin() {
        return board.hasValue(2048);
    }
}
