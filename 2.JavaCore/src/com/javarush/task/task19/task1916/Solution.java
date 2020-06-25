package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {

        //C:\Users\Сергей\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1916\Файл1.txt
        //C:\Users\Сергей\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1916\Файл2.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileReader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(reader.readLine()));

        List<String> lines1 = new ArrayList<String>();
        List<String> lines2 = new ArrayList<String>();

        String line = "";

        while ((line = fileReader1.readLine()) != null) {
            lines1.add(line);
        }
        while ((line = fileReader2.readLine()) != null) {
            lines2.add(line);
        }

        fileReader1.close();
        fileReader2.close();
        reader.close();

        lines1.add(" ");
        lines2.add(" ");

        int i = 0;
        int j = 0;
        while (!(lines1.get(i) == " " && lines2.get(j) == " ")) {
            if (lines1.get(i).equals(lines2.get(j))) {
                lines.add(new LineItem(Type.SAME, lines1.get(i)));
            } else {
                if (!lines1.get(i).equals(" ")) {
                    if (lines1.get(i + 1).equals(lines2.get(j))) {
                        lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
                        lines2.add(j, " ");
                    }
                }
                if (!lines2.get(j).equals(" ")) {
                    if (lines1.get(i).equals(lines2.get(j + 1))) {
                        lines.add(new LineItem(Type.ADDED, lines2.get(j)));
                        lines1.add(i, " ");
                    }
                }
            }
            j++;
            i++;
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
