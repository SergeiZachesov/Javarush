package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        //Arrays.sort(array);


        for (int out = array.length - 1; out >= 1; out--) {  //Внешний цикл
            for (int in = 0; in < out; in++) {       //Внутренний цикл
                if (array[in] < array[in + 1]) {           //Если порядок элементов нарушен
                    int a = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = a;
                }
            }
        }
    }
}

