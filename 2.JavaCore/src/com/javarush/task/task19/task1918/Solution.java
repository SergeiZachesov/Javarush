package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/




import java.io.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.parser.Parser;


public class Solution {
    public static void main(String[] args) throws IOException {

        //C:\Users\Сергей\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1918\Файл.html

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = file.readLine()) != null){
            stringBuilder.append(line);
        }
        file.close();
        reader.close();

        Document htmlFile =Jsoup.parse(stringBuilder.toString(), "", Parser.xmlParser());
        Elements div = htmlFile.select(args[0]);
        for (Element elements : div){
            System.out.println(elements);
        }



    }
}
