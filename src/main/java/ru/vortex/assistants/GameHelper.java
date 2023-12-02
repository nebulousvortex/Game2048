package main.java.ru.vortex.assistants;

import java.util.*;

public class GameHelper {
    public List<Integer> moveAndMergeEqual(List<Integer> nullList){
        if(checkFullNull(nullList)) {
            int size = nullList.size();
            List<Integer> list = new ArrayList<>(nullList);
            if (list.contains(null)) {
                list.removeAll(Collections.singleton(null));
            }
            List<Integer> newList = merge(list);
            newList = addNulls(newList, size);
            return newList;
        }
        return nullList;
    }

    public boolean checkFullNull(List<Integer> nullList){
        Iterator<Integer> iterator = nullList.iterator();
        int count = 0;
        while (iterator.hasNext()){
            if (iterator.next() == null){
                count++;
            }
        }
        return !(count == nullList.size());
    }

    public List<Integer> addNulls(List<Integer> newList, int size){
        if (newList.size() != size) {
            for (int j = newList.size(); j < size; j++) {
                newList.add(null);
            }
        }
        return newList;
    }

    public List<Integer> merge(List<Integer> list){
        int i = 0;
        Iterator<Integer> iterator = list.iterator();
        List<Integer> newList = new ArrayList<>();
        newList.add(iterator.next());
        while (iterator.hasNext()) {
            int current = iterator.next();
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
