package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int result=0;
        for (int i = 1; i <=10; i ++){
            for (int j = 1; j <=10; j ++) {
                result = j * i;
                System.out.print(result+" ");
            }
            System.out.println(" ");
        }
    }
}
