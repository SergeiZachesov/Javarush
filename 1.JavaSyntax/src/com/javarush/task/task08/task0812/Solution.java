package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++)
            list.add(Integer.parseInt(reader.readLine()));


        int result = 1;
        int sum = 1;
        for (int j = 0; j < list.size() - 1; j++) {
            if (list.get(j).equals(list.get(j + 1))) {
                sum++;
                if (result < sum) {
                    result = sum;
                }
            } else {
                sum = 1;
                }

        }
            System.out.println(result);
    }
}