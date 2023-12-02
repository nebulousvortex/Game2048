package main.java.ru.vortex.board;
import main.java.ru.vortex.assistants.Key;

import java.util.*;

public class SquareBoard extends Board {

    public SquareBoard(int size) {
        super(size, size);
    }
    @Override
    public void fillBoard(List<Integer> list) {
        this.board.clear();
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
        for (Map.Entry<Key, Integer> entry : this.board.entrySet()) {
            Key key = entry.getKey();
            if (entry.getValue() == null) {
                spaces.add(key);
            }
        }
        return spaces;
    }

    @Override
    public List<Key> availableItem(Key key, Integer value) {
        return null;
    }

    @Override
    public Key getKey(int i, int j) {
        for (Map.Entry<Key, Integer> entry : this.board.entrySet()) {
            if (entry.getKey().getI() == i & entry.getKey().getJ() == j) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public Integer getValue(Key key) {
        return this.board.get(key);
    }

    @Override
    public List<Key> getColumn(int i) {
        List<Key> columnKeys = new ArrayList<>();
        for(int j = 0; j<this.height; j++){
            columnKeys.add(this.getKey(j,i));
        }
        return columnKeys;
    }

    @Override
    public List<Key> getRow(int i) {
        List<Key> rowKeys = new ArrayList<>();
        for(int j = 0; j<this.height; j++){
            rowKeys.add(this.getKey(i,j));
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
