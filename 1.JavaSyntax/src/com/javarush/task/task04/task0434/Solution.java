package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int n=1, m=1, result=1;

        while (n<=10) {
            while (m<=10) {
                result=n*m;
                System.out.print (result + " ");
                m++;
            }
            System.out.println ("");
            n++;
            m=1;
        }
    }
}
