package com.javarush.task.task04.task0437;

/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int i=1;
        for (int m=1; m<=10; m++) {
            for (int n = 1; n <= i; n++) {
                System.out.print(8);

            }
            i++;
            System.out.println("");
        }
    }
}
