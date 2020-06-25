package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader readerLine = new BufferedReader(new FileReader(args[0]));

        SimpleDateFormat dateFormat = new SimpleDateFormat("d M yyyy", Locale.ENGLISH);

        Pattern pattern = Pattern.compile("(.+)\\s(([\\d]+)\\s([\\d]+)\\s([\\d]+))$");
        String line;

        while ((line = readerLine.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                PEOPLE.add(new Person(matcher.group(1), dateFormat.parse(matcher.group(2))));
            }
        }

        readerLine.close();

        //for(Person s : PEOPLE) {
        //    System.out.println(s.getName() + " " + s.getBirthDate());
       // }

    }
}
