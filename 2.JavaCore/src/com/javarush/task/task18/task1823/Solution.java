package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1823\Файл1.txt
    //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1823\Файл2.txt
    //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1823\Файл3.txt
    //C:\Users\mdv106u\YandexDisk\Программирование\Java\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1823\Файл4.txt

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String fileName = reader.readLine();
            if (fileName.equals("exit")) break;

            new ReadThread(fileName).start();

        }
    }

    public static class ReadThread extends Thread {

        String fileName;
        FileInputStream inputStream;
        Map<Integer, Integer> repetitionMap = new HashMap<>();

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {

            try {
                this.inputStream = new FileInputStream(this.fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            try {
                while (inputStream.available() > 0) {
                    int bite = inputStream.read();
                    if (repetitionMap.containsKey(bite)) {
                        repetitionMap.put(bite, repetitionMap.get(bite) + 1);
                    } else {
                        repetitionMap.put(bite, 1);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (repetitionMap.size() <= 0) {
                return;
            } else {
                int max = Collections.max(repetitionMap.values());
                for (Map.Entry<Integer, Integer> pair : repetitionMap.entrySet()) {
                    if (pair.getValue().equals(max))
                        resultMap.put(this.fileName, pair.getKey());
                }
            }

            try {
                this.inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
