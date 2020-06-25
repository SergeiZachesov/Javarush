package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Зачесов", "Сргей");
        map.put("Зачесов2", "Сргей");
        map.put("Зачесов3", "Сргей");
        map.put("Зачесов4", "Сргей");
        map.put("Зачесов5", "Сргей");
        map.put("Зачесов6", "Сргей");
        map.put("Зачесов7", "Сргей");
        map.put("Зачесов8", "Сргей");
        map.put("Зачесов9", "Сргей");
        map.put("Зачесов10", "Сргей");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> buff = new ArrayList<String>(map.values());
        for (int out = buff.size() - 1; out >= 1; out--){
            for(int i=0; i<out; i++) {
                if(buff.get(out).equals(buff.get(i))) {
                    removeItemFromMapByValue(map, buff.get(i));
                }
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
