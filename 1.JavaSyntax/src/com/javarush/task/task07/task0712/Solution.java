package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<String>();

        for (int i = 0; i < 10; i++)
        {
            strings.add(reader.readLine());
        }
        int  minInd=0;
        int min = strings.get(0).length();
        for (int i = 1; i < strings.size(); i++) {
            if (strings.get(i).length() < min) {
                min = strings.get(i).length();
                minInd = i;
            }
        }

        int maxInd = 0;
        int max = strings.get(0).length();
        for (int i = 1; i < strings.size(); i++) {
            if (strings.get(i).length() > max) {
                max = strings.get(i).length();
                maxInd = i;
            }
        }

        if (minInd>maxInd)
           System.out.println(strings.get(maxInd));
        else
            System.out.println(strings.get(minInd));

    }
}
