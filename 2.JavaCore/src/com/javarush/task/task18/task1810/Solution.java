package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1810\Файл1.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName1 = reader.readLine();
            FileInputStream inputStream = new FileInputStream(fileName1);

            if (inputStream.available() < 1000) {
                inputStream.close();
                throw new DownloadException();
            }
        }

    }

    public static class DownloadException extends Exception {

    }
}
