package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private String surname;
        private char sex;
        private int money;
        private int weight;
        private double size;


        public Human(String name, String surname, int money, char sex, int weight, double size) {
            this.name = name;
            this.surname = surname;
            this.money = money;
            this.sex = sex;
            this.weight = weight;
            this.size = size;
        }
        public Human(String name, String surname, int money, char sex, int weight) {
            this.name = name;
            this.surname = surname;
            this.money = money;
            this.sex = sex;
            this.weight = weight;
            this.size = size;
        }
        public Human(String name, String surname, int money, char sex) {
            this.name = name;
            this.surname = surname;
            this.money = money;
            this.sex = sex;
            this.weight = weight;
            this.size = size;
        }
        public Human(String name, String surname, int money) {
            this.name = name;
            this.surname = surname;
            this.money = money;
            this.sex = sex;
            this.weight = weight;
            this.size = size;
        }
        public Human(String name, String surname) {
            this.name = name;
            this.surname = surname;
            this.money = money;
            this.sex = sex;
            this.weight = weight;
            this.size = size;
        }
        public Human(String name) {
            this.name = name;
            this.surname = surname;
            this.money = money;
            this.sex = sex;
            this.weight = weight;
            this.size = size;
        }
        public Human(String surname, int money, char sex, int weight, double size) {
            this.name = name;
            this.surname = surname;
            this.money = money;
            this.sex = sex;
            this.weight = weight;
            this.size = size;
        }
        public Human(int money, char sex, int weight, double size) {
            this.name = name;
            this.surname = surname;
            this.money = money;
            this.sex = sex;
            this.weight = weight;
            this.size = size;
        }
        public Human(char sex, int weight, double size) {
            this.name = name;
            this.surname = surname;
            this.money = money;
            this.sex = sex;
            this.weight = weight;
            this.size = size;
        }
        public Human(int weight, double size) {
            this.name = name;
            this.surname = surname;
            this.money = money;
            this.sex = sex;
            this.weight = weight;
            this.size = size;
        }
    }
}
