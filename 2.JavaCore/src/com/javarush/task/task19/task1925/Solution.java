package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        Pattern pattern = Pattern.compile("\\S{7,}");
        String line;
        ArrayList<String> list = new ArrayList<String>();

        while ((line = fileReader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                list.add(matcher.group());
            }
        }

        for (int i = 0; i < list.size(); i++) {
            fileWriter.write(list.get(i));
            if (i != list.size() - 1) fileWriter.write(",");
        }

        fileReader.close();
        fileWriter.close();

    }
}
