package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
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

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int nameNum = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String value = pair.getValue();                      //ключ
            if(value.equals(name))
                nameNum++;
        }
        return nameNum;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int nameNum = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            if(key.equals(lastName))
                nameNum++;
        }
        return nameNum;
    }

    public static void main(String[] args) {
        //Map<String, String> map =createMap();
        //System.out.println(getCountTheSameFirstName(map, "Сргей"));
        //System.out.println(getCountTheSameLastName(map, "Зачесов"));
    }
}
