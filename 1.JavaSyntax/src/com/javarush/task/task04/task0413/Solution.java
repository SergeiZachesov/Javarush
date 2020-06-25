package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        int nNumber = Integer.parseInt(number);
        String day = "";
        if (nNumber<1 || nNumber>7) {
            day="такого дня недели не существует";
        }
        if (nNumber==1) {
            day="понедельник";
        }
        if (nNumber==2) {
            day="вторник";
        }
        if (nNumber==3) {
            day="среда";
        }
        if (nNumber==4) {
            day="четверг";
        }
        if (nNumber==5) {
            day="пятница";
        }
        if (nNumber==6) {
            day="суббота";
        }
        if (nNumber==7) {
            day="воскресенье";
        }
        System.out.println (day);
    }
}