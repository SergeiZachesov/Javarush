package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human sun = new Human("Сергей", true, 25);
        Human sun2 = new Human("Сергей2", true, 25);
        Human sun3 = new Human("Сергей3", true, 25);
        ArrayList<Human> children = new ArrayList<Human>();
        children.add(sun);
        children.add(sun2);
        children.add(sun3);

        Human father = new Human("Сергей", true, 25, children);
        Human mother = new Human("Сергей", false, 25, children);
        ArrayList<Human> children1 = new ArrayList<Human>();
        children1.add(father);
        ArrayList<Human> children2 = new ArrayList<Human>();
        children2.add(mother);

        Human grandfather1 = new Human("Сергей", true, 25, children1);
        Human grandmother1 = new Human("Сергей", false, 25, children1);
        Human grandfather2 = new Human("Сергей", true, 25, children2);
        Human grandmother2 = new Human("Сергей", false, 25, children2);

        System.out.println(sun);
        System.out.println(sun2);
        System.out.println(sun3);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(grandfather1);
        System.out.println(grandmother1);
        System.out.println(grandfather2);
        System.out.println(grandmother2);

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children=children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
