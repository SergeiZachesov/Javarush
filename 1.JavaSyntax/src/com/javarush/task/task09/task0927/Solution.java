package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> catMap = new HashMap<>();
        Cat cat1 = new Cat ("Barsik");
        Cat cat2 = new Cat ("Murzik");
        Cat cat3 = new Cat ("Van'ka");
        Cat cat4 = new Cat ("Murka");
        Cat cat5 = new Cat ("Mashka");
        Cat cat6 = new Cat ("Bor'a");
        Cat cat7 = new Cat ("Funtik");
        Cat cat8 = new Cat ("Felix");
        Cat cat9 = new Cat ("Tuchka");
        Cat cat10 = new Cat ("Nochka");

        catMap.put(cat1.name,cat1);
        catMap.put(cat2.name,cat2);
        catMap.put(cat3.name,cat3);
        catMap.put(cat4.name,cat4);
        catMap.put(cat5.name,cat5);
        catMap.put(cat6.name,cat6);
        catMap.put(cat7.name,cat7);
        catMap.put(cat8.name,cat8);
        catMap.put(cat9.name,cat9);
        catMap.put(cat10.name,cat10);
        return catMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set <Cat> catSet = new HashSet<>();
        for (Map.Entry<String,Cat> m : map.entrySet()) {
            catSet.add(m.getValue());
        }
        return catSet;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
