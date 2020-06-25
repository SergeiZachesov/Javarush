package com.javarush.task.task06.task0604;

/* 
Ставим котов на счётчик
*/

public class Cat {
    public static int catCount = 0;

    //напишите тут ваш код
    public Cat() {
        catCount++;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        catCount--;
        System.out.println("A Dog was destroyed");
    }

    public static void main(String[] args) {

    }
}