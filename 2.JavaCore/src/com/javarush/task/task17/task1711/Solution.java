package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) { create(args); }
                break;
            case "-u":
                synchronized (allPeople) {update(args);}
                break;
            case "-d":
                synchronized (allPeople) {delete(args);}
                break;
            case "-i":
                synchronized (allPeople) {inform(args);}
                break;
        }
    }

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat datePrint = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void create(String[] args) throws ParseException {

        int argsIndex = (args.length - 1) / 3;

        int indexStart = allPeople.size();

        for (int i = 1; i <= argsIndex * 3; i += 3) {
            if (args[i + 1].equals("м")) {
                allPeople.add(Person.createMale(args[i], dateFormat.parse(args[i + 2])));
            } else {
                allPeople.add(Person.createFemale(args[i], dateFormat.parse(args[i + 2])));
            }
        }
        for (int i = indexStart + 1; i <= allPeople.size(); i++) {
            System.out.println(i - 1);
        }
    }

    public static void update(String[] args) throws ParseException {

        int argsIndex = (args.length - 1) / 4;

        for (int i = 1; i <= argsIndex * 4; i += 4) {
            if (args[i + 2].equals("м")) {
                allPeople.set(Integer.parseInt(args[i]), Person.createMale(args[i+1], dateFormat.parse(args[i + 3])));
            } else {
                allPeople.set(Integer.parseInt(args[i]), Person.createFemale(args[i+1], dateFormat.parse(args[i + 3])));
            }
        }
    }

    public static void delete(String[] args) {

        int argsIndex = args.length - 1;
        for (int i = 1; i <= argsIndex; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            person.setName(null);
            person.setBirthDate(null);
            person.setSex(null);
        }

    }

    public static void inform(String[] args) {

        int argsIndex = args.length - 1;

        for (int i = 1; i <= argsIndex; i++) {
            String name = allPeople.get(Integer.parseInt(args[i])).getName();

            String date = datePrint.format(allPeople.get(Integer.parseInt(args[i])).getBirthDate());

            String sex = null;

            if (allPeople.get(Integer.parseInt(args[i])).getSex() == Sex.MALE) {
                sex = "м";
            } else {
                sex = "ж";
            }

            System.out.println(name + " " + sex + " " + date);
        }
    }


}
