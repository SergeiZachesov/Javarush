package com.javarush.task.task17.task1712;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Manager {      //singleton
    private static Manager ourInstance = new Manager(); //10.1.1 Создание объекта менеджер

    private final List<Table> restaurantTables = new ArrayList<Table>(10); //10.1.2 Создание списка столов на 10 шутк
    private int currentIndex = 0; //10.1.3 Создание индекса

    private final Queue<Order> orderQueue = new ConcurrentLinkedQueue<Order>();        // очередь с заказами //10.1.4 Новая очередь заказов
    private final Queue<Dishes> dishesQueue = new ConcurrentLinkedQueue<Dishes>();     // очередь с готовыми блюдами //10.1.5 Новая очередь готовых блюд

    public synchronized static Manager getInstance() {
        return ourInstance;
    } // 10.1.7 Возврат объекта менеджер // 11.1.1 Возврат объекта менеджер   // 11.5.2.1 Возврат объекта менеджер

    private Manager() {               // создаем 10 столов //
        for (int i = 0; i < 10; i++) {
            restaurantTables.add(new Table()); // 10.1.6 Создание 10 столов и добавление в список
        }
    }

    public synchronized Table getNextTable() { // официант ходит по кругу от 1 стола к 10
        Table table = restaurantTables.get(currentIndex); // 10.5.1 Берем из списка стол
        currentIndex = (currentIndex + 1) % 10; // 10.5.2 Назначаем номер следующего стола
        return table; // 10.5.3 Возвращаем стол
    }

    public Queue<Order> getOrderQueue() {
        return orderQueue;
    } //10.7.1 Список заказов 11.1.2 Список заказов

    public Queue<Dishes> getDishesQueue() {
        return dishesQueue;
    } // 10.2.1 Очередь готовых блюд
}
