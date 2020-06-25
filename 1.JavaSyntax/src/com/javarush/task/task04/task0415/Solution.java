package com.javarush.task.task04.task0415;

/* 
Правило треугольника
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

        String triangle = "";

        if ((a+b)>c & (a+c)>b & (c+b)>a) {
            triangle = "Треугольник существует.";
        } else {
            triangle = "Треугольник не существует.";
        }
        System.out.print(triangle);



    }
}