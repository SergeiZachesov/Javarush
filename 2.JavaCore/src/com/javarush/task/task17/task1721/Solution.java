package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();

            InputStream inputStream1 = new FileInputStream(fileName1);
            BufferedReader readerLine1 = new BufferedReader(new InputStreamReader(inputStream1));

            InputStream inputStream2 = new FileInputStream(fileName2);
            BufferedReader readerLine2 = new BufferedReader(new InputStreamReader(inputStream2));


            String line;
            while ((line = readerLine1.readLine()) != null) {
                allLines.add(line);
            }

            while ((line = readerLine2.readLine()) != null) {
                forRemoveLines.add(line);
            }
            reader.close();

            new Solution().joinData();



        } catch (IOException e) {

        }


    }

    public void joinData() throws IOException {
        int indexCoin;
        int indexNoCoin = 0;


        for (String X : forRemoveLines) {
            indexCoin = 0;
            for (String Y : allLines) {
                if (X.equals(Y))
                    indexCoin++;
            }
            if (indexCoin == 0) indexNoCoin++;
        }

        if (indexNoCoin > 0) {
                allLines.clear();
            throw new CorruptedDataException();
        } else {
            for (String Y : forRemoveLines) {
                allLines.remove(Y);
            }

        }
    }
}
