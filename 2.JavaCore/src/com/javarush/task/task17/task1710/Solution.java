package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут

        switch (args[0]) {
            case "-c":
                create(args);
                break;
            case "-u":
                update(args);
                break;
            case "-d":
                delete(args);
                break;
            case "-i":
                inform(args);
                break;
        }
    }

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat datePrint = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void create(String[] args) throws ParseException {

        if (args[2].equals("м")) {
            allPeople.add(Person.createMale(args[1], dateFormat.parse(args[3])));
        } else {
            allPeople.add(Person.createFemale(args[1], dateFormat.parse(args[3])));
        }
        System.out.println(allPeople.size()-1);
    }

    public static void update(String[] args) throws ParseException {
        if (args[2].equals("м")) {
            allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], dateFormat.parse(args[4])));
        } else {
            allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], dateFormat.parse(args[4])));
        }
    }

    public static void delete(String[] args) {
        Person person = allPeople.get(Integer.parseInt(args[1]));
        person.setName(null);
        person.setBirthDate(null);
        person.setSex(null);
    }

    public static void inform(String[] args) {
        String name = allPeople.get(Integer.parseInt(args[1])).getName();

        String date = datePrint.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate());

        String sex = null;

        if (allPeople.get(Integer.parseInt(args[1])).getSex() == Sex.MALE) {
            sex = "м";
        } else {
            sex = "ж";
        }

        System.out.println(name + " " + sex + " " + date);
    }


}
