package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код

        for (int out = array.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                for (int m = in + 1; m <= out; m++) {
                    if (isNumber(array[m])==true && isNumber(array[m]) == isNumber(array[in])) {
                        int n1 = Integer.parseInt(array[in]);
                        int n2 = Integer.parseInt(array[m]);
                        if (n1 < n2) {
                            String dummy = array[m];
                            array[m] = array[in];
                            array[in] = dummy;
                        }
                    }
                    if (isNumber(array[m])==false && isNumber(array[m]) == isNumber(array[in])) {
                        if (isGreaterThan(array[in], array[m])) {
                            String dummy = array[m];
                            array[m] = array[in];
                            array[in] = dummy;
                        }
                    }
                }
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
