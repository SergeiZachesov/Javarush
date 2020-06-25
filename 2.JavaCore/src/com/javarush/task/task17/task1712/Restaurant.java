package com.javarush.task.task17.task1712;

import java.util.ArrayList;
import java.util.List;

/* 
Ресторан
*/

public class Restaurant {
    public static List<Thread> threads = new ArrayList<>(); // 1 Создание списка потоков

    public static void main(String[] args) throws Exception {
        Waiter waiterTarget = new Waiter(); // 2 Создание объекта Официант
        Thread waiter = new Thread(waiterTarget); // 4 Создание потока Официант
        threads.add(waiter); //5 Добавление потока в список

        Cook cookTarget = new Cook(); // 6 Создание нового объекта Повар
        Thread cook = new Thread(cookTarget); //8 Создание потока Повар
        threads.add(cook);// 9 Добавление потока в список

        waiter.start(); // 10 Запуск потока Официант
        cook.start(); // 11 Запуск потока Повар

        Thread.sleep(2000); //11 Главный поток спит
        cookTarget.continueWorking = false; //12 переменной продолжить работу = неверно
        Thread.sleep(500); //13 Главный поток спит
        waiterTarget.continueWorking = false; //14 переменной продолжить работу = неверно
    }
}
