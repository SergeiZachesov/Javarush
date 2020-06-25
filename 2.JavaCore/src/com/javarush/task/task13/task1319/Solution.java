package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

        String line;
        while(true) {
            line = reader.readLine();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            if(line.equals("exit")) {break;}
        }
        bufferedWriter.close();
    }
}
