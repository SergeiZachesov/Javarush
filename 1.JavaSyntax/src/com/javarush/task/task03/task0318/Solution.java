package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String age = reader.readLine();
        String name = reader.readLine();
        System.out.print (name + " захватит мир через " + age +" лет. Му-ха-ха!");
    }
}
