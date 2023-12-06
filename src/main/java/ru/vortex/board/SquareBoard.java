package main.java.ru.vortex.board;
import main.java.ru.vortex.assistants.Key;

import java.util.*;

public class SquareBoard extends Board {
    public SquareBoard(int size) {
        super(size, size);
    }

    /*
     *Fills the board with values from the List
     */
    @Override
    public void fillBoard(List<Integer> list) {
        board.clear();
        var listIterator = list.listIterator();
        for(var i = 0; i < width; i++){
            for(var j = 0; j < height; j++){
                addItem(new Key(i, j), listIterator.next());
            }
        }
    }

    public void fillBoard(Random random) {
        board.clear();
        for(var i = 0; i < width; i++){
            for(var j = 0; j < height; j++){
                addItem(new Key(i, j), (int) Math.pow(2, random.nextInt(4)));
            }
        }
    }

    /*
     *Adds a value by key
     */
    @Override
    public void addItem(Key key, Integer value) {
        board.put(key, value);
    }

    /*
     *Returns a list of Key with empty Value
     */
    @Override
    public List<Key> availableSpace() {
        List<Key> spaces = new ArrayList<>();
        for (var entry : board.entrySet()) {
            var key = entry.getKey();
            if (entry.getValue() == null) {
                spaces.add(key);
            }
        }
        return spaces;
    }

    /*
     *Gets the Key by coordinates from the board
     */
    @Override
    public Key getKey(int i, int j) {
        for (var entry : board.entrySet()) {
            if (entry.getKey().getI() == i & entry.getKey().getJ() == j) {
                return entry.getKey();
            }
        }
        return null;
    }

    /*
     *Gets the Value
     */
    @Override
    public Integer getValue(Key key) {
        return board.get(key);
    }

    /*
     *Returns Column Key
     */
    @Override
    public List<Key> getColumn(int i) {
        List<Key> columnKeys = new ArrayList<>();
        for(var j = 0; j < height; j++){
            columnKeys.add(getKey(j, i));
        }
        return columnKeys;
    }

    /*
     *Returns Row Key
     */
    @Override
    public List<Key> getRow(int i) {
        List<Key> rowKeys = new ArrayList<>();
        for(var j = 0; j < height; j++){
            rowKeys.add(getKey(i, j));
        }
        return rowKeys;
    }

    /*
     *Checks for the presence of a value
     */
    @Override
    public boolean hasValue(Integer value) {
        return board.containsValue(value);
    }

    /*
     *Checks Values
     */
    @Override
    public List<Integer> getValues(List<Key> keys) {
        List<Integer> values = new ArrayList<>();
        for (var key : keys) {
            values.add(board.get(key));
        }
        return values;
    }

    /*
     *Returns Column Values
     */
    public List<Integer> getValueRow(int i){
        return getValues(getRow(i));
    }

    /*
     *Returns Column Values
     */
    public List<Integer> getValueColumn(int i){
        return getValues(getColumn(i));
    }

}
