package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        //C:\Users\Сергей\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1825\Файл1.txt.part1
        //C:\Users\Сергей\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1825\Файл1.txt.part2
        //C:\Users\Сергей\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1825\Файл1.txt.part3

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<String> sortedSet = new TreeSet<>();

        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals("end")) break;
            sortedSet.add(fileName);
        }

        FileInputStream inputStream = null;
        File fileBoss = null;

        Pattern pattern = Pattern.compile("(.+)\\.part[\\d]");
        Matcher matcher = pattern.matcher(sortedSet.first());
        while (matcher.find()) {
            // System.out.println(matcher.group(1));
            fileBoss = new File(matcher.group(1));
        }

        FileOutputStream outputStream = new FileOutputStream(fileBoss);

        for (String entry : sortedSet) {
            inputStream = new FileInputStream(entry);
            if (inputStream.available() > 0) {
                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
            inputStream.close();
        }

        reader.close();
        outputStream.close();
    }
}
