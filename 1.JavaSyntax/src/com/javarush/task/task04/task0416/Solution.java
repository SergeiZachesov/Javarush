package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String clockText = reader.readLine();
        double clock = Double.parseDouble(clockText);
        String color = "";
        while (clock >= 60) {
            clock = clock - 60;
        }
        for (int i = 0; i < 60; i += 5) {
            if (clock-i >= 0 && clock-i < 3) {
                color = "зеленый";
            }
            if (clock-i >= 3 && clock-i < 4) {
                color = "желтый";
            }
            if (clock-i >= 4 && clock-i < 5) {
                color = "красный";
            }
        }
        System.out.println(color);
    }
}