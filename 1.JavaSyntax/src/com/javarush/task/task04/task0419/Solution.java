package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
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
        String dText = reader.readLine();
        int a = Integer.parseInt(aText);
        int b = Integer.parseInt(bText);
        int c = Integer.parseInt(cText);
        int d = Integer.parseInt(dText);

        if (a>=b && a>=c && a>=d) {
            System.out.print (a);
        } else if (b>=a && b>=c && b>=d) {
            System.out.print (b);
        } else if (c>=a && c>=b && c>=d) {
            System.out.print (c);
        } else if (d>=a && d>=b && d>=c) {
            System.out.print (d);
        }
    }
}
