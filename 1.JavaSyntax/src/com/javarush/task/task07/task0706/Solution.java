package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[15];

        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        int even = 0;
        int add = 0;

        for (int i = 0; i < array.length; i=i+2)
        {
            even=even+array[i];
        }
        for (int i = 1; i < array.length; i=i+2)
        {
            add=add+array[i];
        }

        if (even>add)
            System.out.print("В домах с четными номерами проживает больше жителей.");
        else
            System.out.print("В домах с нечетными номерами проживает больше жителей.");

    }
}
