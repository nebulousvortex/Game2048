package main.java.ru.vortex.test;

import main.java.ru.vortex.board.SquareBoard;
import main.java.ru.vortex.game.Game;
import main.java.ru.vortex.game.Game2048;

public class TestClass {
    public static void main(String[] args){
        SquareBoard board = new SquareBoard(4);
        Game game2048 = new Game2048();
        System.out.println(game2048.canMove());
    }


}
