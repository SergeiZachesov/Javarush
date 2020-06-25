package com.javarush.task.task08.task0818;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("Зачесов", 100);
        map.put("Зачесов2", 501);
        map.put("Зачесов3", 499);
        map.put("Зачесов4", 499);
        map.put("Зачесов5", 499);
        map.put("Зачесов6", 499);
        map.put("Зачесов7", 499);
        map.put("Зачесов8", 499);
        map.put("Зачесов9", 499);
        map.put("Зачесов10", 499);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            String key = pair.getKey();            //ключ
            Integer value = pair.getValue();

            if (value < 500)
                iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}