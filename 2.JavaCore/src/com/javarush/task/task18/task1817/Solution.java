package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        Pattern pattern1 = Pattern.compile("[\\s]");
        Pattern pattern2 = Pattern.compile(".");

        InputStream inputStream = new FileInputStream(args[0]);
        BufferedReader readerLine = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        int whithspace = 0;
        int symbol = 0;
        while ((line = readerLine.readLine()) != null) {

            Matcher matcher1 = pattern1.matcher(line);
            while (matcher1.find()) {

                whithspace++;
            }
            Matcher matcher2 = pattern2.matcher(line);
            while (matcher2.find()) {
                symbol++;
            }
        }
        //System.out.println(whithspace+"!!!!!!!!!!!!!!"+symbol);
        System.out.println(String.format(Locale.ENGLISH, "%(.2f",(Double.valueOf(whithspace)/Double.valueOf(symbol))*100));
        inputStream.close();

    }
}
