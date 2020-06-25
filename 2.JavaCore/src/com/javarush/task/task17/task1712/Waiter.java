package com.javarush.task.task17.task1712;

public class Waiter implements Runnable {
    public boolean continueWorking = true; // 3 инициализация продолжайте работать=правда

    @Override
    public void run() {
        Manager manager = Manager.getInstance(); // 10.1 Создание объекта менеджер

        while (continueWorking || !manager.getDishesQueue().isEmpty()) { // 10.2 Если работа продолжается(отменяется в мейне) или если есть еще очередь из готовых блюд (список не пуст)
            if (!manager.getDishesQueue().isEmpty()) {       //относим готовый заказ //10.3 если есть еще очередь из готовых блюд (список не пуст)
                Dishes dishes = manager.getDishesQueue().poll(); //10.4 Берем из очереди первое блюдо и удаляем его в списке
                System.out.println("Официант отнес заказ для стола №" + dishes.getTableNumber());//10.4 Относим его на номер столика
            } else {                                         //берем новый заказ
                Table table = manager.getNextTable();     //10.5 Идем к конкретному столу из списка
                Order order = table.getOrder(); //10.6 Создаем заказ для этого стола
                System.out.println("Получен заказ от стола №" + order.getTableNumber()); //10.7 Получаем заказ
                manager.getOrderQueue().add(order); //10.7 Добавление заказа в список
            }
            try {
                Thread.sleep(100);  //walking to the next table //10.8 Официант отдыхает между действиями
            } catch (InterruptedException e) {
            }
        }
    }
}
