package com.javarush.task.task15.task1530;

public class TeaMaker extends DrinkMaker {

    @Override
    void getRightCup() {
        System.out.print("Берем чашку для чая");
    }

    @Override
    void putIngredient() {
        System.out.print("Насыпаем чай");
    }

    @Override
    void pour() {
        System.out.print("Заливаем кипятком");
    }
}
