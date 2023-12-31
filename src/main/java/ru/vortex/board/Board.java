package main.java.ru.vortex.board;

import main.java.ru.vortex.assistants.Key;

import java.util.*;

public abstract class Board<K, V> {
    protected int width, height;
    protected Map<K, V> board = new HashMap<>();

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract void fillBoard(List<V> list);

    //public abstract void fillBoard(Random random);

    public abstract void addItem(K key, V value);
    public abstract List<K> availableSpace();

    public abstract K getKey(int i, int j);

    public void setBoard(K key, V value) {
        this.board.put(key, value);
    }

    public abstract V getValue(K key);

    public abstract List<K> getColumn(int i);

    public abstract List<K> getRow(int i);

    public abstract boolean hasValue(V value);

    public abstract List<V> getValues(List<K> keys);

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
