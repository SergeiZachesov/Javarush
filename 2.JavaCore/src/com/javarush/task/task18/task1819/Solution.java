package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1819\Файл1.txt
        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1819\Файл2.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(fileName1);
        FileInputStream inputStream2 = new FileInputStream(fileName2);
        FileOutputStream outputStream1;

        if (inputStream1.available() > 0 && inputStream2.available() > 0) {
            byte[] buffer1 = new byte[inputStream1.available()];
            byte[] buffer2 = new byte[inputStream2.available()];

            int count1 = inputStream1.read(buffer1);
            int count2 = inputStream2.read(buffer2);

            outputStream1 = new FileOutputStream(fileName1);

            outputStream1.write(buffer2, 0, count2);
            outputStream1.write(buffer1, 0, count1);

            outputStream1.close();
            inputStream1.close();
            inputStream2.close();
        }



    }
}
