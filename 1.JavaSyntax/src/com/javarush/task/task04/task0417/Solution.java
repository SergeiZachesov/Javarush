package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
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

        if (a==b && a==c && b==c) {
            System.out.print (a+" "+b+" "+c);
        } else if (a==b || a==c ) {
            System.out.print (a+" "+a);
        } else if (b==a || b==c ) {
            System.out.print (b+" "+b);
        } else if (c==a || c==b ) {
            System.out.print (c+" "+c);
        }
    }
}