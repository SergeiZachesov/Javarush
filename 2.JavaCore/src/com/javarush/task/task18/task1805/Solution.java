package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1803\Файл.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);
        HashSet<Integer> list = new HashSet<>();

        while (inputStream.available() > 0) {
            int bite = inputStream.read();
            list.add(bite);
        }

        reader.close();
        inputStream.close();

        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        for (Integer i: sortedList) {
            System.out.print(i + " ");
        }

    }
}
