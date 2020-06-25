package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        int maximum = Integer.parseInt(reader.readLine());
        int n=1;
        //напишите тут ваш код
        while (n<=m-1) {
            int a = Integer.parseInt(reader.readLine());

            maximum = a >= maximum ? a : maximum;
            n++;
        }


        System.out.println(maximum);
    }
}
