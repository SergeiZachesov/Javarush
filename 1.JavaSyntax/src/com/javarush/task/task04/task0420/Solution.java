package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
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
        int x=0,y=0,z=0;

        if (a>=b && a>=c) {
            x = a;
            if (b>=c) {
               y=b;
               z=c;
            } else {
                y=c;
                z=b;
            }
        } else if (b>=a && b>=c) {
            x = b;
            if (a>=c) {
                y=a;
                z=c;
            } else {
                y=c;
                z=a;
            }
        } else if (c>=a && c>=b) {
            x = c;
            if (a >= b) {
                y = a;
                z = b;
            } else {
                y = b;
                z = a;
            }
        }
        System.out.print (x +" "+y+" "+z);
    }
}
