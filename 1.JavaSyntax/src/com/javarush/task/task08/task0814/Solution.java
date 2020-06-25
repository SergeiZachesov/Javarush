package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<20; i++) {
            set.add(i*2);
        }
        return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
        {
            Integer a = iterator.next();
            if (a>10)
                iterator.remove();
        }
        return set;
    }

    public static void main(String[] args) {
    }
}
