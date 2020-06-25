package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        //C:\Users\Сергей\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1922\Файл.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerLine = new BufferedReader(new FileReader(reader.readLine()));

        Pattern pattern = Pattern.compile("\\S+");
        String line;


        while ((line = readerLine.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            int i=0;
            while (matcher.find()) {
                for(String s : words) {
                    if (s.equals(matcher.group())){
                        i++;
                    }
                }
            }
            if(i==2) {
                System.out.println(line);
            }
        }

        reader.close();
        readerLine.close();

    }
}
