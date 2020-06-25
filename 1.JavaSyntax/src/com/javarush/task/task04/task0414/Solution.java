package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String year = reader.readLine();
        int nYear = Integer.parseInt(year);
        int yearLeap=0;
        if (nYear%400==0) {
            yearLeap=366;

        } else if (nYear%100==0) {
            yearLeap=365;
        } else if (nYear%4==0) {
            yearLeap=366;
        } else {
            yearLeap=365;
        }
        System.out.print("количество дней в году: " + yearLeap);
    }
}