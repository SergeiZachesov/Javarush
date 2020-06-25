package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        try{

            FileInputStream inStream = new FileInputStream(fileName);

            while (inStream.available() > 0){
                System.out.print((char)inStream.read());
            }
            inStream.close();

        }catch(FileNotFoundException e){
            System.out.println("Такой файл не найден!");
        }

    }
}