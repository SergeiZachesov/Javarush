package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        Pattern pattern = Pattern.compile("[A-Za-z]");

        InputStream inputStream = new FileInputStream(args[0]);
        BufferedReader readerLine = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        int i = 0;
        while ((line = readerLine.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                i++;
            }
        }

        System.out.println(i);

        inputStream.close();

    }
}
