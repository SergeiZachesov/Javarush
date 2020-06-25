package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (true) {
            line = reader.readLine();
            if (line.equals("exit")) {
                break;
            }

            try {
                if (line.contains(".")) {
                    Double lineDub = Double.parseDouble(line);
                    print(lineDub);
                } else {
                    Integer lineInt = Integer.parseInt(line);
                    if (lineInt>0 && lineInt<128) {
                        Short lineShor = Short.parseShort(line);
                        print(lineShor);
                    } else {
                        print(lineInt);
                    }
                }

            } catch (NumberFormatException e) {
                print(line);
            }



        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
