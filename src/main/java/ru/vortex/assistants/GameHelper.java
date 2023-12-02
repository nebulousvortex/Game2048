package main.java.ru.vortex.assistants;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GameHelper {
    public List<Integer> moveAndMergeEqual(List<Integer> list){
        ListIterator<Integer> listIterator = list.listIterator();
        List<Integer> newList = new ArrayList<>();
        while (listIterator.hasNext()){
            if(listIterator.next()==null){
                listIterator.next();
            }
        }
        return newList;
    }
}
