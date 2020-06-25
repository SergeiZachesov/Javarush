package com.javarush.task.task04.task0424;

/* 
Три числа
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
        int c = Integer.parseInt(cText);;

        if (a==b) {
            System.out.print("3");
        } else if (a==c) {
            System.out.print("2");
        } else if (b==c) {
            System.out.print("1");
        }
    }
}
