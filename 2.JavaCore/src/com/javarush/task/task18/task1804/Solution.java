package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {


        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1803\Файл.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);
        Map<Integer, Integer> repetitionMap = new HashMap<>();

        while (inputStream.available() > 0) {
            int bite = inputStream.read();
            if (repetitionMap.containsKey(bite)) {
                repetitionMap.put(bite, repetitionMap.get(bite) + 1);
            } else {
                repetitionMap.put(bite, 1);
            }
        }

        reader.close();
        inputStream.close();

        if (repetitionMap.size() <= 0) {
            return;
        } else {
            int min = Collections.min(repetitionMap.values());
            for (Map.Entry<Integer, Integer> pair : repetitionMap.entrySet()) {
                if (pair.getValue().equals(min))
                    System.out.print(pair.getKey() + " ");
            }
        }

    }
}
