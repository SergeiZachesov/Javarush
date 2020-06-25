package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer n1 = Integer.parseInt(bufferedReader.readLine());
        Integer n2 = Integer.parseInt(bufferedReader.readLine());

        if (n1 <= 0 || n2 <= 0) {
            throw new Exception();
        }

        if (n1>n2)
            System.out.println(gcd(n1, n2));
        else
            System.out.println(gcd(n2, n1));




    }
        public static int gcd(int a,int b) {
            while (b!=0) {
                int tmp = a%b;
                a = b;
                b = tmp;
            }
            return a;
        }

}
