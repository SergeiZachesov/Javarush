package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
/*
C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1808\Файл.txt
C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1808\Файл1.txt
C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1808\Файл2.txt
*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(fileName1);
        FileOutputStream outputStream2 = new FileOutputStream(fileName2);
        FileOutputStream outputStream3 = new FileOutputStream(fileName3);

        if (inputStream1.available() > 0) {
            byte[] buffer = new byte[inputStream1.available()];
            int count = inputStream1.read(buffer);
            if (count % 2 == 0) {
                outputStream2.write(buffer, 0, count/2);
                outputStream3.write(buffer, count/2, count/2);
            } else {
                outputStream2.write(buffer, 0,count/2+1);
                outputStream3.write(buffer, count/2+1, count/2);
            }
        }

        reader.close();
        inputStream1.close();
        outputStream2.close();
        outputStream3.close();
    }
}
