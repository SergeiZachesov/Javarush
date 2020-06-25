package com.javarush.task.task04.task0408;

/* 
Хорошо или плохо?
*/

public class Solution {
    public static void main(String[] args) {
        compare(3);
        compare(6);
        compare(5);
    }

    public static void compare(int a) {
        //напишите тут ваш код
        String result="";
        if (a<5) {
            result = "Число меньше 5";
        }
        if (a>5) {
            result = "Число больше 5";
        }
        if (a == 5) {
            result = "Число равно 5";
        }
        System.out.println(result);
    }
}