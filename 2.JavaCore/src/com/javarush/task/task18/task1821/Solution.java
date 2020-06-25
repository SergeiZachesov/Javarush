package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        InputStream inputStream = new FileInputStream(args[0]);
        BufferedReader readerLine = new BufferedReader(new InputStreamReader(inputStream));

        Map<Character, Integer> repetitionMap = new HashMap<>();

        int ch;
        while ((ch = readerLine.read()) != -1) {
                if (repetitionMap.containsKey((char)ch)) {
                   repetitionMap.put((char)ch, repetitionMap.get((char)ch) + 1);
                } else {
                   repetitionMap.put((char)ch, 1);
              }
        }

        SortedMap<Character, Integer> sortedMap2 = new TreeMap<>(repetitionMap);

        for (Map.Entry<Character, Integer> entry : sortedMap2.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        inputStream.close();
        readerLine.close();

    }
}
