package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 5; i++)
        {
            String s = "1";
            list.add(s);
        }
        System.out.println(list.size());
        for (int i = 0; i < 5; i++)
        {

            System.out.println(list.get(i));
        }
    }
}
