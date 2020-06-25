package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        //напишите тут ваш код
        char[] ch = string.toCharArray();
        char t = ch[0];
        ch[0] = Character.toUpperCase(t);
        Character.toUpperCase(ch[1]);
        //String str = "";
        for (int i = 0; i<ch.length; i++ ) {
            if (ch[i] == ' ') {
                char l = ch[i + 1];
                ch[i + 1] = Character.toUpperCase(l);
            }
                //str += ch[i];
        }
        System.out.println(ch);
    }
}
