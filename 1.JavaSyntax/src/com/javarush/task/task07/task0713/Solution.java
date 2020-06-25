package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> array = new ArrayList<Integer>();
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        ArrayList<Integer> array3 = new ArrayList<Integer>();


        for (int i = 0; i < 20; i++) {
            array.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < 20; i++) {

                if (array.get(i) % 3 == 0)
                    array1.add(array.get(i));
                if (array.get(i) % 2 == 0)
                    array2.add(array.get(i));
                if (array.get(i) % 2 != 0 && array.get(i) % 3 != 0)
                array3.add(array.get(i));

        }
        printList(array1);
        printList(array2);
        printList(array3);
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
