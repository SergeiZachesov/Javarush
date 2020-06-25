package com.javarush.task.task18.task1827;

/* 
Прайсы
*/


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        //-c "Шорты пляжные синие, шорты пляжные черные с рисунком" 123456789 123456789
        //C:\Users\Сергей\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1828\Файл.txt
        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1828\Файл.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        List<String> strings = Files.readAllLines(Paths.get(name));

        if (args.length > 0) {
            switch (args[0]) {
                case "-c":
                    int idMax = strings
                            .stream()
                            .map(s -> s.substring(0, 8).trim())
                            .mapToInt(Integer::parseInt)
                            .max()
                            .getAsInt();
                    strings.add(String.format("%-8s%-30s%-8s%-4s", ++idMax, args[1], args[2], args[3]));
            }
        }
        Files.write(Paths.get(name), strings);
    }


}
