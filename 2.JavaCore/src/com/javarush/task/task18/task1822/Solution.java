package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        //C:\Users\Сергей\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1822\Файл.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerLine = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine()),"UTF-8"));

        Pattern pattern = Pattern.compile("^\\d+");

        String line;

        while ((line = readerLine.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                if (matcher.group().equals(args[0])) {
                    System.out.println(line);
                }
            }
        }

        readerLine.close();

    }
}
