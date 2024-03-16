package model;

import java.util.HashMap;
import java.util.Map;

public class OperationPriority {
    Map<Character, Integer> map = new HashMap<>();

    public void setMap(){
        map.put('(',0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('~', 3);
    }

    public boolean containKey(Character character){
        return map.containsKey(character);
    }
    public Integer getPriority (Character character) {
        return map.get(character);
    }

}
