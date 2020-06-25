package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        //напишите тут ваш код
        String monthNamber="0";
    if ((month>0 && month<3) || month==12) {
        monthNamber="зима";
    }
    if (month>2 && month<6) {
        monthNamber="весна";
        }
    if (month>5 && month<9) {
        monthNamber = "лето";
    }
    if (month>8 && month<12) {
        monthNamber="осень";
        }
    System.out.println(monthNamber);
    }
}