package main.java.ru.vortex.board;
import main.java.ru.vortex.assistants.Key;

import java.util.*;

public class SquareBoard<V> extends Board<Key, V> {

    public SquareBoard(int size) {
        super(size, size);
    }

    /*
     *Fills the board with values from the List
     */
    public void fillBoard(List<V> list) {
        this.board.clear();
        if (list.size() > (16)){
            throw new RuntimeException();
        }
        ListIterator<V> listIterator = list.listIterator();
        for(var i = 0; i<this.width; i++){
            for(var j = 0; j<this.height; j++){
                if(listIterator.hasNext()) {
                    this.addItem(new Key(i, j), listIterator.next());
                }else {
                    this.addItem(new Key(i, j), null);
                }
            }
        }
    }

    /*
     *Adds a value by key
     */
    @Override
    public void addItem(Key key, V value) {
        this.board.put(key,value);
    }

    /*
     *Returns a list of Key with empty Value
     */
    @Override
    public List<Key> availableSpace() {
        List<Key> spaces = new ArrayList<>();
        for (Map.Entry<Key, V> entry : this.board.entrySet()) {
            Key key = entry.getKey();
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
        for (Map.Entry<Key, V> entry : this.board.entrySet()) {
            if (entry.getKey().getI() == i & entry.getKey().getJ() == j) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public void setBoard(Key key, V value) {
        board.put(key, value);
    }

    /*
     *Gets the Value
     */
    @Override
    public V getValue(Key key) {
        return this.board.get(key);
    }

    /*
     *Returns Column Key
     */
    @Override
    public List<Key> getColumn(int i) {
        List<Key> columnKeys = new ArrayList<>();
        for(int j = 0; j<this.height; j++){
            columnKeys.add(this.getKey(j,i));
        }
        return columnKeys;
    }

    /*
     *Returns Row Key
     */
    @Override
    public List<Key> getRow(int i) {
        List<Key> rowKeys = new ArrayList<>();
        for(int j = 0; j<this.height; j++){
            rowKeys.add(this.getKey(i,j));
        }
        return rowKeys;
    }

    /*
     *Checks for the presence of a value
     */
    @Override
    public boolean hasValue(V value) {
        return this.board.containsValue(value);
    }

    /*
     *Checks Values
     */
    @Override
    public List<V> getValues(List<Key> keys) {
        List<V> values = new ArrayList<>();
        for (Key key : keys) {
            values.add(this.board.get(key));
        }
        return values;
    }

    /*
     *Returns Column Values
     */
    public List<V> getValueRow(int i){
        return getValues(getRow(i));
    }

    /*
     *Returns Column Values
     */
    public List<V> getValueColumn(int i){
        return getValues(getColumn(i));
    }

}
