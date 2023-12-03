package main.java.ru.vortex.board;

import main.java.ru.vortex.assistants.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board {
    protected int width, height;
    protected Map<Key, Integer> board = new HashMap<>();

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract void fillBoard(List<Integer> list);

    public abstract void addItem(Key key, Integer value);
    public abstract List<Key> availableSpace();

    public abstract List<Key> availableItem(Key key, Integer value);

    public abstract Key getKey(int i, int j);

    public void setBoard(Key key, Integer value) {
        this.board.put(key, value);
    }

    public abstract Integer getValue(Key key);

    public abstract List<Key> getColumn(int i);

    public abstract List<Key> getRow(int i);

    public abstract boolean hasValue(Integer value);

    public abstract List<Integer> getValues(List<Key> keys);

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
