package com.javarush.task.task17.task1712;

public class Order {
    private long time;  //10.6.1.1 Время выполнения заказа
    private byte tableNumber;  //10.6.1.2 Номер столика

    public Order(byte tableNumber) {
        time = (long) (Math.random() * 200); //10.6.1.3 Вычисляем время
        this.tableNumber = tableNumber; //10.6.1.4 Присваеваем время выполнения к этому столу
    }

    public long getTime() {
        return time;
    }

    public byte getTableNumber() {
        return tableNumber;
    }
}
