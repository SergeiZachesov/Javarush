package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandfather1 = new Human("Сергей", true, 70);
        System.out.println(grandfather1);

        Human grandfather2 = new Human("Сергей", true, 70);
        System.out.println(grandfather2);

        Human grandmother1 = new Human("Сергей", true, 70);
        System.out.println(grandmother1);

        Human grandmother2 = new Human("Сергей", true, 70);
        System.out.println(grandmother2);

        Human father = new Human("Сергей", true, 70, grandfather1, grandmother1);
        System.out.println(father);

        Human mother = new Human("Сергей", true, 70, grandfather2, grandmother2);
        System.out.println(mother);

        Human sun = new Human("Сергей", true, 70, father, mother);
        System.out.println(sun);

        Human sun2 = new Human("Сергей", true, 70, father, mother);
        System.out.println(sun);

        Human daughter = new Human("Сергей", true, 70, father, mother);
        System.out.println(daughter);
    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human mother, father;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.mother=mother;
            this.father=father;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}