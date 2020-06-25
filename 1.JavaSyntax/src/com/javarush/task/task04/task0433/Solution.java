package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int n=1, m=1;

        while (n<=10) {
            while (m<=10) {
                System.out.print ("S");
                m++;
            }
            System.out.println ("");
            n++;
            m=1;
        }
    }
}
