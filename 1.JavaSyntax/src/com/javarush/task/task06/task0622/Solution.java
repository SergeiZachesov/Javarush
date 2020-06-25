package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] number = new int[5];
        //напишите тут ваш код
        for (int i = 0; i < 5 ; i++) {
            number[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(number);
        for (int i = 0; i < 5 ; i++) {
            System.out.println(number[i]);
        }


    }
}
