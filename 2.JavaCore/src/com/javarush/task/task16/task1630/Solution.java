package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static {
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();

        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        String fullFileName="";
        String line ="";

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return line;
        }

        public void start(){
            run();
        }

        public void run() {

            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(this.fullFileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            BufferedReader readerLine = new BufferedReader(new InputStreamReader(inputStream));

            String lineBuff;
            try {
                while ((lineBuff = readerLine.readLine()) != null) {
                    this.line += lineBuff + " ";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

