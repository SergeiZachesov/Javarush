package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {

//-e C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1826\Файл.txt C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1826\Файл1.txt
//-d C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1826\Файл1.txt C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1826\Файл2.txt

//-e C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1826\Файл.txt C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1826\Файл1.txt
//-d C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1826\Файл1.txt C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1826\Файл2.txt

        InputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);

        byte[] buffer = new byte[inputStream.available()];
        int count = inputStream.read(buffer);

        byte key = 5;


        switch (args[0]) {
            case "-e":
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] += key;
                }
                break;
            case "-d":
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] -= key;
                }
                break;
        }

        outputStream.write(buffer, 0, count);

        inputStream.close();
        outputStream.close();

    }

}
