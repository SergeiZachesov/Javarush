package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1907\Файл.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());


        String line = "";
        while (fileReader.ready()) {

            line = line + (char) fileReader.read();
        }
        Pattern pattern = Pattern.compile("\\bworld\\b");
        Matcher matcher = pattern.matcher(line);
        int i = 0;
        while (matcher.find()) {
            i++;
        }
        System.out.println(i);
        reader.close();
        fileReader.close();
    }
}
