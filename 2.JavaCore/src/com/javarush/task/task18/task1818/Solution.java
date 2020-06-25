package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1818\Файл.txt
        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1818\Файл1.txt
        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1818\Файл2.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileOutputStream outputStream1 = new FileOutputStream(fileName1);
        FileInputStream inputStream2 = new FileInputStream(fileName2);
        FileInputStream inputStream3 = new FileInputStream(fileName3);

        if (inputStream2.available() > 0) {
            byte[] buffer = new byte[inputStream2.available()];
            int count = inputStream2.read(buffer);
            outputStream1.write(buffer, 0, count);
        }

        if (inputStream3.available() > 0) {
            byte[] buffer = new byte[inputStream3.available()];
            int count = inputStream3.read(buffer);
            outputStream1.write(buffer, 0, count);
        }

        outputStream1.close();
        inputStream2.close();
        inputStream3.close();

    }
}
