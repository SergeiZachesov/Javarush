package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=0;

        while (true) {
            String aText = reader.readLine();
            if (aText.equals("сумма")) {
                break;
            }
            int a = Integer.parseInt(aText);
            n = n + a;
        }
        System.out.print(n);
    }
}
