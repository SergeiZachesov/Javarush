package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        if (line.contains("?")) {

            int indexQ = line.indexOf("?") + 1;
            char[] lineM = line.toCharArray();

            if (line.contains("&")) {
                int counterSign = 0;
                ArrayList<Integer> indexSign = new ArrayList<Integer>();
                for (int i = 0; i < lineM.length; i++) {
                    if (lineM[i] == '&') {
                        indexSign.add(i);
                        counterSign++;
                    }
                }

                for (int i = 0; i <= counterSign; i++) {
                    for (int j = indexQ; j < lineM.length; j++) {
                        if (lineM[j] == '&' || lineM[j] == '=') {
                            if (i == counterSign) {
                                break;
                            }
                            indexQ = indexSign.get(i) + 1;
                            break;
                        }
                        System.out.print(lineM[j]);
                    }
                    System.out.print(" ");
                }
            } else {
                for (int j = indexQ; j < lineM.length; j++) {
                    if (lineM[j] == '&' || lineM[j] == '=') {
                        break;
                    }
                    System.out.print(lineM[j]);
                }
            }
        }

        if (line.contains("obj")) {
            System.out.println(" ");
            String paramObj = line.substring(line.indexOf("obj") + 4, line.indexOf("&", line.indexOf("obj")));
            try {
                alert(Double.parseDouble(paramObj));
            }catch (NumberFormatException e){
                alert(paramObj);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
