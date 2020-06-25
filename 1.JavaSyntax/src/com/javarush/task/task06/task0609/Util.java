package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        int l1 = x1-x2;
        int l2 = y1-y2;
        return Math.sqrt(l1*l1+l2*l2);


    }

    public static void main(String[] args) {
        System.out.println(getDistance(1,1,1,1));
    }
}
