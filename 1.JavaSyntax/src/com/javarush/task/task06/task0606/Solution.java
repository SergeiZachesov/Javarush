package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;


    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());



        for (int m=a; m%10!=0; m/=10) {
            if (m%2==0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.print("Even: "+even+" Odd: "+odd);
    }
}
