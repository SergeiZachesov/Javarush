package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1

        String line;
        while(true) {
            line = reader.readLine();
            if(line.equals("user")) {
                person = new Person.User();
                doWork(person);
            }
            else if(line.equals("loser")) {
                person = new Person.Loser();
                doWork(person);
            }
            else if(line.equals("coder")) {
                person = new Person.Coder();
                doWork(person);
            }
            else if(line.equals("proger")) {
                person = new Person.Proger();
                doWork(person);
            }
            else {break;}

        }

        {
            //создаем объект, пункт 2

        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if(person instanceof Person.User) {((Person.User) person).live();}
        else if(person instanceof Person.Loser) {((Person.Loser) person).doNothing();}
        else if(person instanceof Person.Coder) {((Person.Coder) person).writeCode();}
        else if(person instanceof Person.Proger) {((Person.Proger) person).enjoy();}
    }
}
