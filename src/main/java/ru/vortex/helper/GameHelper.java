package main.java.ru.vortex.helper;

import java.util.*;

public class GameHelper {

    /*
    * Moves the values and adds the same and adjacent ones
     */
    public List<Integer> moveAndMergeEqual(List<Integer> listWithNull){
        if(!checkFullNull(listWithNull)) {
            var size = listWithNull.size();
            var listNoNull = new ArrayList<>(listWithNull);
            if (listNoNull.contains(null)) {
                listNoNull.removeAll(Collections.singleton(null));
            }
            List<Integer> mergedList = merge(listNoNull);
            mergedList = addNulls(mergedList, size);
            return mergedList;
        }
        return listWithNull;
    }

    /*
     *Checks whether the received List does not consist entirely of null
     */
    public boolean checkFullNull(List<Integer> nullList){
        var iterator = nullList.iterator();
        var count = 0;
        while (iterator.hasNext()){
            if (iterator.next() == null){
                count++;
            }
        }
        return count == nullList.size();
    }

    /*
     *Adds null to the size of the List
     */
    public List<Integer> addNulls(List<Integer> newList, int size){
        if (newList.size() != size) {
            for (var j = newList.size(); j < size; j++) {
                newList.add(null);
            }
        }
        return newList;
    }
    /*
     *Adds equal values
     */
    public List<Integer> merge(List<Integer> list){
        var i = 0;
        var iterator = list.iterator();
        List<Integer> newList = new ArrayList<>();
        newList.add(iterator.next());
        while (iterator.hasNext()) {
            var current = iterator.next();
            if (newList.get(i).equals(current)) {
                newList.set(i, 2 * current);
                if (iterator.hasNext()) {
                    newList.add(iterator.next());
                    i++;
                }
            } else {
                newList.add(current);
                i++;
            }
        }
        return newList;
    }
}
