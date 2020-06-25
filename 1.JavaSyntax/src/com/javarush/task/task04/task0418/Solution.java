package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String aText = reader.readLine();
        String bText = reader.readLine();
        int a = Integer.parseInt(aText);
        int b = Integer.parseInt(bText);

        if (a>b) {
            System.out.print (b);
        } else if (a<b) {
            System.out.print (a);
        } else if (b==a) {
            System.out.print (b);
        }
    }
}