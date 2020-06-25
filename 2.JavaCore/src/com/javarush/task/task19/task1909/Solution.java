package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1909\Файл.txt
        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1909\Файл1.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));

        ArrayList<String> list = new ArrayList<String>();
        String line = "";
        Pattern pattern = Pattern.compile("\\.");

        while ((line = fileReader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            String newline = matcher.replaceAll("!");
            fileWriter.write(newline);
            fileWriter.append('\n');
        }


        fileReader.close();
        fileWriter.close();
        reader.close();

    }
}
