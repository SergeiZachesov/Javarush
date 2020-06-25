package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        InputStream inputStream = new FileInputStream(fileName);
        BufferedReader readerLine = new BufferedReader(new InputStreamReader(inputStream));

        ArrayList<Integer> list = new ArrayList<Integer>();

            String line;
            while ((line = readerLine.readLine()) != null) {
                    list.add(Integer.parseInt(line));
            }


       ArrayList<Integer> list1 = new ArrayList<Integer>();
        for(int n=0; n<list.size(); n++){

            if (list.get(n)%2==0) {
                list1.add(list.get(n));
            }
        }
        Collections.sort(list1);

        for (int num : list1)
        {
            System.out.println(num);
        }

        inputStream.close();

    }
}
