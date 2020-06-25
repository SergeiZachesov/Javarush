package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String aText = reader.readLine();
        String bText = reader.readLine();
        String cText = reader.readLine();
        int a = Integer.parseInt(aText);
        int b = Integer.parseInt(bText);
        int c = Integer.parseInt(cText);
        ;
        int n = 0;
        int m = 0;

        if (a > 0 && a != 0) {
            n++;
        } else if (a < 0 && a != 0) {
            m++;
        }
        if (b > 0 && b != 0) {
            n++;
        } else if (b < 0 && b != 0) {
            m++;
        }
        if (c > 0 && c != 0) {
            n++;
        } else if (c < 0 && c != 0) {
            m++;
        }

        System.out.println("количество отрицательных чисел: " + m);
        System.out.println("количество положительных чисел: " + n);
    }
}
