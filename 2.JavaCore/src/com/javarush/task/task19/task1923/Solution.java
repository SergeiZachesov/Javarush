package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        Pattern pattern = Pattern.compile("\\d");
        String line;

        while ((line = fileReader.readLine()) != null) {
            for (String retval : line.split(" ")) {
                Matcher matcher = pattern.matcher(retval);
                if(matcher.find()){
                    fileWriter.write(retval + " ");
                }
            }
        }

        fileReader.close();
        fileWriter.close();

    }
}
