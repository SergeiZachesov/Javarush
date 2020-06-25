package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1824\Файл1.txt
        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1824\Файл.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean start = true;
        FileInputStream inputStream = null;
        String fileName = null;

        while (start) {
            try {
                fileName = reader.readLine();
                inputStream = new FileInputStream(fileName);
                inputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                start = false;
            }
        }
    }
}
