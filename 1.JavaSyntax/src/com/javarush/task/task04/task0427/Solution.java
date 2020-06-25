package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String aText = reader.readLine();
        int a = Integer.parseInt(aText);

        if (a>=1 && a<10 && a%2==0) {
            System.out.print ("четное однозначное число");
        } else if (a>=1 && a<10 && a%2!=0) {
            System.out.print ("нечетное однозначное число");
        } else if (a>=10 && a<100 && a%2==0) {
            System.out.print("четное двузначное число");
        } else if (a>=10 && a<100 && a%2!=0) {
            System.out.print("нечетное двузначное число");
        } else if (a>=100 && a<1000 && a%2==0) {
            System.out.print("четное трехзначное число");
        } else if (a>=100 && a<1000 && a%2!=0) {
            System.out.print("нечетное трехзначное число");
        }
    }
}
