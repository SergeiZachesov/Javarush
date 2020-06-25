package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Зачесов", "Сргей");
        map.put("Зачесов2", "Паша");
        map.put("Зачесов3", "Сргей");
        map.put("Зачесов4", "Коля");
        map.put("Зачесов", "Сргей");
        map.put("Зачесов6", "Сргей");
        map.put("Зачесов7", "Сргей");
        map.put("Зачесов8", "Сргей");
        map.put("Зачесов9", "Сргей");
        map.put("Зачесов10", "Сргей");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
