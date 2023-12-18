package main.java.ru.vortex.game;

import main.java.ru.vortex.board.Board;
import main.java.ru.vortex.assistants.Direction;
import main.java.ru.vortex.exception.NotEnoughtSpace;

public interface Game {
    void init();

    boolean canMove();

    boolean move(Direction direction);

    void addItem() throws NotEnoughtSpace;

    Board getGameBoard();

    boolean hasWin();

}
