package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<String>();

        for (int i = 0; i < 5; i++)
        {
            strings.add(reader.readLine());
        }

        int min = strings.get(1).length();
        for (int i = 0; i < 5; i++)
        {
            if (strings.get(i).length()<=min)
                min = strings.get(i).length();
        }
        for (int i = 0; i < 5; i++)
        {
            if (strings.get(i).length()<=min)
                System.out.println (strings.get(i));
        }
    }
}
