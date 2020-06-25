package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {

        //C:\Users\Сергей\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1924\Файл.txt


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));

        String line;

        while ((line = fileReader.readLine()) != null) {
            String lineArr[] = line.split(" ");
            for (int i = 0; i < lineArr.length; i++) {
                try {
                    //System.out.println("!!!!!!!!!!!!!" + lineArr[i]);
                    if (map.containsKey(Integer.parseInt(lineArr[i]))) {
                        lineArr[i] = map.get(Integer.parseInt(lineArr[i]));
                    }
                } catch (NumberFormatException e) {
                }
            }

            for (String i : lineArr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        fileReader.close();
        reader.close();
    }
}
