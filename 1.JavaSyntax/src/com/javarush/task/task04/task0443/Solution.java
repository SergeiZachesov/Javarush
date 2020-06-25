package com.javarush.task.task04.task0443;

/* 
Как назвали, так назвали
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameText = reader.readLine();
        String cText = reader.readLine();
        String bText = reader.readLine();
        String aText = reader.readLine();
        int c = Integer.parseInt(cText);
        int b = Integer.parseInt(bText);
        int a = Integer.parseInt(aText);

        System.out.println("Меня зовут " + nameText+".");
        System.out.println("Я родился " + a + "." + b + "." + c);

    }
}
