package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1802\Файл.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);

        int min = 0;
        for (int i = 0; inputStream.available() > 0; i++) {
            int data = inputStream.read();
            if (i == 0) min = data;
            if (data < min) min = data;
        }
        System.out.println(min);
        inputStream.close();
    }
}

