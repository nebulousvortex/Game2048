package main.java.ru.vortex.game;

import main.java.ru.vortex.board.Board;
import main.java.ru.vortex.assistants.Direction;

public interface Game {
    void init();

    boolean canMove();

    boolean move(Direction direction);

    void addItem();

    Board getGameBoard();

    boolean hasWin();

}
