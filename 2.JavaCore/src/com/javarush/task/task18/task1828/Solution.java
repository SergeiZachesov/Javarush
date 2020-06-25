package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {


        //-u 19847983 "Шорты пляжные синие, шорты пляжные черные с рисунком" 123456789 123456789
        //-d 198478
        //C:\Users\Сергей\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1828\Файл.txt
        //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1828\Файл.txt

        if (args.length > 0) {
            switch (args[0]) {
                case "-u":
                    update(args);
                    break;
                case "-d":
                    delete(args);
                    break;
            }
        }
    }

    public static void update(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        String idStr = args[1];
        if (idStr.length() < 8) {
            while (idStr.length() < 8) {
                idStr += " ";
            }
        } else {
            idStr.substring(0, 8);
        }

        String productName = args[2];
        if (productName.length() < 30) {
            while (productName.length() < 30) {
                productName += " ";
            }
        } else {
            productName = productName.substring(0, 30);
        }

        String price = args[3];
        if (price.length() < 8) {
            while (price.length() < 8) {
                price += " ";
            }
        } else {
            price = price.substring(0, 8);
        }

        String quantity = args[4];
        if (quantity.length() < 4) {
            while (quantity.length() < 4) {
                quantity += " ";
            }
        } else {
            quantity = quantity.substring(0, 4);
        }

        String product = idStr + productName + price + quantity;


        InputStream inputStream = new FileInputStream(fileName);
        BufferedReader readerLine = new BufferedReader(new InputStreamReader(inputStream));

        Pattern pattern = Pattern.compile("^" + args[1]);

        String line;
        ArrayList<String> list = new ArrayList<String>();

        while ((line = readerLine.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            //while (matcher.find()) {

            //}
            if (matcher.find()) {
                list.add(product);
            } else {
                list.add(line);
            }

        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (String t : list) {
            writer.write(t);
            writer.append('\n');
        }

        writer.close();
        readerLine.close();
        inputStream.close();
        reader.close();
    }

    public static void delete(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        InputStream inputStream = new FileInputStream(fileName);
        BufferedReader readerLine = new BufferedReader(new InputStreamReader(inputStream));

        Pattern pattern = Pattern.compile("^" + args[1]);

        String line;
        ArrayList<String> list = new ArrayList<String>();

        while ((line = readerLine.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            //while (matcher.find()) {

            //}
            if (matcher.find()) {
                list.remove(line);
            } else {
                list.add(line);
            }

        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (String t : list) {
            writer.write(t);
            writer.append('\n');
        }

        writer.close();
        readerLine.close();
        inputStream.close();
        reader.close();
    }

}
