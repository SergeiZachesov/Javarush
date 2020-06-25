package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double sum=0;
        int num=0;
        while (true) {
            String numberText = reader.readLine();
            int number = Integer.parseInt(numberText);
            if (number==-1)
                break;
            sum += number;
            num++;

        }
        System.out.print(sum/num);
    }
}

