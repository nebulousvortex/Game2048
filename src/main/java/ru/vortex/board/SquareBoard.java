package main.java.ru.vortex.board;
import main.java.ru.vortex.assistants.Key;

import java.util.*;

public class SquareBoard extends Board {

    public SquareBoard(int size) {
        super(size, size);
    }
    @Override
    public void fillBoard(List<Integer> list) {
        ListIterator<Integer> listIterator = list.listIterator();
        for(int i = 0; i<this.width; i++){
            for(int j = 0; j<this.height; j++){
                this.addItem(new Key(i,j),listIterator.next());
            }
        }
    }

    @Override
    public void addItem(Key key, Integer value) {
        this.board.put(key, value);
    }

    @Override
    public List<Key> availableSpace() {
        List<Key> spaces = new ArrayList<>();
        for (Map.Entry<Key, Integer> entry : this.board.entrySet()){
            if (entry.getValue() == null){
                spaces.add(entry.getKey());
            }
        }
        return null;
    }

    @Override
    public List<Key> availableItem(Key key, Integer value) {
        return null;
    }

    @Override
    public Key getKey(int i, int j) {
        return new Key(i, j);
    }

    @Override
    public Integer getValue(Key key) {
        return this.board.get(key);
    }

    @Override
    public List<Key> getColumn(int i) {
        List<Key> columnKeys = new ArrayList<>();
        for(int j = 0; i<this.height; j++){
            columnKeys.add(new Key(j,i));
        }
        return columnKeys;
    }

    @Override
    public List<Key> getRow(int i) {
        List<Key> rowKeys = new ArrayList<>();
        for(int j = 0; i<this.height; j++){
            rowKeys.add(new Key(i,j));
        }
        return rowKeys;
    }

    @Override
    public boolean hasValue(Integer value) {
        return this.board.containsValue(value);
    }

    @Override
    public List<Integer> getValues(List<Key> keys) {
        List<Integer> values = new ArrayList<>();
        ListIterator<Key> listIterator = keys.listIterator();
        while(listIterator.hasNext()){
            values.add(this.board.get(listIterator.next()));
        }
        return values;
    }
}
