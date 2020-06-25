package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        int[] array1 = new int[10];
        int[] array2 = new int[10];


        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < array1.length; i++)
        {
            array1[i] = array[i];
        }

        int j = 10;
        for (int i = 0; i < array2.length; i++)
        {
            array2[i] = array[j];
            j++;
            System.out.println(array2[i]);
        }
    }
}
