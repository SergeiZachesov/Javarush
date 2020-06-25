package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        String result = "";
        for (int n=1; n<=5; n++) {
            result = result + s;
        }
        //напишите тут ваш код
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        //напишите тут ваш код
        for (int n=1; n<=count; n++) {
            result = result + s;
        }
        return result;
    }

    public static void main(String[] args) {
    System.out.print (multiply("4", 6));
    }
}
