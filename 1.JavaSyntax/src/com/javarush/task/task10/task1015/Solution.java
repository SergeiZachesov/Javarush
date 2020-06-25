package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String> aaa = new ArrayList<>();
        aaa.add("sdfas");
        aaa.add("sdfas1");
        ArrayList<String> aaa1 = new ArrayList<>();
        aaa1.add("sdfas1");
        aaa1.add("sdfas11");

        ArrayList<String>[] allAr = new ArrayList[2];
        allAr[0] = aaa;
        allAr[1] = aaa1;


        return allAr;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}