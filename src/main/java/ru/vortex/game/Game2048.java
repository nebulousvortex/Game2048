package main.java.ru.vortex.game;

import main.java.ru.vortex.board.Board;
import main.java.ru.vortex.assistants.Direction;
import main.java.ru.vortex.helper.GameHelper;
import main.java.ru.vortex.board.SquareBoard;
import java.util.Random;

import static java.util.Collections.reverse;

public class Game2048 implements Game {
    private GameHelper helper;
    private final SquareBoard board;
    private Random random = new Random();
    public Game2048(SquareBoard board) {
        this.board = board;
        this.init();
    }

    /*
     *initializes the board and the random
     */
    @Override
    public void init(){
        helper = new GameHelper();
        random = new Random();
        board.fillBoard(random);
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
    public void move(Direction direction) {
        if (direction == Direction.RIGHT){
            for(var i = 0; i < board.getHeight(); i++){
                var values = helper.moveAndMergeEqual(board.getValueRow(i));
                reverse(values);
            }
        }
        if (direction == Direction.LEFT){
            for(var i = 0; i < board.getHeight(); i++){
                helper.moveAndMergeEqual(board.getValueRow(i));
            }
        }
        if (direction == Direction.UP){
            for(var i = 0; i < board.getWidth(); i++){
                helper.moveAndMergeEqual(board.getValueColumn(i));
            }
        }
        if (direction == Direction.DOWN){
            for(var i = 0; i < board.getWidth(); i++){
                var values = helper.moveAndMergeEqual(board.getValueColumn(i));
                reverse(values);
            }
        }
    }

    /*
     *Fills random empty values with a random number
     */
    @Override
    public void addItem() {
        var spaces = board.availableSpace();
        board.setBoard(spaces.get(random.nextInt(spaces.size()-1)), (int) Math.pow(2, random.nextInt(4)));
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
