package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
        // Создай 10 котов
        for (int n=1; n<=10; n++) {
            Cat cat = new Cat();
        }
        // Выведи значение переменной catCount
        System.out.println (Cat.catCount);
    }

    public static class Cat {
        // Создай статическую переменную catCount
        public static int catCount;
        public Cat() {
            Cat.catCount++;
        }
        // Создай конструктор
    }
}
