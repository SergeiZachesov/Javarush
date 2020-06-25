package com.javarush.task.task17.task1712;

public class Table {
    private static byte tableNumber; //10.1.6.1 Создание индекса столок
    private byte number = ++tableNumber; //10.1.6.2 Индексирование столов

    public Order getOrder () {
        return new Order(number);
    } //10.6.1 Создаем заказ для этого стола
}
