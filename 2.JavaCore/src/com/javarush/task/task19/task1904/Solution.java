package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task19\task1904\Файл.txt

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;


        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws  ParseException {

            String s = fileScanner.nextLine();
            String[] strings = s.split(" ",4);
            Date date = new SimpleDateFormat("d M y", Locale.ENGLISH).parse(strings[3]);

            return new Person(strings[1],strings[2],strings[0],date);
        }

        @Override
        public void close() {
            fileScanner.close();
        }
    }
}