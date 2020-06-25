package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader readerLine = new BufferedReader(new FileReader(args[0]));

        Map<String, Double> repetitionMap = new HashMap<>();
        Pattern pattern = Pattern.compile("^(.+) (-?[0-9.]+)$");
        String line;

        while ((line = readerLine.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                if (repetitionMap.containsKey(matcher.group(1))) {
                    repetitionMap.put(matcher.group(1), repetitionMap.get(matcher.group(1)) + Double.parseDouble(matcher.group(2)));
                } else {
                    repetitionMap.put(matcher.group(1), Double.parseDouble(matcher.group(2)));
                }
            }
        }

        Map<String, Double> treeMap = new TreeMap<>(repetitionMap);

        for (Map.Entry<String, Double> pair : treeMap.entrySet()) {
                System.out.println(pair.getKey() + " " + pair.getValue());
        }

        readerLine.close();

    }
}
