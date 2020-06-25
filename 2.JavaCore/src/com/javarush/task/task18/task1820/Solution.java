package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1820\Файл1.txt
        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1820\Файл2.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        BufferedReader readerLine = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileName2));

        ArrayList<Integer> list = new ArrayList<Integer>();
        String line;
        Integer i;

        Pattern pattern = Pattern.compile("(^|\\s)-*\\d+[.,]*\\d*");

        while ((line = readerLine.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                //System.out.println(Math.round(Double.valueOf(matcher.group(2))));
                outputStreamWriter.write(Math.round(Double.valueOf(matcher.group())) + " ");
            }
        }

        outputStreamWriter.close();
        readerLine.close();

    }
}
