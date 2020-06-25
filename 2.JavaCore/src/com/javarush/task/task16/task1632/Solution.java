package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new MyThread1());
        threads.add(new MyThread2());
        threads.add(new MyThread3());
        threads.add(new MyThread4());
        threads.add(new MyThread5());

        //for (Thread t : threads) {
        //t.start();
        //}

        //threads.get(3).start();

        //threads.get(1).interrupt();
        //threads.get(3).showWarning();


    }

    public static void main(String[] args) {

    }

    public static class MyThread1 extends Thread {
        public void run() {
            while (true) {

            }
        }
    }

    public static class MyThread2 extends Thread {
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }

        }
    }

    public static class MyThread3 extends Thread {
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class MyThread4 extends Thread implements Message {
        public void run() {
            while(!this.isInterrupted()) {

            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class MyThread5 extends Thread {
        public void run() {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String line;
            ArrayList<Integer> sumArr = new ArrayList<Integer>();

            while (true) {
                try {
                    line = reader.readLine();
                    if (line.equals("N")) {
                        break;
                    }
                    Integer n = Integer.parseInt(line);
                    sumArr.add(n);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Integer sum = 0;
            for(Integer d : sumArr)
                sum += d;

            System.out.println(sum);

        }

    }
}