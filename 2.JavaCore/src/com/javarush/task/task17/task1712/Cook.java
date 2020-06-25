package com.javarush.task.task17.task1712;

public class Cook implements Runnable {
    public boolean continueWorking = true; // 7 Объявление переменной продолжить работу = верно

    @Override
    public void run() {
        boolean needToWait; // 11.1 Нужно подождать
        while (continueWorking || needToCookOrders()) { // 11.2 Если работа продолжается или есть заказы
            try {
                synchronized (this) {
                    needToWait = !needToCookOrders(); // 11.3 Если есть заказы, то ждать не надо = false
                    if (!needToWait) {// 11.4 Если ждать не надо, то можно работать
                        cook(); // 11.5 Начинаем готовить
                    }
                }
                if (continueWorking && needToWait) {
                    System.out.println("Повар отдыхает");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean needToCookOrders() {
        return !Manager.getInstance().getOrderQueue().isEmpty(); // 11.1 Если есть заказы то правда
    }

    private void cook() throws InterruptedException {
        Manager manager = Manager.getInstance();  // 11.5.1 Сылка на менеджера
        Order order = manager.getOrderQueue().poll();      // повар берет заказ из очереди // 11.5.2 Повар берет и удаляет заказ
        System.out.println(String.format("Заказ будет готовиться %d мс для стола №%d", order.getTime(), order.getTableNumber())); // 11.5.3 Повар берет и удаляет заказ
        Thread.sleep(order.getTime());     // готовим блюдо 11.5.4 Повар готовит
        Dishes dishes = new Dishes(order.getTableNumber());       //  это готовое блюдо // готовим блюдо 11.5.4 Повар готовит блюдо
        manager.getDishesQueue().add(dishes);
        System.out.println(String.format("Заказ для стола №%d готов", dishes.getTableNumber()));
    }
}
